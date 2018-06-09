package com.example.lap60020_local.retrofit.Loader;

import com.example.lap60020_local.retrofit.Model.Data.MovieResponde;
import com.example.lap60020_local.retrofit.Model.Data.MyApi;
import com.example.lap60020_local.retrofit.Model.Data.MyApiClient;

import retrofit2.Call;

public class SearchLoader implements ISearchLoader {
    @Override
    public Call<MovieResponde> query(MyApi api, int page, String squery) {
        return api.getSearchMovies(squery,page, MyApiClient.MY_KEY);
    }
}
