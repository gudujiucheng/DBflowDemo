package com.example.zhangcan603.dbflowdemo.sqlite;

public class Item {

    //属性存储类型 比如说商品名这个属性存储格式可能是文本，而商品价格属性存储类型就可能是integer型，这个根据具体情况合理初始化item对象即可
    public static final String item_type_integer = "item_type_integer";
    public static final String item_type_text = "item_type_text";
    public static final String item_type_long = "item_type_long";
    public static final String item_type_boolen = "item_type_boolen";

    public String text = "";//用于SQL拼接的关键字（要是无法理解可见接下来的例子）
    public String type = "";//该item的类型

    public Item(String text,String type)
    {
        this.text = text;
        this.type = type;
    }
    public Item()
    {
    }
}