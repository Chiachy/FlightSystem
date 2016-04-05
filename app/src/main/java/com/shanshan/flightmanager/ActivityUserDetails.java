package com.shanshan.flightmanager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityUserDetails extends Activity {

    final FlightSystemApplication application = (FlightSystemApplication) getApplication();

    private RecyclerView mRecyclerView;
    private OrderAdapter orderAdapter;
    private Button mButton;

    public static String id;
    private UserDatas userDatas;
    private TextView name;
    private TextView userId;
    private TextView sex;
    private TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_user_details);
        userDatas = FlightManagerDB.getInstance(this).searchUser(id);
        name = (TextView) findViewById(R.id.user_name);
        userId = (TextView) findViewById(R.id.user_id);
        sex = (TextView) findViewById(R.id.user_sex);
        age = (TextView) findViewById(R.id.user_age);
        name.setText(userDatas.getName());
        if (userDatas.getSex().equals("男")) {
            sex.setText("先生");
        } else {
            sex.setText("女士");
        }
        userId.setText(userDatas.getId());
        age.setText(String.valueOf(userDatas.getAge()));

        mButton = (Button) findViewById(R.id.exit_login);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(application.getIsLogin()){
                    application.setIsLogin(false);
                    finish();
                }
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.user_details);

        //mAdapters = new recycleViewAdapter(this, );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL , false);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setHasFixedSize(true);//提高性能

        orderAdapter = new OrderAdapter(this,FlightManagerDB.getInstance(this).searchOrderDatas(userDatas.getId()));

        mRecyclerView.setAdapter(orderAdapter);

        if (orderAdapter.getItemCount() != 0) {
            TextView textView = (TextView) findViewById(R.id.list_info);
            textView.setVisibility(View.GONE);
        }
    }



    private class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<OrderDatas> orderDatasList = new ArrayList<>();
        private Context context;
        private LayoutInflater inflater;

        public OrderAdapter(Context context,List<OrderDatas> datasList) {
            orderDatasList = datasList;
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHodler(inflater.inflate(R.layout.item_order_list,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyViewHodler)holder).orderInfo.setText(String.valueOf(orderDatasList.get(position).getId()));
            ((MyViewHodler)holder).flightNumber.setText(orderDatasList.get(position).getFlight_number());
        }

        @Override
        public int getItemCount() {
            return orderDatasList.size();
        }

        private class MyViewHodler extends RecyclerView.ViewHolder {

            TextView orderInfo;
            TextView flightNumber;

            public MyViewHodler(View itemView) {
                super(itemView);
                orderInfo = (TextView) itemView.findViewById(R.id.orderInfo);
                flightNumber = (TextView) itemView.findViewById(R.id.flight_number);
            }
        }
    }

}
