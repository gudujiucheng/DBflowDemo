package com.example.zhangcan603.dbflowdemo;

import android.app.Application;

import com.example.libdatabase.DatabaseManager;
import com.example.zhangcan603.dbflowdemo.dbflow.db.UserDb;
import com.example.zhangcan603.dbflowdemo.objectbox.MyObjectBox;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

public class App extends Application {
    private static App baseApp;
    private BoxStore boxStore; //数据库表的管理者
    @Override
    public void onCreate() {
        super.onCreate();
        //dbflow 初始化
        DatabaseManager.getInstance().init(this, UserDb.class);


        baseApp = this;
        boxStore = MyObjectBox.builder().androidContext(this).build();
        if (BuildConfig.DEBUG) {
            new AndroidObjectBrowser(boxStore).start(this);
        }
    }

    public BoxStore getBoxStore(){
        return boxStore;
    }

    public static App getInstence(){
        return baseApp;
    }
}

