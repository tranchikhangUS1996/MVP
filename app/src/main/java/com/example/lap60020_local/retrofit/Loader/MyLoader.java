package com.example.lap60020_local.retrofit.Loader;

import com.example.lap60020_local.retrofit.Model.Data.MovieResponde;
import com.example.lap60020_local.retrofit.Model.Data.MyApi;

import retrofit2.Call;

public interface MyLoader {
    Call<MovieResponde> load(MyApi api , int page);
}
