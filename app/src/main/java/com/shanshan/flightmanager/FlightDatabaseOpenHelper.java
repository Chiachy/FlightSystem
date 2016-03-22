package com.shanshan.flightmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shanshan on 2016/3/14.
 *
 * 这是一个数据库操作辅助类
 */
public class FlightDatabaseOpenHelper extends SQLiteOpenHelper {

    /*
    * FlightDatas表建表语句
    */
    public static final String CREATE_DATAS = "create table FlightDatas(" +
            "id integer primary key autoincrement," +
            "company_id integer ," +
            "flight_number text ," +
            "where_from text ," +
            "where_to text ," +
            "time_begin text ," +
            "time_end text ," +
            "trans_city text ," +
            "day text ," +
            ") ";

    private Context mContext;

    public FlightDatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        //mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATAS);   //创建航班数据表
        //Toast.makeText(mContext, "创建成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

