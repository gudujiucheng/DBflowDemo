package com.example.zhangcan603.dbflowdemo.table;

import com.example.zhangcan603.dbflowdemo.db.UserDb;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * 建立表   需要继承BaseModel
 * 注：您必须至少定义一列作为主键。如果任何字段被标记为私有，您还需要定义getter和setter方法（即getId()和setId()）。否则，DBFlow可能无法在编译时生成表。
 */
@Table(database = UserDb.class)
public class User extends BaseModel{

    @Column(name = "userId")
    @PrimaryKey
    public int userId;//用户id
    @Column(name = "userName")
    public String userName;// 用户姓名
    @Column(name = "age")
    public int age;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
