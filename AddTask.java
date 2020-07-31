package com.example.todolist;

import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class AddTask  extends AppCompatActivity {
    TextInputLayout t1,t2,t3;
    CalendarView cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        Button ed = (Button) findViewById(R.id.addTask);
        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask(view);
            }
        });
        t3 = findViewById(R.id.date);
        cv = (CalendarView) findViewById(R.id.calendar);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i+"-"+(i1+1)+"-"+i2;
                t3.getEditText().setText(date);

            }
        });

    }
    public void addTask(View v) {
        t1 = findViewById(R.id.title);
        t2 = findViewById(R.id.description);
        t3 = findViewById(R.id.date);
        try {
            DatabaseHandler db = new DatabaseHandler(this);
            db.addContact(new Task(t1.getEditText().getText().toString(), t2.getEditText().getText().toString(), t3.getEditText().getText().toString()));
            Toast.makeText(this, "Task Added successfully", Toast.LENGTH_SHORT).show();
            t1.getEditText().setText("");
            t2.getEditText().setText("");
            t3.getEditText().setText("");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
