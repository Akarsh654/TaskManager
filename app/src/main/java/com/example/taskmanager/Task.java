package com.example.taskmanager;

import android.widget.ArrayAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable {
    private String title;
    private Integer effort;
    private ArrayList<String> teamMembers;

    public Task(String title, Integer effort) {
        this.title = title;
        this.effort = effort;
    }
    public Task(String title, Integer effort, ArrayList<String> members) {
        this.title = title;
        this.effort = effort;
        this.teamMembers = members;
    }


    /**
     *
     * @return
     */
    public String getTaskTitle() {
        return this.title;
    }

    /**
     *
     * @param taskTitle
     */
    public void setTaskTitle(String taskTitle) {
        this.title = taskTitle;
    }

    /**
     *
     * @return
     */
    public Integer getEffort() {
        return this.effort;
    }

    /**
     *
     * @param days
     */
    public void setEffort(Integer days) {
        this.effort = days;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getTeamMembers() {
        return this.teamMembers;
    }

    /**
     *
     * @param teamMembers
     * @return
     */
    public void setTeamMembers(ArrayList<String> teamMembers) {
        this.teamMembers = teamMembers;
    }
}
