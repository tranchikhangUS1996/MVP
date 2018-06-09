package com.example.lap60020_local.retrofit;

import android.content.Intent;
import android.view.View;

import com.example.lap60020_local.retrofit.UI.DetailActivity;

public class MyclickListener implements View.OnClickListener {
    private Integer id;
    public MyclickListener(Integer id) {
        this.id = id;
    }

    @Override
    public void onClick(View v) {
        // open detail
        Intent intent = new Intent(v.getContext(),DetailActivity.class);
        intent.putExtra("ID",id);
        v.getContext().startActivity(intent);
    }
}
