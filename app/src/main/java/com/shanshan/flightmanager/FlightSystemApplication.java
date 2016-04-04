package com.shanshan.flightmanager;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Chiachi on 2016/4/3.
 */

/**
 * 定义全局变量，标记是否登录
 * */
public class FlightSystemApplication extends Application {
    private boolean isLogin ;

    public boolean getIsLogin(){
        return this.isLogin;
    }

    public void setIsLogin(boolean il){
        this.isLogin = il;
    }

    @Override
    public void onCreate() {
        isLogin = false;
        UserDatas userDatas = new UserDatas();
/*        userDatas.setName("钟圣麟");
        userDatas.setId("shakugan");
        userDatas.setPassword("123456");*/
        FlightManagerDB.getInstance(this).saveUser(userDatas);
        //使用chrome调试本地数据库
        Stetho.initialize(
                Stetho.newInitializerBuilder(this).enableDumpapp(
                        Stetho.defaultDumperPluginsProvider(this)
                ).enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this)
                        ).build()
        );

        super.onCreate();
    }
}
