package com.example.mr;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent i=getIntent();
        String mn1=i.getStringExtra("m");
        String d1=i.getStringExtra("d");
        String t=i.getStringExtra("t");
        String dos=i.getStringExtra("do");
        //cb
        //CharSequence[] check = (CharSequence[]) i.getExtras().get("cb");
        String check=i.getStringExtra("cb");
        TextView ts;
        ts = findViewById(R.id.dis);
        ts.setText("Date:"+d1+"\n\n"+"Time:"+t+"\n\n"+"Medicine Name:"+mn1+"\n\n"+"Dosage:"+dos+"\n\n"+check+"\n\n");
        Button email=(Button) findViewById(R.id.btn);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"friend@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "It's Reminding time");
                email.putExtra(Intent.EXTRA_TEXT, "Date:"+d1+"\n\n"+"Time:"+t+"\n\n"+"Medicine Name:"+mn1+"\n\n"+"Dosage:"+dos+"\n\n");
                startActivity(Intent.createChooser(email,"Choose Mail App"));

            }
        });

        Button btnAdd = (Button)findViewById(R.id.bkk);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
    }
