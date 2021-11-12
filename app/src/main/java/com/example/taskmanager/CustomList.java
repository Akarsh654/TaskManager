package com.example.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

// References: https://stackoverflow.com/questions/48779095/how-to-input-multiple-data-in-one-edittext-separated-only-by-a-comma
public class CustomList extends ArrayAdapter {

    private ArrayList<Task> tasks;
    private Context context;

    public CustomList(Context context, ArrayList<Task> tasks){
        super(context,0, tasks);
        this.tasks = tasks;
        this.context = context;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup
            parent) {
        // return super.getView(position, convertView, parent);
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }
        Task task = tasks.get(position);
        TextView taskTitle = view.findViewById(R.id.task_text);
        TextView effort = view.findViewById(R.id.effort_text);
        TextView members_ = view.findViewById(R.id.member_list_text);
        taskTitle.setText(task.getTaskTitle());
        effort.setText(String.valueOf(task.getEffort()));
        members_.setText(android.text.TextUtils.join(",", task.getTeamMembers()));
        return view;
    }
}
