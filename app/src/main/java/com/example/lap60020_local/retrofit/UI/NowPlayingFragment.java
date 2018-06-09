package com.example.lap60020_local.retrofit.UI;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lap60020_local.retrofit.DI.Module.AdapterModule;
import com.example.lap60020_local.retrofit.DI.component.DaggerFragmentComponent;
import com.example.lap60020_local.retrofit.DI.component.FragmentComponent;
import com.example.lap60020_local.retrofit.MyApplication;
import com.example.lap60020_local.retrofit.Presenter.IPresenter;
import com.example.lap60020_local.retrofit.Presenter.mIPresenter;
import com.example.lap60020_local.retrofit.R;

import javax.inject.Inject;



/**
 * A simple {@link Fragment} subclass.
 */
public class NowPlayingFragment extends Fragment {


    @Inject
    MyAdapter adapter;

    private IPresenter presenter;

    public NowPlayingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_now_playing, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.nowplaying_recyclerView);
        FragmentComponent component = DaggerFragmentComponent
                .builder()
                .adapterModule(new AdapterModule(getActivity().getApplicationContext(),recyclerView))
                .build();
        component.inject(this);
        presenter = ((MyApplication) getActivity().getApplication()).getNowPlayingPresenter();
        adapter.setPresenter(presenter);
        presenter.attach(adapter);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((mIPresenter) presenter).load();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detach();
    }

}
