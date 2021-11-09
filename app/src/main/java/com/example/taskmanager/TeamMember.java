package com.example.taskmanager;

import android.widget.ArrayAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class TeamMember implements Serializable {

    private String name;
    private ArrayList<String> tasks;

    public TeamMember(String name){
        this.name = name;
    }

    public TeamMember(String name, ArrayList<String> tasks){
        this.tasks = tasks;
        this.name = name;
    }

    public void setMemberName(String memberName) {
        name = memberName;
    }

    public void setTasks(ArrayList<String> tasks) {
        tasks = tasks;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getTasks() {
        return this.tasks;
    }

}
