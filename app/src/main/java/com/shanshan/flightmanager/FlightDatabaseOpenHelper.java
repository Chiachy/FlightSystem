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
            "id text primary key ," +
            "company_id text ," +
            "flight_number text ," +
            "where_from text ," +
            "where_to text ," +
            "time_begin text ," +
            "time_end text ," +
            "trans_city text ," +
            "day text ," +
            "isForigen text" +
            ") ";

    public static final String CREATE_ORDER_TABLE = "create table OrderDatas(" +
            "id integer primary key autoincrement," + //订单编号
            "user_id text," +
            "price integer," +
            "flight_number text" +
            ") ";

    public static final String CREATE_USER_TABLE = "create table UserDatas(" +
            "id text primary key," +
            "password text," +
            "name text," +
            "sex text," +
            "age integer," +
            "balance integer" +
            ") ";


    public FlightDatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATAS);   //创建航班数据表
        db.execSQL(CREATE_ORDER_TABLE);
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CREATE_DATAS);   //创建航班数据表
        db.execSQL(CREATE_ORDER_TABLE);
        db.execSQL(CREATE_USER_TABLE);
    }
}

