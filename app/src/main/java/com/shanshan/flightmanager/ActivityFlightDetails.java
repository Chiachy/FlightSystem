package com.shanshan.flightmanager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

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
    private FlightDatas datas;

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
        mBookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((FlightSystemApplication) getApplication()).getIsLogin()) {
                    List<OrderDatas> orderDatases = FlightManagerDB.getInstance(ActivityFlightDetails.this)
                            .searchOrderDatas(ActivityUserDetails.id);
                    for (OrderDatas orderDatas : orderDatases) {
                        if (orderDatas.getFlight_number().equals(datas.getId())) {
                            Toast.makeText(ActivityFlightDetails.this, "您已经预定过本次航班", Toast.LENGTH_LONG).show();
                            finish();
                            return;
                        }
                    }
                    FlightManagerDB.getInstance(ActivityFlightDetails.this)
                            .saveOrderData(new OrderDatas(ActivityUserDetails.id, datas.getId(), 100));
                    Toast.makeText(ActivityFlightDetails.this, "下单成功", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(ActivityFlightDetails.this, "请先登陆", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ActivityFlightDetails.this,ActivityUserLogin.class);
                    startActivity(intent);
                }
            }
        });
        if (getIntent().getBooleanExtra("isSearchResult",false)) {
            datas = SearchResultAdapter.mDatas.get(getIntent().getIntExtra("id",0));
        } else {
            datas = RecycleViewAdapter.mDatas.get(getIntent().getIntExtra("id", 0));
        }
        mConpanyName.setText(datas.getCompanyId());
        mFlightNumber.setText(datas.getId());
        mDay.setText(datas.getDay());
        mTimeBegin.setText(datas.getTimeBegin());
        mTimeEnd.setText(datas.getTimeEnd());
        mWhereFrom.setText(datas.getWhereFrom());
        mWhereTo.setText(datas.getWhereTo());
    }
}
