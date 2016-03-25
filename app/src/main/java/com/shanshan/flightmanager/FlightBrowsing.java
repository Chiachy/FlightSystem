package com.shanshan.flightmanager;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    private List<testData> testDataList = new ArrayList<testData>();
    private FloatingActionButton flightBroChooseButton;
    private RecyclerView userListView;
    private recycleViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_browsing);
        //TODO: 2016/3/9 Toolbar代码块:Toolbar定义未完成
        //实例化Toolbar
        Toolbar fbToolbar = (Toolbar) findViewById(R.id.fb_toolbar);
        setSupportActionBar(fbToolbar);
        initTestData();//初始化listView测试数据
        initViews();//初始化RecycleView
        mAdapter = new recycleViewAdapter(this , testDataList);
        userListView.setAdapter(mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL , false);
        userListView.setLayoutManager(linearLayoutManager);
        flightBroChooseButton = (FloatingActionButton) findViewById(R.id.flight_bro_choose_button);
        flightBroChooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //绘制分割线
        DividerLine recycViewDividerLine = new DividerLine(DividerLine.HORIZONTAL);
        recycViewDividerLine.setSize(15);
        recycViewDividerLine.setColor(0xFFDDDDDD);
        userListView.addItemDecoration(recycViewDividerLine);
    }

    /**
     * 初始化View
     * */
    private void initViews() {
        userListView = (RecyclerView) findViewById(R.id.userlistView);
    }

    /**
     * toolbar设置
     * */
    private void setSupportActionBar(Toolbar fbtoolbar) {

        //fbtoolbar.setNavigationIcon(R.drawable.perm_group_personal_info);
    }

    /**
     * RecycleView 分割线装饰类
     */
    public class DividerLine extends RecyclerView.ItemDecoration {
        public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;

        public static final int VERTICAL = LinearLayoutManager.VERTICAL;

        private Paint paint;//画笔

        private int orientation;//布局方向

        private int color;//分割线颜色

        private int size;//分割线尺寸

        //分割线尺寸
        public DividerLine(){
            this(VERTICAL);
        }

        public DividerLine(int orientation){
            this.orientation = orientation;
            paint = new Paint();
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDrawOver(c, parent, state);

            if (orientation == VERTICAL) {
                drawHorizontal(c, parent);
            } else {
                drawHorizontal(c, parent);
            }
        }

        /*
        * 设置分割线
        *
        * @param color 颜色
        * */
        public void setColor(int color) {
            this.color = color;
            paint.setColor(color);
        }

        /*
        *设置分割线尺寸
        *
        * @param size 尺寸
        * */
        public void setSize(int size){
            this.size = size ;
        }

        /*
        * 绘制垂直分割线
        * */
        protected void drawVertical(Canvas c, RecyclerView parent){
            final int top = parent.getPaddingTop();
            final int bottom = parent.getHeight() - parent.getPaddingBottom();

            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount ; i++){
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                final int left = child.getRight() + params.rightMargin;
                final int right = left + size ;

                c.drawRect(left , top , right , bottom, paint);
            }

        }
        //绘制水平风格线
        private void drawHorizontal(Canvas c, RecyclerView parent) {
            final int left = parent.getPaddingLeft();
            final int right = parent.getWidth() - parent.getPaddingRight();

            final int childCount = parent.getChildCount();
            for(int i= 0; i < childCount ; i++){
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + size ;

                c.drawRect(left , top , right , bottom, paint);
            }
        }
    }

    /**
     * 自定义测试用初始化数据,实现SQLite后弃用
     * */
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


//    //测试数据适配器,适配于ListView
//    public class testDataAdapter extends ArrayAdapter<testData>{
//
//        private int resourceId;
//
//    public testDataAdapter(Context context, int resource, List<com.shanshan.flightmanager.testData> objects) {
//        super(context, resource, objects);
//        resourceId = resource;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        testData testData = getItem(position);//获取当前项testData的实例
//        //优化getViee()
//        View view;
//        if ( convertView == null ){
//            //将子项加载入布局
//            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
//        }else{
//            view = convertView;
//        }
//        TextView dwhereFrom = (TextView) view.findViewById(R.id.where_from);
//        TextView dwhereTo = (TextView) view.findViewById(R.id.where_to);
//        TextView dtimeBegin = (TextView) view.findViewById(R.id.time_begin);
//        TextView dtimeEnd = (TextView) view.findViewById(R.id.time_end);
//        TextView dtransCity = (TextView) view.findViewById(R.id.trans_city);
//        dwhereFrom.setText(testData.getWhereFrom());
//        dwhereTo.setText(testData.getWhereTo());
//        dtimeBegin.setText(testData.getTimeBegin());
//        dtimeEnd.setText(testData.getTimeEnd());
//        dtransCity.setText(testData.getTransCity());
//        return view;
//    }
//}

}

