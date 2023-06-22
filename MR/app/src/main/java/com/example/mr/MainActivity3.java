package com.example.mr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView recview;
    myadapter adapter;
    DatabaseReference mbase;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //new
        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Events"), User.class)
                        .build();

        adapter=new myadapter(options);
        recview.setAdapter(adapter);
        //old
        Intent i = getIntent();
        String mn1 = i.getStringExtra("m");
        String d1 = i.getStringExtra("d");
        String t = i.getStringExtra("t");
        String dos = i.getStringExtra("do");
        //cb
        //CharSequence[] check = (CharSequence[]) i.getExtras().get("cb");
        String check = i.getStringExtra("cb");
        TextView ts;
        //ts = findViewById(R.id.dis);
        //ts.setText("Date:"+d1+"\n\n"+"Time:"+t+"\n\n"+"Medicine Name:"+mn1+"\n\n"+"Dosage:"+dos+"\n\n"+check+"\n\n");
       /* Button email=(Button) findViewById(R.id.btn);
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
        });*/
        ImageButton b2 = findViewById(R.id.reg);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity3.this, b2);
                popupMenu.getMenuInflater().inflate(R.menu.menu2, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem Item) {
                        Toast.makeText(MainActivity3.this, " " + Item, Toast.LENGTH_SHORT).show();
                        switch (Item.getItemId()) {
                            case R.id.ex:
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                                builder.setTitle("Exit")
                                        .setIcon(R.drawable.baseline_exit_to_app_24)
                                        .setMessage("Are you sure?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(MainActivity3.this, "App Closed", Toast.LENGTH_LONG).show();
                                                //finish();
                                                moveTaskToBack(true);
                                                android.os.Process.killProcess(android.os.Process.myPid());
                                                System.exit(1);
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(MainActivity3.this, "Selected No", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                AlertDialog dialog = builder.create();
                                dialog.show();
                                return true;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        @SuppressLint("WrongViewCast") ImageButton btnAdd = findViewById(R.id.back);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        ImageButton plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
