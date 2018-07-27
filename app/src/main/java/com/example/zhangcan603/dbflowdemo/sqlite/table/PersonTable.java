package com.example.zhangcan603.dbflowdemo.sqlite.table;

import android.content.ContentValues;

import com.example.zhangcan603.dbflowdemo.sqlite.Item;
import com.example.zhangcan603.dbflowdemo.sqlite.SQLiteManager;
import com.example.zhangcan603.dbflowdemo.sqlite.Table;

public class PersonTable extends Table {

    public static final String name = "name";
    public static final String address1 = "address1";
    public static final String address2 = "address2";
    public static final String phone = "phone";

    public PersonTable() {
        init();
    }

    public void init() {
        table_name = "person";
        keyItem = "_id";//默认给予主键为“_id”
        //构建属性
        items.add(new Item(name, Item.item_type_text));
        items.add(new Item(address1, Item.item_type_text));
        items.add(new Item(address2, Item.item_type_text));
        items.add(new Item(phone, Item.item_type_text));
    }

    public long insert(ContentValues cv) {
        return SQLiteManager.getInstance().db.insert(table_name, null, cv);
    }

    //delete item
    public long deleteAllItem() {
        return SQLiteManager.getInstance().db.delete(table_name, null, null);
    }

    //
    public long deleteOneByItem(String item, String content) {
        String[] args = {String.valueOf(content)};
        return SQLiteManager.getInstance().db.delete(table_name, item + " =?", args);
    }

    //update item
    public long updateOneByItem(String item, String content, ContentValues contentData) {
        String[] args = {String.valueOf(content)};
        return SQLiteManager.getInstance().db.update(table_name, contentData, item + " =? ", args);
    }

    //上述的deleteAllItem方法可以将其放入到父类Table中去，因为这个方法可以共用，甚至insert方法也可以，这里我就不写回去了。但是下面这个getContentValues方法是每个类独有的，必须重写。因为每个表的属性都不同。
    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "coyc");
        contentValues.put("address1", "长沙");
        contentValues.put("phone", "10086");
        return contentValues;
    }
}
