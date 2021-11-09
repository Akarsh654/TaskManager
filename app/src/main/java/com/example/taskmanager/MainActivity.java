package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddTasksFragment.OnFragmentInteractionListener{

    ListView taskList;
    ArrayAdapter<Task> taskAdapter;
    ArrayList<String> dataList;
    ArrayList<Task> taskDataList;
    private int editItemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        taskList = findViewById(R.id.tasks_list);

        String []cities ={"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin"};
        String []provinces = {"AB" , "BC", "ON", "CO", "CA"};

        //dataList = new ArrayList<>();

        //dataList.addAll(Arrays.asList(cities));
        taskDataList = new ArrayList<>();

        taskAdapter = new CustomList(this, taskDataList);


        taskList.setAdapter(taskAdapter);

        final FloatingActionButton addCityButton = findViewById(R.id.add_tasks_button);
        addCityButton.setOnClickListener((v) -> {
            new AddTasksFragment().show(getSupportFragmentManager(), "ADD_TASK");
        });
    }

    @Override
    public void onOKPressed(Task newTask) {
        taskAdapter.add(newTask);
    }
}