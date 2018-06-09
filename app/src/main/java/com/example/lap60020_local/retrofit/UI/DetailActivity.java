package com.example.lap60020_local.retrofit.UI;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lap60020_local.retrofit.DI.Module.MyAdapterModule;
import com.example.lap60020_local.retrofit.DI.component.Component;
import com.example.lap60020_local.retrofit.DI.component.DaggerComponent;
import com.example.lap60020_local.retrofit.GlideApp;
import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.Model.Data.MyApi;
import com.example.lap60020_local.retrofit.Model.Data.MyApiClient;
import com.example.lap60020_local.retrofit.R;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    @Inject
    MyApi api;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        int id = getIntent().getExtras().getInt("ID");
        Component component = DaggerComponent
                .builder()
                .myAdapterModule(new MyAdapterModule())
                .build();
        component.inject(this);

        context = this;
        Call<Movie> call = api.getMovieDetails(id, MyApiClient.MY_KEY);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                if(movie!=null) {
                    setTitle(movie.getTitle());
                    TextView title = findViewById(R.id.detail_title);
                    TextView release = findViewById(R.id.detail_release);
                    TextView rate = findViewById(R.id.detail_rate);
                    TextView overview = findViewById(R.id.detail_overview);
                    ImageView poster = findViewById(R.id.detail_poster);
                    title.setText(movie.getTitle());
                    release.setText("Release: "+movie.getReleaseDate());
                    rate.setText("Rate: " +movie.getVoteAverage());
                    overview.setText(movie.getOverview());
                    String path = MyApiClient.IMAGE_PATH+movie.getBackdropPath();
                    GlideApp.with(context)
                            .load(Uri.parse(path))
                            .placeholder(R.drawable.placeholder)
                            .into(poster);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void detail_favourite(View view) {

    }
}
