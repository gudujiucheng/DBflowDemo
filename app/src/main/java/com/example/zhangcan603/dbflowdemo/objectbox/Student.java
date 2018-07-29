package com.example.zhangcan603.dbflowdemo.objectbox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.NameInDb;
import io.objectbox.annotation.Transient;
import io.objectbox.relation.ToOne;

@Entity   //表示这是一个需要持久化的实体
public class Student {
//    @Id：这个对象的主键,默认情况下，id是会被objectbox管理的，也就是自增id，如果你想手动管理id需要在注解的时候加上@Id(assignable = true)即可。当你在自己管理id的时候如果超过long的最大值，objectbox 会报错.id的值不能为负数。当id等于0时objectbox会认为这是一个新的实体对象,因此会新增到数据库表中
    @Id(assignable = true)
    public long id;

//    @Index：这个对象中的索引。对经常大量进行查询的字段创建索引，会提高你的查询性能。
    @Index
    public String name;
//    @Transient:如果你有某个字段不想被持久化，可以使用此注解,那么该字段将不会保存到数据库
    @Transient
    public int tempUsageCount;
//    @NameInDb：有的时候数据库中的字段跟你的对象字段不匹配的时候，可以使用此注解。
    @NameInDb("USERNAME")
    public String useName;
    //做一对一的关联注解，例如示例中表示一张学生表（Student）关联一张班级表（Class）
    public ToOne<MyClass> classToOne;

    public int age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tempUsageCount=" + tempUsageCount +
                ", useName='" + useName + '\'' +
                ", classToOne=" + classToOne +
                ", age=" + age +
                '}';
    }
}
