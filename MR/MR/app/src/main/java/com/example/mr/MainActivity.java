package com.example.mr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton b2 = findViewById(R.id.reg);
        b2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, b2);
            popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem Item) {
                    Toast.makeText(MainActivity.this," "+Item, Toast.LENGTH_SHORT).show();
                    switch (Item.getItemId()) {
                        case R.id.add:
                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intent);
                            return true;
                        case R.id.ex:
                            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Exit")
                                    .setIcon(R.drawable.baseline_exit_to_app_24)
                                    .setMessage("Are you sure?")
                                    .setCancelable(false)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(MainActivity.this,"Exited",Toast.LENGTH_LONG).show();
                                            finish();
                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(MainActivity.this,"Selected No",Toast.LENGTH_SHORT).show();
                                        }
                                    });
                            AlertDialog dialog= builder.create();
                            dialog.show();
                            return true;
                    }
                    return true;
                }
            });
            popupMenu.show();
        }
    });
    }
}