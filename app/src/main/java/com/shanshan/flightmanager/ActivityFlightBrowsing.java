package com.shanshan.flightmanager;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;
/**
 * A Flight Browsing User interface
 * 航班信息浏览界面，可以进行预定航班和查询、更改航班信息的操作，并登陆个人账号
 * */
public class ActivityFlightBrowsing extends AppCompatActivity {

    //public List<FlightDatas> FlightDatasList = new ArrayList<>();
    private FloatingActionButton flightBroChooseButton;
    private RecyclerView userListView;
    private RecycleViewAdapter mAdapter;
    private FlightDatas mFlightDatas = new FlightDatas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_browsing);

       // initFlightDatas4DB();
        /**Toolbar 配置代码块*/
        Toolbar fbToolbar = (Toolbar) findViewById( R.id.fb_toolbar );
        fbToolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setActionBar(fbToolbar);

        //绑定item的点击事件,并调用
        fbToolbar.setOnMenuItemClickListener( onMenuItemClickListener );

        /** recycleView 配置代码块 */
       // initFlightDatas();//初始化listView测试数据

        initViews();//初始化RecycleView

        mAdapter = new RecycleViewAdapter(this , mFlightDatas);

        userListView.setAdapter(mAdapter);

        //设置re-View的布局，并调用
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL , false);

        userListView.setLayoutManager(linearLayoutManager);

        userListView.setHasFixedSize(true);//提高性能

        //设置分割线属性，并调用
        DividerLine recycViewDividerLine = new DividerLine(DividerLine.HORIZONTAL);

        recycViewDividerLine.setSize(15);

        recycViewDividerLine.setColor(0xFFDDDDDD);

        userListView.addItemDecoration(recycViewDividerLine);

        mAdapter.setmOnItemClickListener(new RecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Intent intent = new Intent(ActivityFlightBrowsing.this, ActivityFlightDetails.class);
                //intent.putExtra()

                startActivity(intent);
            }
        });

        /** fab配置代码块 */
        flightBroChooseButton = (FloatingActionButton) findViewById(R.id.flight_bro_choose_button);
        flightBroChooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(ActivityFlightBrowsing.this , ActivityBooking.class);
                startActivity(intent);
            }
        });


    }

    /**
     * 初始化View
     * */
    private void initViews() {
        userListView = (RecyclerView) findViewById(R.id.userlistView);
    }

    /**
     * toolbar配置
     * */
    /*
    * 设置menu item的监听器
    * */
    private Toolbar.OnMenuItemClickListener onMenuItemClickListener =
            new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_sign_in: {
                    final FlightSystemApplication application = (FlightSystemApplication) getApplication();
                    if(!application.getIsLogin()){
                        startActivity(new Intent(
                                ActivityFlightBrowsing.this , ActivityUserLogin.class)
                        );
                    }else{
                        startActivity(new Intent(
                                ActivityFlightBrowsing.this , ActivityUserDetails.class)
                        );
                    }
                    break;
                }

                default:
                    break;
            }
            return false;
        }
    };

    /*
     * 此方法用于初始化菜单，其中menu参数就是即将要显示的Menu实例。
     * 返回true则显示该menu,false 则不显示;
     * (只会在第一次初始化菜单时调用)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
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
                final RecyclerView.LayoutParams params =
                        (RecyclerView.LayoutParams) child.getLayoutParams();
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
                final RecyclerView.LayoutParams params =
                        (RecyclerView.LayoutParams) child.getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + size ;

                c.drawRect(left , top , right , bottom, paint);
            }
        }
    }

    /**
     * 自定义数据,实现SQLite用
     * */
/*
    private void initFlightDatas() {

        FlightDatas first = new FlightDatas("四川航空", "3U8548" ,"北京", "上海", "8:06", "10:38",
                "杭州", "2016.03.11");
        FlightDatasList.add(first);

        FlightDatas first2 = new FlightDatas("南方航空", "CZ9902", "深圳", "上海", "8:06", "10:38",
                "南昌", "2016.03.21");
        FlightDatasList.add(first2);

        FlightDatas first3 = new FlightDatas("中国国航", "CA4194","北京", "九龙", "14:06", "15:58",
                "长沙","2016.03.38");
        FlightDatasList.add(first3);

        FlightDatas first4 = new FlightDatas("山东航空", "SC4194", "北京", "上海", "8:06", "10:38",
                "南昌", "2016.03.31");
        FlightDatasList.add(first4);

        FlightDatas first5 = new FlightDatas("西藏航空" ,"TV6102", "西藏", "上海", "10:06", "10:38",
                "南昌", "2016.03.23");
        FlightDatasList.add(first5);

        FlightDatas first6 = new FlightDatas("深圳航空", "ZH4194", "北京", "上海", "18:06", "21:38",
                "南昌", "2016.05.31");
        FlightDatasList.add(first6);

        FlightDatas first7 = new FlightDatas("四川航空" , "3U8896","北京", "上海", "8:06", "10:38",
                "南昌", "2016.03.16");
        FlightDatasList.add(first7);

        FlightDatas first8 = new FlightDatas("海南航空" , "HU7147", "深圳", "上海", "8:06", "10:38",
                "南昌", "2016.03.31");
        FlightDatasList.add(first8);

        FlightDatas first9 = new FlightDatas("海南航空", "HU7147", "北京", "上海", "8:06", "10:38",
                "南昌", "2016.05.30");
        FlightDatasList.add(first9);

        FlightDatas first10 = new FlightDatas("中国国航","CA1405", "北京", "上海", "8:06", "10:38",
                "南昌", "2016.02.18");
        FlightDatasList.add(first10);

        FlightDatas first11 = new FlightDatas("中国国航","CA1405","西藏", "上海", "11:06", "17:38",
                "南昌", "2016.02.21");
        FlightDatasList.add(first11);

        FlightDatas first12 = new FlightDatas("山东航空","SC1405","北京", "上海", "8:06", "10:38",
                "南昌", "2016.06.19");
        FlightDatasList.add(first12);

        FlightDatas first13 = new FlightDatas("西藏航空","TV6111","北京", "上海", "8:06", "10:38",
                "南昌", "2016.04.08");
        FlightDatasList.add(first13);

        FlightDatas first14 = new FlightDatas("深圳航空","ZH1405","北京", "上海", "8:06", "10:38",
                "南昌", "2016.02.18");
        FlightDatasList.add(first14);

        FlightDatas first15 = new FlightDatas("联合航空","KN5215","深圳", "上海", "14:06", "19:38",
                "南昌", "2016.03.01");
        FlightDatasList.add(first15);

        FlightDatas first16 = new FlightDatas("厦门航空","MF1836","北京", "上海", "8:06", "10:38",
                "南昌", "2016.07.18");
        FlightDatasList.add(first16);

        FlightDatas first17 = new FlightDatas("东方航空","MU3597","北京", "上海", "8:06", "10:38",
                "南昌", "2016.01.18");
        FlightDatasList.add(first17);

        FlightDatas first18 = new FlightDatas("深圳航空","ZH1415","北京", "上海", "8:06", "10:38",
                "南昌", "2016.06.28");
        FlightDatasList.add(first18);

        FlightDatas first19 = new FlightDatas("四川航空","3U8882","北京", "上海", "21:06", "22:38",
                "南昌", "2016.06.17");
        FlightDatasList.add(first19);

        FlightDatas first20 = new FlightDatas("东方航空","MU3561","北京", "上海", "8:06", "10:38",
                "南昌", "2016.02.18");
        FlightDatasList.add(first20);
    }
*/


    private void initFlightDatas4DB() {

        FlightManagerDB db = FlightManagerDB.getInstance(ActivityFlightBrowsing.this);

        FlightDatas first = new FlightDatas("四川航空", "3U8548" ,"北京", "上海", "8:06", "10:38",
                "杭州", "2016.03.11");
        db.saveFlightDatas(first);

        FlightDatas first2 = new FlightDatas("南方航空", "CZ9902", "深圳", "上海", "8:06", "10:38",
                "南昌", "2016.03.21");
        db.saveFlightDatas(first2);

        FlightDatas first3 = new FlightDatas("中国国航", "CA4194","北京", "九龙", "14:06", "15:58",
                "长沙","2016.03.38");
        db.saveFlightDatas(first3);

        FlightDatas first4 = new FlightDatas("山东航空", "SC4194", "北京", "上海", "8:06", "10:38",
                "南昌", "2016.03.31");
        db.saveFlightDatas(first4);

        FlightDatas first5 = new FlightDatas("西藏航空" ,"TV6102", "西藏", "上海", "10:06", "10:38",
                "南昌", "2016.03.23");
        db.saveFlightDatas(first5);

        FlightDatas first6 = new FlightDatas("深圳航空", "ZH4194", "北京", "上海", "8:06", "10:38",
                "南昌", "2016.05.31");
        db.saveFlightDatas(first6);

        FlightDatas first7 = new FlightDatas("四川航空" , "3U8896","北京", "上海", "8:06", "10:38",
                "南昌", "2016.03.16");
        db.saveFlightDatas(first7);

        FlightDatas first8 = new FlightDatas("海南航空" , "HU7147", "深圳", "上海", "8:06", "10:38",
                "南昌", "2016.03.31");
        db.saveFlightDatas(first8);

        FlightDatas first9 = new FlightDatas("海南航空", "HU7141", "北京", "上海", "8:06", "10:38",
                "南昌", "2016.05.30");
        db.saveFlightDatas(first9);

        FlightDatas first10 = new FlightDatas("中国国航","CA1405", "北京", "上海", "8:06", "10:38",
                "南昌", "2016.02.18");
        db.saveFlightDatas(first10);

        FlightDatas first11 = new FlightDatas("中国国航","CA1415","西藏", "上海", "10:06", "10:38",
                "南昌", "2016.02.21");
        db.saveFlightDatas(first11);

        FlightDatas first12 = new FlightDatas("山东航空","SC1405","北京", "上海", "8:06", "10:38",
                "南昌", "2016.06.19");
        db.saveFlightDatas(first12);

        FlightDatas first13 = new FlightDatas("西藏航空","TV6111","北京", "上海", "8:06", "10:38",
                "南昌", "2016.04.08");
        db.saveFlightDatas(first13);

        FlightDatas first14 = new FlightDatas("深圳航空","ZH1405","北京", "上海", "8:06", "10:38",
                "南昌", "2016.02.18");
        db.saveFlightDatas(first14);

        FlightDatas first15 = new FlightDatas("联合航空","KN5215","深圳", "上海", "8:06", "10:38",
                "南昌", "2016.03.01");
        db.saveFlightDatas(first15);

        FlightDatas first16 = new FlightDatas("厦门航空","MF1836","北京", "上海", "8:06", "10:38",
                "南昌", "2016.07.18");
        db.saveFlightDatas(first16);

        FlightDatas first17 = new FlightDatas("东方航空","MU3597","北京", "上海", "8:06", "10:38",
                "南昌", "2016.01.18");
        db.saveFlightDatas(first17);

        FlightDatas first18 = new FlightDatas("深圳航空","ZH1415","北京", "上海", "8:06", "10:38",
                "南昌", "2016.06.28");
        db.saveFlightDatas(first18);

        FlightDatas first19 = new FlightDatas("四川航空","3U8882","北京", "上海", "8:06", "10:38",
                "南昌", "2016.06.17");
        db.saveFlightDatas(first19);

        FlightDatas first20 = new FlightDatas("东方航空","MU3561","北京", "上海", "8:06", "10:38",
                "南昌", "2016.02.18");
        db.saveFlightDatas(first20);

        Toast.makeText(ActivityFlightBrowsing.this, "数据库生成完毕" , Toast.LENGTH_LONG).show();

    }
}

