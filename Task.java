package com.example.todolist;

public class Task {
    int id ;
    String title;
    String description;
    String date;
    public Task(){     }
    public Task(int id,String title,String description,String date){
        this.id=id;
        this.date=date;
        this.title=title;
        this.description=description;
    }
    public Task(String title,String description,String date){

        this.date=date;
        this.title=title;
        this.description=description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
