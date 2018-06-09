package com.example.lap60020_local.retrofit.Model;

import com.example.lap60020_local.retrofit.Loader.MyLoader;
import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.Presenter.IPresenter;

import java.util.List;

public interface IModel {

    void load(int page);

    void loadMore(int page);

    List<Movie> getData();

    void setPresenter(IPresenter presenter);

    void setLoader(MyLoader loader);
}