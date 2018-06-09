package com.example.lap60020_local.retrofit.Presenter;

import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.UI.IView;

import java.util.List;

public interface IPresenter {
    void loadMore(int Threshold, int lastVisibleItem);
    void notifyDataCompleted(List<Movie> movies, int threshold, int limit );
    void removeLoading();
    void notifyError();
    void notifyLoadMoreDataCompleted(List<Movie> movies, int thres, int limit);
    void attach(IView view);
    void detach();
}
