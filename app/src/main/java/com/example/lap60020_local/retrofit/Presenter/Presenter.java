package com.example.lap60020_local.retrofit.Presenter;

import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.UI.IView;

import java.util.List;

public abstract class Presenter implements IPresenter {
    IView MyView;
    int page;
    int limit;
    boolean isLoading;
    int total;
    int curentThres;
    final int NSHOW = 10;

    public Presenter() {
        page = 1;
        limit = 1;
        total = 0;
    }

    @Override
    public void attach(IView view) {
        MyView = view;
    }

    @Override
    public void detach() {
        MyView = null;
    }

    @Override
    public void notifyDataCompleted(List<Movie> movies, int threshold, int limit) {
        isLoading = false;
        if(MyView !=null ) {
            this.limit = limit;
            total = threshold;
            MyView.RemoveLoading();
            threshold = threshold > NSHOW ? NSHOW : threshold;
            MyView.receiveData(movies, threshold);
        }
    }

    @Override
    public void removeLoading() {
        if(MyView !=null ) {
            MyView.RemoveLoading();
        }
    }

    @Override
    public void notifyError() {

    }

    @Override
    public void notifyLoadMoreDataCompleted(List<Movie> movies, int thres, int limit) {
        isLoading = false;
        if(MyView !=null ) {
            int old = total;
            total += thres;
            thres = thres > NSHOW ? old + NSHOW : total;
            MyView.receiveMoredata(movies, thres);
        }
    }


}
