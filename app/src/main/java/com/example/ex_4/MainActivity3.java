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

public class MainActivity3 extends AppCompatActivity{
    EditText usr;
    Button b5,b6;
    SQLiteDatabase db;
    String s1,s2,s3,s4,s5,s6,s7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db=openOrCreateDatabase("empdata", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(username VARCHAR,email VARCHAR,mobile VARCHAR,city VARCHAR);");

        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);

        b5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                usr = (EditText)findViewById(R.id.username);
                s1 = usr.getText().toString();
                if(s1.equals("")){
                    Toast.makeText(getApplicationContext(),"TextField's Cannot be Empty!",Toast.LENGTH_SHORT).show();
                }
                else {

                    Cursor c = db.rawQuery("SELECT * FROM student WHERE username='"+s1+"'", null);
                    if (c.moveToFirst()) {
                        System.out.println(c.getString(1));
                        s3=c.getString(0);
                        s4=c.getString(1);
                        s5=c.getString(2);
                        s6=c.getString(3);

                        Toast.makeText(getApplicationContext(), "Employee Found!", Toast.LENGTH_SHORT).show();
                        Intent n=new Intent(MainActivity3.this,MainActivity4.class);
                        n.putExtra("a",s3);
                        n.putExtra("b",s4);
                        n.putExtra("c",s5);
                        n.putExtra("d",s6);
                        startActivity(n);

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "No Employee Found!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        b6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(MainActivity3.this,MainActivity.class);
                startActivity(n);
            }
        });

    }
}
