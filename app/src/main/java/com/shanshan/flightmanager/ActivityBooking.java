package com.shanshan.flightmanager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toolbar;

public class ActivityBooking extends Activity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_booking);

        mToolbar = (Toolbar) findViewById( R.id.booking_toolbar );
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setActionBar(mToolbar);
    }
}
