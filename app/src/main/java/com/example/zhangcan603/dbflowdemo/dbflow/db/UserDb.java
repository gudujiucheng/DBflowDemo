package com.example.zhangcan603.dbflowdemo.dbflow.db;

import com.example.zhangcan603.dbflowdemo.dbflow.table.Category;
import com.example.zhangcan603.dbflowdemo.dbflow.table.User;
import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.SQLiteType;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;

@Database(name = UserDb.NAME, version = UserDb.VERSION)
public class UserDb {

    public static final String NAME = "UserDb";//数据库名字

    public static final int VERSION = 3;//数据库版本

    @Migration(version = 2, database = UserDb.class)
    public static class Migration2 extends AlterTableMigration<User> {
        public Migration2(Class<User> table) {
            super(table);
        }

        @Override
        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, "heighx");
        }
    }

    @Migration(version = 3, database = UserDb.class)
    public static class MigrationUser3 extends AlterTableMigration<User> {
        public MigrationUser3(Class<User> table) {
            super(table);
        }

        @Override
        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, "weight");
        }
    }

    @Migration(version = 3, database = UserDb.class)
    public static class MigrationCategory3 extends AlterTableMigration<Category> {
        public MigrationCategory3(Class<Category> table) {
            super(table);
        }

        @Override
        public void onPreMigrate() {
            addColumn(SQLiteType.TEXT, "level");
        }
    }
}
