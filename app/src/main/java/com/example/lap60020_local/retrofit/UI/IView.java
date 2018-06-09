package com.example.lap60020_local.retrofit.UI;

import com.example.lap60020_local.retrofit.Model.Data.Movie;

import java.util.List;

public interface IView {
    void receiveData(List<Movie> movies, int threshold);
    void receiveMoredata(List<Movie> movies, int threshold);
    void showmore(int oldThreshold ,int Threshold);
    void addLoading();
    void RemoveLoading();

    void restoreData(List<Movie> data, int curentThres);
}
