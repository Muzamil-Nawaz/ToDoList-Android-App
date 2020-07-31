package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UpdateActivity extends AppCompatActivity {
    TextInputLayout t1,t2,t3;
    DatabaseHandler db;
    CalendarView cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        System.out.println("jhjgjh");
        try {
        t1 =  findViewById(R.id.updateTitle);
        t2 =  findViewById(R.id.updateDescription);
        t3 =  findViewById(R.id.updateDate);
        db = new DatabaseHandler(this);
        System.out.println(MainActivity.m_Text);
        Task task = db.getTask(Integer.parseInt((MainActivity.m_Text)));
        t1.getEditText().setText(task.title);
        t2.getEditText().setText(task.description);
        t3.getEditText().setText(task.date);
            cv = (CalendarView) findViewById(R.id.calendar);
            cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                    String date = i+"-"+(i1+1)+"-"+i2;
                    t3.getEditText().setText(date);

                }
            });


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public void updateTask(View v){
        t1 =  findViewById(R.id.updateTitle);
        t2 =  findViewById(R.id.updateDescription);
        t3 =  findViewById(R.id.updateDate);
        int id = Integer.parseInt(MainActivity.m_Text);
        String title = t1.getEditText().getText().toString();
        String description = t2.getEditText().getText().toString();
        String date = t3.getEditText().getText().toString();
        DatabaseHandler db = new DatabaseHandler(this);
        Task t = new Task(Integer.parseInt(MainActivity.m_Text),title,description,date);
        db.updateTask(t);
        Toast.makeText(getApplicationContext(),"Task updated successfully.",Toast.LENGTH_SHORT).show();
        t1.getEditText().setText("");
        t2.getEditText().setText("");
        t3.getEditText().setText("");

    }
}
