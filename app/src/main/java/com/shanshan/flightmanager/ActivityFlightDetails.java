package com.shanshan.flightmanager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class ActivityFlightDetails extends Activity {

    private Toolbar mToolBar;
    private TextView mConpanyName;
    private TextView mFlightNumber;
    private TextView mDay;
    private TextView mTimeBegin;
    private TextView mTimeEnd;
    private TextView mWhereFrom;
    private TextView mWhereTo;
    private Button mBookingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_flight_details);
        mToolBar = (Toolbar) findViewById(R.id.flight_details_toolbar);
        mToolBar.setTitleTextColor(Color.parseColor("#ffffff"));
        setActionBar(mToolBar);

        mConpanyName = (TextView) findViewById(R.id.company_id);
        mFlightNumber = (TextView) findViewById(R.id.flight_number);
        mDay = (TextView) findViewById(R.id.day);
        mTimeBegin = (TextView) findViewById(R.id.time_begin);
        mTimeEnd = (TextView) findViewById(R.id.time_end);
        mWhereFrom = (TextView) findViewById(R.id.where_from);
        mWhereTo = (TextView) findViewById(R.id.where_to);

        mBookingBtn = (Button) findViewById(R.id.booking_button);

    }
}
