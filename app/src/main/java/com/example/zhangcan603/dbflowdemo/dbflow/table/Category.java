package com.example.zhangcan603.dbflowdemo.dbflow.table;

import com.example.zhangcan603.dbflowdemo.dbflow.db.UserDb;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = UserDb.class)
public class Category  extends BaseModel{
    @PrimaryKey(autoincrement = true)
    public long id;
    @Column(name = "name")
    public String name;

    @Column(name = "level")
    public String level;
}
