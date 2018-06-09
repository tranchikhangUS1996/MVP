package com.example.lap60020_local.retrofit.Model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.Model.Data.MovieResponde;
import com.example.lap60020_local.retrofit.Presenter.IPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model {

    // list movie which loads from internet
    private List<Movie> Movies;
    // presenter controls loading data and updating the UI
    private IPresenter presenter;


    public Model(List<Movie> list) {
        this.Movies = list;
    }

    public void setPresenter(IPresenter presenter) {
        this.presenter = presenter;
    }

    public void modelload(Call<MovieResponde> call) {
            call.enqueue(new Callback<MovieResponde>() {
                @Override
                public void onResponse(@NonNull Call<MovieResponde> call, @NonNull Response<MovieResponde> response) {
                    try {
                        List<Movie> list = response.body().getResults();
                        int limit = response.body().getTotalPages();
                        Movies = list;
                        // update
                        presenter.notifyDataCompleted(Movies, list.size(),limit);
                    }catch (NullPointerException e) {
                        Log.e("Model",e.getMessage());
                        presenter.notifyError();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<MovieResponde> call, @NonNull Throwable t) {
                    presenter.notifyError();
                }
            });
        }


    public void modelloadMore(Call<MovieResponde> call) {

        call.enqueue(new Callback<MovieResponde>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponde> call, @NonNull Response<MovieResponde> response) {
                try {
                    List<Movie> list = response.body().getResults();
                    int limit = response.body().getTotalPages();
                    presenter.removeLoading();
                    Movies.addAll(list);
                    presenter.notifyLoadMoreDataCompleted(Movies, list.size(),limit);
                } catch (NullPointerException e) {
                    Log.e("Model", e.getMessage());
                    presenter.notifyError();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponde> call, @NonNull Throwable t) {
                presenter.notifyError();
            }
        });
    }

    public List<Movie> getData() {
        return Movies;
    }


}
