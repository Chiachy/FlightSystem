package com.shanshan.flightmanager;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toolbar;

public class ActivityFlightDetails extends Activity {

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_flight_details);

        mToolBar = (Toolbar) findViewById(R.id.flight_details_toolbar);
        mToolBar.setTitleTextColor(Color.parseColor("#ffffff"));
        setActionBar(mToolBar);



    }
}
