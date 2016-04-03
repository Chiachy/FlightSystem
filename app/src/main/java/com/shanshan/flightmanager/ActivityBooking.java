package com.shanshan.flightmanager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toolbar;

public class ActivityBooking extends Activity {

    private Toolbar mToolbar;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_booking);

        mToolbar = (Toolbar) findViewById( R.id.booking_toolbar );
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setActionBar(mToolbar);

        mButton = (Button) findViewById(R.id.button_booking);
    }
}
