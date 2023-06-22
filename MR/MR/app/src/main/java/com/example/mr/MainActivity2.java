package com.example.mr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    ProgressDialog pd;
    private int progressStatus = 0;
    private ProgressBar progressBar;
    private Handler pHandler = new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText mn=findViewById(R.id.mn);
        EditText d=findViewById(R.id.editTextDate);
        EditText t=findViewById(R.id.editTextTime);
        EditText dos=findViewById(R.id.editTextNumber);
        Button b;
        CheckBox c,c1,c2,c3,c4,c5,c6,c7;
        c=(CheckBox)findViewById(R.id.c);
        c1=(CheckBox)findViewById(R.id.c1);
        c2=(CheckBox)findViewById(R.id.c2);
        c3=(CheckBox)findViewById(R.id.c3);
        c4=(CheckBox)findViewById(R.id.c4);
        c5=(CheckBox)findViewById(R.id.c5);
        c6=(CheckBox)findViewById(R.id.c6);
        c7=(CheckBox)findViewById(R.id.c7);
        b = findViewById(R.id.btn);
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if ( c.isChecked()) {
                    c1.setChecked(true);
                    c2.setChecked(true);
                    c3.setChecked(true);
                    c4.setChecked(true);
                    c5.setChecked(true);
                    c6.setChecked(true);
                    c7.setChecked(true);
                }else {
                    c1.setChecked(false);
                    c2.setChecked(false);
                    c3.setChecked(false);
                    c4.setChecked(false);
                    c5.setChecked(false);
                    c6.setChecked(false);
                    c7.setChecked(false);
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     String mn1 = mn.getText().toString();
                                     String d1 = d.getText().toString();
                                     String t1 = t.getText().toString();
                                     String dos1 = dos.getText().toString();
                                     Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                                     i.putExtra("m", mn1);
                                     i.putExtra("d", d1);
                                     i.putExtra("t", t1);
                                     i.putExtra("do", dos1);
                                     //checkbox
                                     StringBuilder result = new StringBuilder();
                                     result.append("Selected Days:");
                                     if (c1.isChecked())
                                         result.append("\nSunday");
                                     if (c2.isChecked())
                                         result.append("\nMonday");
                                     if (c3.isChecked())
                                         result.append("\nTuesday");
                                     if (c4.isChecked())
                                         result.append("\nWednesday");
                                     if (c5.isChecked())
                                         result.append("\nThursday");
                                     if (c6.isChecked())
                                         result.append("\nFriday");
                                     if (c7.isChecked())
                                         result.append("\nSaturday");
                                     if (c.isChecked())
                                         i.putExtra("cb", "Everyday");
                                     else
                                         i.putExtra("cb", (CharSequence) result);
                                     progressBar = findViewById(R.id.progressBar1);
                                     final TextView text2 = findViewById(R.id.value123);

                                     new Thread(new Runnable() {
                                         @Override
                                         public void run() {
                                             while (progressStatus < 100) {
                                                 progressStatus++;
                                                 SystemClock.sleep(20);
                                                 pHandler.post(new Runnable() {
                                                     @Override
                                                     public void run() {
                                                         progressBar.setProgress(progressStatus);
                                                         text2.setText(String.valueOf(progressStatus)+"%");
                                                     }
                                                 });
                                             }

                                             if (progressStatus == 100) {
                                                 startActivity(i);
                                             }
                                         }
                                     }).start();
                                 }
                             });
    //date
        EditText td=(EditText)findViewById(R.id.editTextDate);
        EditText tt=(EditText)findViewById(R.id.editTextTime);
        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                    int mMonth = c.get(Calendar.MONTH);
                    int mDay = c.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity2.this, new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year,
                                                      int monthOfYear, int dayOfMonth) {

                                    td.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                }
                            }, mYear, mMonth, mDay);
                    datePickerDialog.show();
            }
        });
        //time
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity2.this, new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                tt.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
            });
        //back
        Button btnAdd = (Button)findViewById(R.id.bk);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);

            }
        });
        ImageButton b2 = findViewById(R.id.reg);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity2.this, b2);
                popupMenu.getMenuInflater().inflate(R.menu.menu2, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem Item) {
                        Toast.makeText(MainActivity2.this," "+Item, Toast.LENGTH_SHORT).show();
                        switch (Item.getItemId()) {
                            case R.id.ex:
                                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity2.this);
                                builder.setTitle("Exit")
                                        .setIcon(R.drawable.baseline_exit_to_app_24)
                                        .setMessage("Are you sure?")
                                        .setCancelable(false)
                                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(MainActivity2.this,"Exited",Toast.LENGTH_LONG).show();
                                                finish();
                                            }
                                        })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Toast.makeText(MainActivity2.this,"Selected No",Toast.LENGTH_SHORT).show();
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