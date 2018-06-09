package com.example.lap60020_local.retrofit.DI.Module;

import com.example.lap60020_local.retrofit.Loader.NowPlayingLoader;
import com.example.lap60020_local.retrofit.Loader.PopularLoader;
import com.example.lap60020_local.retrofit.Loader.SearchLoader;
import com.example.lap60020_local.retrofit.Loader.TopRatedLoader;
import com.example.lap60020_local.retrofit.Loader.UpcomingLoader;
import com.example.lap60020_local.retrofit.Model.Data.Movie;
import com.example.lap60020_local.retrofit.Model.Data.MyApi;
import com.example.lap60020_local.retrofit.Model.Data.MyApiClient;
import com.example.lap60020_local.retrofit.Model.IModel;
import com.example.lap60020_local.retrofit.Model.ISearchModel;
import com.example.lap60020_local.retrofit.Model.SearchModel;
import com.example.lap60020_local.retrofit.Model.mModel;
import com.example.lap60020_local.retrofit.Presenter.IsearchPresenter;
import com.example.lap60020_local.retrofit.Presenter.SearchPresenter;
import com.example.lap60020_local.retrofit.Presenter.mIPresenter;
import com.example.lap60020_local.retrofit.Presenter.mPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MyAdapterModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return MyApiClient.getInstance();
    }

    @Provides
    public List<Movie> provideList() {
        return new ArrayList<>();
    }

    @Provides
    public MyApi provideApi(Retrofit retrofit) {
        return retrofit.create(MyApi.class);
    }

    @Provides
    @Named("pop")
    @Singleton
    public mIPresenter providePopularPresenter(PopularLoader popularLoader, IModel model) {
        return new mPresenter(popularLoader, model);
    }

    @Provides
    @Named("top")
    @Singleton
    public mIPresenter provideTopPresenter(TopRatedLoader topRatedLoader, IModel model) {
        return new mPresenter(topRatedLoader, model);
    }

    @Provides
    @Named("now")
    @Singleton
    public mIPresenter provideNowPresenter(NowPlayingLoader nowPlayingLoader, IModel model) {
        return new mPresenter(nowPlayingLoader, model);
    }

    @Provides
    @Named("up")
    @Singleton
    public mIPresenter provideUpPresenter(UpcomingLoader upcomingLoader, IModel model) {
        return new mPresenter(upcomingLoader, model);
    }

    @Provides
    @Named("search")
    @Singleton
    public IsearchPresenter provideSearchPresenter(SearchLoader searchLoader, ISearchModel model) {
        return new SearchPresenter(searchLoader, model);
    }

    @Provides
    public IModel provideModel(List<Movie> list, MyApi api) {
        return new mModel(list, api);
    }

    @Provides
    public ISearchModel provideSearchModel(List<Movie> list, MyApi api) {
        return new SearchModel(list, api);
    }

    @Provides
    public PopularLoader providePopularloader() {
        return new PopularLoader();
    }

    @Provides
    public TopRatedLoader provideTopRatedLoader() {
        return new TopRatedLoader();
    }

    @Provides
    public UpcomingLoader provideUpcommingLoader() {
        return new UpcomingLoader();
    }

    @Provides
    public NowPlayingLoader provideNowPlayingLoader() {
        return new NowPlayingLoader();
    }

    @Provides
    public SearchLoader provideSearchLoader() {
        return new SearchLoader();
    }
}
