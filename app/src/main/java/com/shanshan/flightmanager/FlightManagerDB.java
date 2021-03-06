package com.shanshan.flightmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

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
        if(flightDatas != null) {
            ContentValues values = new ContentValues();
            values.put("company_id" , flightDatas.getCompanyId());
            values.put("id" , flightDatas.getId());
            values.put("where_from" , flightDatas.getWhereFrom());        //始发地
            values.put("where_to" , flightDatas.getWhereTo());            //降落地
            values.put("time_begin" , flightDatas.getTimeBegin());        //起飞时间
            values.put("time_end" , flightDatas.getTimeEnd());            //降落时间
            values.put("trans_city" , flightDatas.getTransCity());        //中转城市
            values.put("day" , flightDatas.getDay());                     //航班飞行日
            values.put("isForigen",flightDatas.getIsForigen());           //国内外
            db.insert("FlightDatas", null , values);
        }
    }

    /*
    * 从数据库读取所有航班信息
    * */
    public List<FlightDatas> loadFlightDatas() {
        List<FlightDatas> list = new ArrayList<FlightDatas>();
        Cursor cursor = db.query("FlightDatas" , null , null , null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                FlightDatas flightDatas = new FlightDatas();
                flightDatas.setId(cursor.getString(cursor.getColumnIndex("id")));
                flightDatas.setCompanyId(cursor.getString(cursor.getColumnIndex("company_id")));
                flightDatas.setWhereFrom(cursor.getString(cursor.getColumnIndex("where_from")));
                flightDatas.setWhereTo(cursor.getString(cursor.getColumnIndex("where_to")));
                flightDatas.setTimeBegin(cursor.getString(cursor.getColumnIndex("time_begin")));
                flightDatas.setTimeEnd(cursor.getString(cursor.getColumnIndex("time_end")));
                flightDatas.setTransCity(cursor.getString(cursor.getColumnIndex("trans_city")));
                flightDatas.setDay(cursor.getString(cursor.getColumnIndex("day")));
                flightDatas.setIsForigen(cursor.getString(cursor.getColumnIndex("isForigen")));
                list.add(flightDatas);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    /**
     * 搜索航班信息
     * @param row 搜索关键字
     * @return  返回搜索结果列表
     */
    public List<FlightDatas> searchFlight(String row){
        List<FlightDatas> list = new ArrayList<>();
        Cursor cursor = null;
        String sql = "select * from FlightDatas where id=? or where_from=? or where_to=?";
        String[] args = {row};
        cursor = db.rawQuery(sql,args);
        if (cursor.moveToFirst()) {
            do {
                FlightDatas flightDatas = new FlightDatas();
                flightDatas.setId(cursor.getString(cursor.getColumnIndex("id")));
                flightDatas.setCompanyId(cursor.getString(cursor.getColumnIndex("company_id")));
                flightDatas.setWhereFrom(cursor.getString(cursor.getColumnIndex("where_from")));
                flightDatas.setWhereTo(cursor.getString(cursor.getColumnIndex("where_to")));
                flightDatas.setTimeBegin(cursor.getString(cursor.getColumnIndex("time_begin")));
                flightDatas.setTimeEnd(cursor.getString(cursor.getColumnIndex("time_end")));
                flightDatas.setTransCity(cursor.getString(cursor.getColumnIndex("trans_city")));
                flightDatas.setDay(cursor.getString(cursor.getColumnIndex("day")));
                flightDatas.setDay(cursor.getString(cursor.getColumnIndex("isForigen")));
                list.add(flightDatas);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    /**
     * @param userId
     * @return
     */

    public List<OrderDatas> searchOrderDatas(String userId){
        List<OrderDatas> list = new ArrayList<>();
        Cursor cursor = null;
        String sql = "select * from OrderDatas where user_id=?";
        String[] args = {userId};
        cursor = db.rawQuery(sql, args);
        if (cursor.moveToFirst()){
            do {
                OrderDatas orderDatas = new OrderDatas();
                orderDatas.setId(cursor.getInt(cursor.getColumnIndex("id")));
                orderDatas.setFlight_number(cursor.getString(cursor.getColumnIndex("flight_number")));
                orderDatas.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
                orderDatas.setUserId(cursor.getString(cursor.getColumnIndex("user_id")));
                list.add(orderDatas);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    /**
     * 加载所有订单信息
     * @return
     */

    public List<OrderDatas> loadOrderDatas() {
        List<OrderDatas> list = new ArrayList<>();
        Cursor cursor = db.query("OrderDatas" , null , null , null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                OrderDatas orderDatas = new OrderDatas();
                orderDatas.setId(cursor.getInt(cursor.getColumnIndex("id")));
                orderDatas.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
                orderDatas.setUserId(cursor.getString(cursor.getColumnIndex("user_id")));
                orderDatas.setFlight_number(cursor.getString(cursor.getColumnIndex("flight_number")));
                list.add(orderDatas);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    /**
     * 保存订单信息
     * @param orderDatas 订单数据对象
     */
    public void saveOrderData(OrderDatas orderDatas) {
        if(orderDatas != null){
            ContentValues values = new ContentValues();
//            values.put("id",orderDatas.getId());
            values.put("price",orderDatas.getPrice());
            values.put("user_id",orderDatas.getUserId());
            values.put("flight_number",orderDatas.getFlight_number());
            db.insert("OrderDatas", null , values);
        }
    }

    /**
     * 删除订单信息
     * @param id 订单id
     * @return  删除结果
     */
    public int deleteOrderData(int id) {
        String[] ids = {String.valueOf(id)};
        return db.delete("OrderDatas","id=?",ids);
    }

    /**
     * 查找用户信息
     * @param id 需要查找的用户的id
     * @return  返回查找结果
     */

    public UserDatas searchUser(String id) {
        UserDatas userDatas = new UserDatas();
        Cursor c = db.rawQuery("select * from UserDatas where id=?",new String[]{id});
        if(c.moveToFirst()) {
            userDatas.setId(id);
            userDatas.setAge(c.getInt(c.getColumnIndex("age")));
            userDatas.setName(c.getString(c.getColumnIndex("name")));
            userDatas.setPassword(c.getString(c.getColumnIndex("password")));
            userDatas.setBalance(c.getInt(c.getColumnIndex("balance")));
            userDatas.setSex(c.getString(c.getColumnIndex("sex")));
        }
        c.close();
        return userDatas;
    }

    /**
     * 保存用户信息
     * @param userDatas
     */
    public void saveUser(UserDatas userDatas) {
        if (userDatas !=null) {
            ContentValues values = new ContentValues();
            values.put("id",userDatas.getId());
            values.put("age",userDatas.getAge());
            values.put("sex",userDatas.getSex());
            values.put("password",userDatas.getPassword());
            values.put("name",userDatas.getName());
            //values.put("balance",userDatas.getBalance());
            db.insert("UserDatas",null,values);
        }
    }

    public boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try{
            String myPath = "/data/data/com.shanshan.flightmanager/" + "FlightDatas";
            checkDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READONLY | SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        }catch(SQLiteException e){
            //database does't exist yet.
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }


}
