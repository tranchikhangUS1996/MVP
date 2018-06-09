package com.example.lap60020_local.retrofit.Loader;

import com.example.lap60020_local.retrofit.Model.Data.MovieResponde;
import com.example.lap60020_local.retrofit.Model.Data.MyApi;

import retrofit2.Call;

public interface ISearchLoader {
    Call<MovieResponde> query(MyApi api, int page, String squery);
}
