package com.shanshan.flightmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Chiachi on 2016/3/17.
 */
public class FlightDatabase extends SQLiteOpenHelper {

    public static final String CREATE_DATAS = "create table Book(" +
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

    public FlightDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATAS);
        Toast.makeText(mContext, "创建成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
