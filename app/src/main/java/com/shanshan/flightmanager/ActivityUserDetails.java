package com.shanshan.flightmanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class ActivityUserDetails extends Activity {

    private RecyclerView mRecyclerView;
    private recycleViewAdapter mrecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_user_details);
    }
}
