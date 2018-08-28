package com.example.libdatabase;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;

import com.raizlabs.android.dbflow.config.DatabaseConfig;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class DatabaseManager {
    private static DataBaseContext dataBaseContext;

    public static DatabaseManager getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 静态内部类,只有在装载该内部类时才会去创建单例对象
     */
    private static class SingletonHolder {
        private static final DatabaseManager instance = new DatabaseManager();
    }

    // 临时构建的构造函数，后面需要将userDBCls拆出来，不应该放这里
    public void init(Context base, Class<?> userDBCls) {
        dataBaseContext = new DataBaseContext(userDBCls, base);
        FlowManager.init(new FlowConfig.Builder(dataBaseContext)
                .build());


//        FlowManager.getDatabase(UserDb.class)
//                .reset(DatabaseConfig.builder(UserDb.class)
//                        .databaseName("AppDatabase-2")
//                        .build());

    }

    public DataBaseContext getDataBaseContext() {
        return dataBaseContext;
    }


    //TODO 可以在进一步 通过反射获取table表  然后条件需要转换 比如说 user.age < 10  转换成对应的 conditions
    //TODO 由于多种对象的类型可能不同  还需要考虑链式调用
    public static <T> List<T> queryList(Class<T> table, @NonNull SQLOperator... conditions) {
        return SQLite.select().from(table).where(conditions).queryList();
    }


    /**
     * 清空表
     * @param table 表对应的类名
     * @param <T>
     */
    public static <T> void deleteAll(@NonNull Class<T> table) {
        SQLite.delete(table).execute();
    }


}
