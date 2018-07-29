package com.example.zhangcan603.dbflowdemo.objectbox;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class MyClass {
    @Id
    public long id;
//    @ToMany:做一对多的关联注解，如示例中表示一张班级表(Class)关联多张学生表(Student)
//FIXME     @Backlink:表示反向关联
    @Backlink(to = "classToOne")
    public ToMany<Student> studentEntitys;
}
