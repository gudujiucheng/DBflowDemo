package com.example.zhangcan603.dbflowdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.zhangcan603.dbflowdemo.objectbox.Student;

import java.util.List;

import io.objectbox.Box;


public class BoxActivity extends AppCompatActivity {
    TextView tvContent;
    Box<Student> studentBox = App.getInstence().getBoxStore().boxFor(Student.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);
        tvContent = findViewById(R.id.tv_content);
        findViewById(R.id.tv_in).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student();
                student.name = "Jay";
                student.id = 100;
                studentBox.put(student);

                Student student02 = new Student();
                student02.name = "zhangcan";
                student02.id = 100;
                studentBox.put(student02);

                query();
            }
        });
        findViewById(R.id.tv_query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query();
            }
        });
        findViewById(R.id.tv_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                List<Student> students  =  StudentBox.query().equal(Student_.id,100).build().find();
//                List<Student> jayStudents = StudentBox.query().equal(Student_.name, "Jay").build().find();
//                StudentBox.remove(jayStudents);
//                Toast.makeText(MainActivity.this,students.size()+":xx",Toast.LENGTH_LONG).show();

                Student student02 = new Student();
                student02.name = "lalalala";
                student02.age =1000;
                student02.id = 1;
                studentBox.put(student02);
                query();
            }
        });
        findViewById(R.id.tv_deleteAll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentBox.removeAll();
                query();
            }
        });
    }

    private void query() {
        List<Student> list = studentBox.query().build().find();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            stringBuilder.append(student.toString());

        }
        tvContent.setText(stringBuilder.toString());
    }
}
