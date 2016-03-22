package com.shanshan.flightmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class FlightBrowsing extends AppCompatActivity {

    /*
     * RecyclerView 控件注册
     * private RecyclerView fbRecyclerView;
     * private RecyclerView.LayoutManager fbLayoutManager;
     * private RecyclerView.Adapter fbAdapter;
     */

    public List<testData> testDataList = new ArrayList<testData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_browsing);
        //TODO: 2016/3/9 Toolbar代码块:Toolbar定义未完成
        //实例化Toolbar
        Toolbar fbToolbar = (Toolbar) findViewById(R.id.fb_toolbar);
        setSupportActionBar(fbToolbar);

        initTestData();//初始化listView测试数据
        //实例化数据适配器
        testDataAdapter adapter = new testDataAdapter(FlightBrowsing.this, R.layout.item_flight_view
                    , testDataList);
        //listView实例化
        ListView dUsrListView = (ListView) findViewById(R.id.userlistView);
        dUsrListView.setAdapter(adapter);
        //注册ListView点击事件
        dUsrListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                testData testData = testDataList.get(position);
                //点击后跳转到详细航班信息页面
                Intent intent = new Intent(FlightBrowsing.this, FlightDetails.class);
                startActivity(intent);
            }
        });

        // TODO: 2016/3/10 暂时将recyclerView换为listView，中期答辩后进一步深化recyclerView的使用
        /**
         * //试使用一个initViews函数封装所有View的id绑定
        、、initViews();
        fbRecyclerView = (RecyclerView) findViewById(R.id.RecycleView);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        fbRecyclerView.setHasFixedSize(true);
        // 创建默认的线性LayoutManager
        fbLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        fbRecyclerView.setLayoutManager(fbLayoutManager);
        //创建并设置适配器
        fbAdapter = new RecyclerViewAdapterForFB(this, testData);
        //fbRecyclerView.setAdapter(fbAdapter = new MyAdapter(initData()));*/




    }//onCreate's END


    //自定义测试用初始化数据
    private void initTestData() {

        testData first = new testData("北京", "上海", "8:06", "10:38", "杭州");
        testDataList.add(first);
        testData second = new testData("深圳", "上海", "8:06", "10:38", "南昌");
        testDataList.add(second);
        testData first3 = new testData("北京", "九龙", "14:06", "15:58", "长沙");
        testDataList.add(first3);
        testData first4 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first4);
        testData first5 = new testData("西藏", "上海", "10:06", "10:38", "南昌");
        testDataList.add(first5);
        testData first6 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first6);
        testData first7 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first7);
        testData first8 = new testData("深圳", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first8);
        testData first9 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first9);
        testData first10 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first10);
        testData first11 = new testData("西藏", "上海", "10:06", "10:38", "南昌");
        testDataList.add(first11);
        testData first12 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first12);
        testData first13 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first13);
        testData first14 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first14);
        testData first15 = new testData("深圳", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first15);
        testData first16 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first16);
        testData first17 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first17);
        testData first18 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first18);
        testData first19 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first19);
        testData first20 = new testData("北京", "上海", "8:06", "10:38", "南昌");
        testDataList.add(first20);


    }

//    private void initViews() {
//        fbRecyclerView = (RecyclerView) findViewById(R.id.RecycleView);
//    }

    //测试数据适配器,适配于ListView
    public class testDataAdapter extends ArrayAdapter<testData>{

        private int resourceId;

    public testDataAdapter(Context context, int resource, List<com.shanshan.flightmanager.testData> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    //
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        testData testData = getItem(position);//获取当前项testData的实例
        //优化getViee()
        View view;
        if ( convertView == null ){
            //将子项加载入布局
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        }else{
            view = convertView;
        }
        TextView dwhereFrom = (TextView) view.findViewById(R.id.where_from);
        TextView dwhereTo = (TextView) view.findViewById(R.id.where_to);
        TextView dtimeBegin = (TextView) view.findViewById(R.id.time_begin);
        TextView dtimeEnd = (TextView) view.findViewById(R.id.time_end);
        TextView dtransCity = (TextView) view.findViewById(R.id.trans_city);
        dwhereFrom.setText(testData.getWhereFrom());
        dwhereTo.setText(testData.getWhereTo());
        dtimeBegin.setText(testData.getTimeBegin());
        dtimeEnd.setText(testData.getTimeEnd());
        dtransCity.setText(testData.getTransCity());
        return view;
    }
}

    //toolbar设置
    private void setSupportActionBar(Toolbar fbtoolbar) {

        //fbtoolbar.setNavigationIcon(R.drawable.perm_group_personal_info);
    }
}


