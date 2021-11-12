package com.example.taskmanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class AddTasksFragment extends DialogFragment {
    private EditText taskTitle;
    private EditText effort;
    private EditText taskMembers;
    private OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener{
        void onOKPressed(Task newTask);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;

        }else {
            throw new RuntimeException(context.toString() + "must implement OnFragmentInteractionListener");
        }
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.add_task_fragment_layout, null);
        taskTitle = view.findViewById(R.id.task_title_editText);
        taskMembers = view.findViewById(R.id.members_editText);
        effort = view.findViewById(R.id.effort_editText);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        return builder
                .setView(view)
                .setTitle("Add Task")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String task_title = taskTitle.getText().toString();
                        Integer task_effort = Integer.valueOf(effort.getText().toString());
                        String[] task_members = taskMembers.getText().toString().split(",");
                        listener.onOKPressed(new Task(task_title, task_effort, task_members));
                    }
                }).create();
    }
}
