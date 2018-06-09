package com.example.lap60020_local.retrofit.UI;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lap60020_local.retrofit.DI.Module.AdapterModule;
import com.example.lap60020_local.retrofit.DI.component.DaggerFragmentComponent;
import com.example.lap60020_local.retrofit.DI.component.FragmentComponent;
import com.example.lap60020_local.retrofit.MyApplication;
import com.example.lap60020_local.retrofit.Presenter.IsearchPresenter;
import com.example.lap60020_local.retrofit.R;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    @Inject
    MyAdapter adapter;
    private IsearchPresenter presenter;
    SearchView searchView;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_search, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.search_recyclerView);
        FragmentComponent component = DaggerFragmentComponent
                .builder()
                .adapterModule(new AdapterModule(getActivity().getApplicationContext(),recyclerView))
                .build();
        component.inject(this);
        presenter =  ((MyApplication) getActivity().getApplication()).getSearchPresenter();
        adapter.setPresenter(presenter);
        presenter.attach(adapter);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().postSticky(presenter);
        presenter.query(null);
    }
}
