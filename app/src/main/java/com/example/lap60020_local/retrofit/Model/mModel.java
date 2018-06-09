package com.example.lap60020_local.retrofit.Model;

import com.example.lap60020_local.retrofit.Loader.MyLoader;
import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.Model.Data.MovieResponde;
import com.example.lap60020_local.retrofit.Model.Data.MyApi;
import com.example.lap60020_local.retrofit.Presenter.IPresenter;

import java.util.List;

import retrofit2.Call;

public class mModel extends Model implements IModel {

    MyApi api;

    private MyLoader loader;

    public mModel( List<Movie> Movies, MyApi api) {
        super(Movies);
        this.api = api;
    }

    @Override
    public void load(int page) {
        Call<MovieResponde> call = loader.load(api,page);
        modelload(call);
    }

    @Override
    public void loadMore(int page) {
        Call<MovieResponde> call = loader.load(api,page);
        modelloadMore(call);
    }

    @Override
    public void setPresenter(IPresenter presenter) {
        super.setPresenter(presenter);
    }

    @Override
    public void setLoader(MyLoader loader) {
        this.loader = loader;
    }
}
