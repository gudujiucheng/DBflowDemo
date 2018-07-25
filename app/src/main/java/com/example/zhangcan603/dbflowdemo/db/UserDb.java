package com.example.zhangcan603.dbflowdemo.db;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = UserDb.NAME, version = UserDb.VERSION)
public class UserDb {

    public static final String NAME = "UserDb";//数据库名字

    public static final int VERSION = 1;//数据库版本
}
