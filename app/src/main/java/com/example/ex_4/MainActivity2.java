package com.example.ex_4;

import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity2 extends AppCompatActivity{
    EditText usr,email,mobile,city;
    Button b3,b4;
    SQLiteDatabase db;
    String s1,s2,s3,s4,s5,s6;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db=openOrCreateDatabase("empdata", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(username VARCHAR,email VARCHAR,mobile VARCHAR,city VARCHAR);");


        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                usr = (EditText)findViewById(R.id.username);
                email = (EditText)findViewById(R.id.email);
                mobile = (EditText)findViewById(R.id.mobile);
                city = (EditText)findViewById(R.id.city);
                s1 = usr.getText().toString();
                s4 = email.getText().toString();
                s5 = mobile.getText().toString();
                s6 = city.getText().toString();
                System.out.print(s1);
                System.out.print("*********************************");
                if(s1.equals("")||s4.equals("")||s5.equals("")||s6.equals("")){
                    System.out.print("1*********************************1");
                    Toast.makeText(getApplicationContext(),"TextField's Cannot be Empty!",Toast.LENGTH_SHORT).show();
                }
                else{
                        System.out.print("2*********************************");
                        db.execSQL("INSERT INTO student VALUES('"+s1+"','"+s4+"','"+s5+"','"+s6+"');");
                        Cursor c=db.rawQuery("SELECT * FROM student", null);
                        if(c.moveToFirst())
                        {
                            System.out.println(c);
                        }
                        Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_SHORT).show();
                        Intent n=new Intent(MainActivity2.this,MainActivity3.class);
                        startActivity(n);
                }

            }
        });

        b4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(n);
            }
        });



    }
}
