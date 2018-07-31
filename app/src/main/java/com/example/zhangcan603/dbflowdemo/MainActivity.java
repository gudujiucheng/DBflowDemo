package com.example.zhangcan603.dbflowdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.example.zhangcan603.dbflowdemo.dbflow.table.Category;
import com.example.zhangcan603.dbflowdemo.dbflow.table.User;
import com.example.zhangcan603.dbflowdemo.dbflow.table.User_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static int i = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_content);
        findViewById(R.id.tv_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.age = 10;
                user.userName = "张灿" + i;
                user.userId = i;
                user.save();
                i++;
                searchAllUser();
            }
        });

        findViewById(R.id.tv_02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchAllUser();
            }
        });

        findViewById(R.id.tv_03).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//删除一条数据
                SQLite.delete(User.class)
                        .where(User_Table.userId.eq(i))
                        .execute();
                i--;
                searchAllUser();
            }
        });

        findViewById(R.id.tv_04).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//清空数据
                SQLite.delete(User.class).execute();
                searchAllUser();

                //TODO 封装增删改查  可以把类名 以及条件封装进去  ，先搞现有的列表查询，或者user表查询， 为了解耦可以把别人的接口在包装一层
                List<User> list = SQLite.select().from(User.class).where(User_Table.age.eq(10),User_Table.userName.isNotNull()).queryList();
            }
        });

        //传统方式
        findViewById(R.id.tv_05).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//传统数据库操作
//                PersonTable personTable =   new PersonTable();
//                SQLiteManager.getInstance().init(MainActivity.this,"TEST");
//                SQLiteManager.getInstance().registerTable(personTable);

                test();
            }
        });


    }

    private void test() {
        Category category = new Category();
        category.name = "food";
        category.save();
    }

    private void searchAllUser() {
        Toast.makeText(this,"当前id:"+i,Toast.LENGTH_SHORT).show();
        List<User> list = SQLite.select().
                from(User.class).queryList();
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            User user = list.get(j);
            s.append(user.toString());
        }
        textView.setText(s);
    }

    /**
     * 开启事务、切换数据库、数据库表升级、外键、多model依赖的情况。
     */




}
