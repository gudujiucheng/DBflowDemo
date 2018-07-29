package com.example.zhangcan603.dbflowdemo.dbflow.db;


import com.raizlabs.android.dbflow.annotation.Database;

/**
 * 建立数据库
 */
@Database(name = OtherDb.NAME, version = OtherDb.VERSION)
public class OtherDb {

    public static final String NAME = "OtherDb";//数据库名字

    public static final int VERSION = 1;//数据库版本
}