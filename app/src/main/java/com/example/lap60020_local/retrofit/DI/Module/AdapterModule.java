package com.example.lap60020_local.retrofit.DI.Module;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.lap60020_local.retrofit.UI.MyAdapter;

import dagger.Module;
import dagger.Provides;


@Module
public class AdapterModule {
    private Context context;
    private RecyclerView recyclerView;

    public AdapterModule(Context context, RecyclerView recyclerView) {
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @Provides
    public MyAdapter provideAdapter(LinearLayoutManager linearLayoutManager) {
        recyclerView.setLayoutManager(linearLayoutManager);
        return new MyAdapter(context,recyclerView);
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public LinearLayoutManager provideLinearlayoutManager() {
        return new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
    }
}
