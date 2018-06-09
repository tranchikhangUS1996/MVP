package com.example.lap60020_local.retrofit.DI.component;

import com.example.lap60020_local.retrofit.DI.Module.AdapterModule;
import com.example.lap60020_local.retrofit.UI.NowPlayingFragment;
import com.example.lap60020_local.retrofit.UI.PopularFragment;
import com.example.lap60020_local.retrofit.UI.SearchFragment;
import com.example.lap60020_local.retrofit.UI.TopRatedFragment;
import com.example.lap60020_local.retrofit.UI.UpComingFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AdapterModule.class)
public interface FragmentComponent {

    void inject(PopularFragment fragment);
    void inject(TopRatedFragment fragment);
    void inject(UpComingFragment fragment);
    void inject(NowPlayingFragment fragment);
    void inject(SearchFragment fragment);
}
