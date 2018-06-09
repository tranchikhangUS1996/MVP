package com.example.lap60020_local.retrofit.Loader;

import com.example.lap60020_local.retrofit.Model.Data.MovieResponde;
import com.example.lap60020_local.retrofit.Model.Data.MyApi;
import com.example.lap60020_local.retrofit.Model.Data.MyApiClient;

import retrofit2.Call;

public class NowPlayingLoader implements MyLoader {
    @Override
    public Call<MovieResponde> load(MyApi api, int page) {
        return api.getNowPlayingMovies(page, MyApiClient.MY_KEY);
    }

}
