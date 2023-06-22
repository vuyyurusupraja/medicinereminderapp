package com.example.mr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

public class MainActivity4 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ImageButton b2 = findViewById(R.id.reg);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(MainActivity4.this, "Please select an option", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(MainActivity4.this, b2);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem Item) {
                        Toast.makeText(MainActivity4.this," "+Item, Toast.LENGTH_SHORT).show();
                        switch (Item.getItemId()) {
                            case R.id.add:
                                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                                startActivity(intent);
                                return true;
                            case R.id.del:
                                Intent inte = new Intent(MainActivity4.this, MainActivity3.class);
                                startActivity(inte);
                                return true;
                            case R.id.mor:
                                replaceFragment(new fragmentmore());
                                return true;
                            case R.id.ex:
                                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity4.this);
                                builder.setTitle("Exit")
                                        .setIcon(R.drawable.baseline_exit_to_app_24)
                                        .setMessage("Are you sure?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(MainActivity4.this,"App Closed",Toast.LENGTH_LONG).show();
                                                //finish();
                                                moveTaskToBack(true);
                                                android.os.Process.killProcess(android.os.Process.myPid());
                                                System.exit(1);
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(MainActivity4.this,"Selected No",Toast.LENGTH_SHORT).show();
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
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}