package com.shanshan.flightmanager;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

public class ActivityManagerView extends Activity {

    private Toolbar mToolBar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_manager_view);

        mToolBar = (Toolbar) findViewById(R.id.manager_view_toolbar);
        setActionBar(mToolBar);
        mToolBar.setTitleTextColor(Color.parseColor("#ffffff"));

        mRecyclerView = (RecyclerView) findViewById(R.id.manager_recyclerview);

    }

}
