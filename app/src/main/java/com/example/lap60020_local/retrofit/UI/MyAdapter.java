package com.example.lap60020_local.retrofit.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lap60020_local.retrofit.DI.Module.MyAdapterModule;
import com.example.lap60020_local.retrofit.DI.component.DaggerComponent;
import com.example.lap60020_local.retrofit.GlideApp;
import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.Model.Data.MyApiClient;
import com.example.lap60020_local.retrofit.MyclickListener;
import com.example.lap60020_local.retrofit.Presenter.IPresenter;
import com.example.lap60020_local.retrofit.R;

import java.util.List;

import javax.inject.Inject;


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements IView {


    private final int LOADING = 1001;
    private final int CARD = 1002;
    private final RecyclerView recyclerView;
    private Context context;
    @Inject
    List<Movie> MoviesFilterd;
    private LinearLayoutManager linearLayoutManager;
    private IPresenter Mypresenter;
    private int Threshold = 0;


    public MyAdapter(Context context, RecyclerView recyclerView)  {
        this.context = context;
        this.recyclerView = recyclerView;
        // inject
        DaggerComponent.builder()
                .myAdapterModule(new MyAdapterModule())
                .build()
                .inject(this);

        linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        // set scroll
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                Mypresenter.loadMore(Threshold,lastVisibleItem);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
    }

    public void setPresenter(IPresenter presenter) {
        this.Mypresenter = presenter;
    }

    @Override
    public void receiveData(List<Movie> movies, int threshold) {
        this.MoviesFilterd = movies;
        this.Threshold = threshold;
        if(Threshold==0) {
            recyclerView.setBackgroundResource(R.drawable.background);
        }
        else {
            recyclerView.setBackgroundColor(Color.WHITE);
        }
        notifyDataSetChanged();
    }

    @Override
    public void receiveMoredata(List<Movie> movies, int threshold) {
            this.MoviesFilterd = movies;
            int oldThreshold = this.Threshold;
            Threshold = threshold;
            notifyItemRangeInserted(oldThreshold,Threshold-oldThreshold);
    }

    @Override
    public void showmore(int oldThreshold , int threshold) {
        this.Threshold = threshold;
        notifyItemRangeInserted(oldThreshold, threshold);
    }

    @Override
    public void addLoading() {
        MoviesFilterd.add(null);
        Threshold++;
        notifyItemRangeInserted(MoviesFilterd.size()-1,1);
    }

    @Override
    public void RemoveLoading() {
        MoviesFilterd.remove(MoviesFilterd.size()-1);
        Threshold--;
        notifyItemRemoved(MoviesFilterd.size());
    }

    @Override
    public void restoreData(List<Movie> data, int curentThres) {
        MoviesFilterd = data;
        Threshold = curentThres;
        if(Threshold==0) {
            recyclerView.setBackgroundResource(R.drawable.background);
        }
        else {
            recyclerView.setBackgroundColor(Color.WHITE);
        }
        notifyDataSetChanged();
        notifyItemRangeChanged(curentThres,1);
    }

    class LoadingHolder extends RecyclerView.ViewHolder{
        LoadingHolder(View itemView) {
            super(itemView);
            ProgressBar progressBar = itemView.findViewById(R.id.loading_progressbar);
            progressBar.setIndeterminate(true);
        }
    }

    class MyHolder extends RecyclerView.ViewHolder{

        public ImageView poster;
        TextView release;
        TextView movieTitle;
        public TextView overView;
        public CardView card;
        public TextView rate;

        MyHolder(CardView itemView) {
            super(itemView);
            card =  itemView;
            poster = itemView.findViewById(R.id.poster);
            release = itemView.findViewById(R.id.date);
            movieTitle = itemView.findViewById(R.id.title);
            overView = itemView.findViewById(R.id.overView);
            rate = itemView.findViewById(R.id.rate);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(MoviesFilterd.get(position)==null) return LOADING;
        return CARD;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==LOADING) {
            View v = LayoutInflater.from(context)
                    .inflate(R.layout.loading_layout,parent,false);
            return new LoadingHolder(v);
        } else {
            CardView cardView = (CardView) LayoutInflater.from(context)
                    .inflate(R.layout.card_view, parent, false);
            return new MyHolder(cardView);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderinput, int position) {
        Movie movie = MoviesFilterd.get(position);
        // set data card
        if(holderinput instanceof MyHolder) {
            MyHolder holder = (MyHolder) holderinput;
            holder.movieTitle.setText(movie.getTitle());
            holder.release.setText(movie.getReleaseDate());
            String over = movie.getOverview();
            int length = over.length();
            try {
                if(length > 100) {
                    String description = over.substring(0, 100 - 1).concat("...");
                    holder.overView.setText(description);
                } else {
                    holder.overView.setText(over);
                }
            } catch(Exception e) {
                Log.d("Error",e.getMessage()
                        + movie.getTitle()
                        + " length = "
                        + String.valueOf(over.length()));
            }
            holder.rate.setText("Rate: " + String.valueOf(movie.getVoteAverage()));
            //
            String imagePath = MyApiClient.IMAGE_PATH + movie.getPosterPath();
            GlideApp.with(context)
                    .load(Uri.parse(imagePath))
                    .placeholder(R.drawable.placeholder)
                    .into(holder.poster);
            // sets clicklistener for each items
            holder.card.setOnClickListener(new MyclickListener(movie.getId()));
        }
    }

    @Override
    public int getItemCount() {
        return Threshold;
    }

}
