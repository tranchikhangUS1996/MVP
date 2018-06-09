package com.example.lap60020_local.retrofit.Model;

import com.example.lap60020_local.retrofit.Loader.ISearchLoader;
import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.Model.Data.MovieResponde;
import com.example.lap60020_local.retrofit.Model.Data.MyApi;

import java.util.List;

import retrofit2.Call;

public class SearchModel extends Model implements ISearchModel {


    private MyApi api;
    ISearchLoader loader;

    public SearchModel( List<Movie> list, MyApi api) {
        super(list);
        this.api = api;
    }

    @Override
    public void query(String query, int page) {
        Call<MovieResponde> call = loader.query(api,page,query);
        modelload(call);
    }

    @Override
    public void queryMore(String query, int page) {
        Call<MovieResponde> call = loader.query(api,page,query);
        modelloadMore(call);
    }

    @Override
    public void setLoader(ISearchLoader loader) {
        this.loader = loader;
    }
}
