package com.shanshan.flightmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanshan on 2016/3/16.
 */
public class FlightManagerDB {

    //数据库名
    public static final String DB_NAME = "flight_manager" ;

    //数据库版本
    public static final int VERSION = 1 ;

    private static FlightManagerDB flightManagerDB;

    private SQLiteDatabase db;

    /*
    * 将构造方法私有化
    */
    private FlightManagerDB(Context context){
        FlightDatabaseOpenHelper dbHelper = new FlightDatabaseOpenHelper(context,
                DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }

    /*
    * 获取FlightManagerDB的实例
    * */
    public synchronized static FlightManagerDB getInstance(Context context) {
        if (flightManagerDB == null ){
            flightManagerDB = new FlightManagerDB(context);
        }
        return flightManagerDB;
    }

    /*
    * 将FlightDatas实例存储到数据库
    * */
    public void saveFlightDatas(FlightDatas flightDatas){
        if(flightDatas != null){
            ContentValues values = new ContentValues();
            values.put("flight_number" , flightDatas.getFlightNumber());
            values.put("company_id" , flightDatas.getCompanyId());
            values.put("where_from" , flightDatas.getWhereFrom());
            values.put("where_to" , flightDatas.getWhereTo());
            values.put("time_begin" , flightDatas.getTimeBegin());
            values.put("time_end" , flightDatas.getTimeEnd());
            values.put("trans_city" , flightDatas.getTransCity());
            values.put("day" , flightDatas.getDay());
            db.insert("FlightDatas", null , values);
        }
    }

    /*
    * 从数据库读取所有航班信息
    * */
    public List<FlightDatas> loadFlightDatas() {
        List<FlightDatas> list = new ArrayList<FlightDatas>();
        Cursor cursor = db.query("FlightData" , null , null , null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                FlightDatas flightDatas = new FlightDatas();
                flightDatas.setFlightNumber(cursor.getString(cursor.getColumnIndex("flight_number")));
                flightDatas.setCompanyId(cursor.getString(cursor.getColumnIndex("company_id")));
                flightDatas.setWhereFrom(cursor.getString(cursor.getColumnIndex("where_from")));
                flightDatas.setWhereTo(cursor.getString(cursor.getColumnIndex("where_to")));
                flightDatas.setTimeBegin(cursor.getString(cursor.getColumnIndex("time_begin")));
                flightDatas.setTimeEnd(cursor.getString(cursor.getColumnIndex("time_end")));
                flightDatas.setTransCity(cursor.getString(cursor.getColumnIndex("trans_city")));
                flightDatas.setDay(cursor.getString(cursor.getColumnIndex("day")));
                list.add(flightDatas);
            }while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }


}
