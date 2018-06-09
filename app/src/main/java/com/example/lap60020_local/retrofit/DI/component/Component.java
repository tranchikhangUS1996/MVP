package com.example.lap60020_local.retrofit.DI.component;

import com.example.lap60020_local.retrofit.DI.Module.MyAdapterModule;
import com.example.lap60020_local.retrofit.MyApplication;
import com.example.lap60020_local.retrofit.UI.DetailActivity;
import com.example.lap60020_local.retrofit.UI.MyAdapter;

import javax.inject.Singleton;

@Singleton
@dagger.Component(modules = {MyAdapterModule.class})
public interface Component {
    void inject(MyAdapter adapter);
    void inject(DetailActivity detailActivity);
    void inject(MyApplication application);
}
