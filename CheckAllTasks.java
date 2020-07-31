package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CheckAllTasks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_all_tasks);
        showTasks();
    }
    public void showTasks(){
        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<Task> tasks =(ArrayList<Task>) db.getAllContacts();
        ArrayList<String> list2 = new ArrayList<>();
        for (Task a : tasks){
            String s = "ID: "+a.getId()+"\nTitle:"+a.getTitle()+"\nDescription:"+a.getDescription()+"\nDate:"+a.getDate()+"\n";
            list2.add(s);
        }
        ArrayAdapter<String> tasksAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list2) {
            @Override

        public View getView(int position, View convertView, ViewGroup parent) {
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.GREEN);

                // Generate ListView Item using TextView
                return view;

            }};
        ListView lv = (ListView)findViewById(R.id.taskList);
        lv.setAdapter(tasksAdapter);
    }
}
