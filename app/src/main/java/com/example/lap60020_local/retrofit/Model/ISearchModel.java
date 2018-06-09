package com.example.lap60020_local.retrofit.Model;

import com.example.lap60020_local.retrofit.Loader.ISearchLoader;
import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.Presenter.IPresenter;

import java.util.List;

public interface ISearchModel {

    void query(String squery, int page);

    void queryMore(String query, int page);

    List<Movie> getData();

    void setPresenter(IPresenter presenter);

    void setLoader(ISearchLoader loader);
}
