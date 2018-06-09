package com.example.lap60020_local.retrofit;

import android.app.Application;

import com.example.lap60020_local.retrofit.DI.Module.MyAdapterModule;
import com.example.lap60020_local.retrofit.DI.component.Component;
import com.example.lap60020_local.retrofit.DI.component.DaggerComponent;
import com.example.lap60020_local.retrofit.Presenter.IsearchPresenter;
import com.example.lap60020_local.retrofit.Presenter.mIPresenter;

import javax.inject.Inject;
import javax.inject.Named;

public class MyApplication extends Application {

    private Component component;

    @Inject @Named("pop")
    mIPresenter PopularPresenter;

    @Inject @Named("top")
    mIPresenter TopRatedPresenter;

    @Inject @Named("now")
    mIPresenter NowPlayingPresenter;

    @Inject @Named("up")
    mIPresenter UpCommingPresenter;

    @Inject @Named("search")
    IsearchPresenter SearchPresenter;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerComponent.builder()
                .myAdapterModule(new MyAdapterModule())
                .build();
        component.inject(this);
    }

    public Component getComponent() {
        return component;
    }

    public mIPresenter getPopularPresenter() {
        return PopularPresenter;
    }

    public mIPresenter getTopRatedPresenter() {
        return TopRatedPresenter;
    }

    public mIPresenter getNowPlayingPresenter() {
        return NowPlayingPresenter;
    }

    public mIPresenter getUpCommingPresenter() {
        return UpCommingPresenter;
    }

    public IsearchPresenter getSearchPresenter() {
        return SearchPresenter;
    }
}
