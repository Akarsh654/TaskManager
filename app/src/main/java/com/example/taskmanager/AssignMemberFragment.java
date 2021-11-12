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

public class AssignMemberFragment extends DialogFragment {
    private EditText taskTitle;
    private EditText effort;
    private EditText taskMembers;
    private Task taskObject;
    private AssignMemberFragment.OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener{
        void onEditPressed(Task newTask);
    }

    static AssignMemberFragment newInstance(Task task) {
        Bundle args = new Bundle();
        args.putSerializable("tasks", task);

        AssignMemberFragment fragment = new AssignMemberFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AssignMemberFragment.OnFragmentInteractionListener){
            listener = (AssignMemberFragment.OnFragmentInteractionListener) context;

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

        assert getArguments() != null;
        taskObject = (Task) getArguments().getSerializable("tasks");
        taskTitle.setText(taskObject.getTaskTitle());
        effort.setText(String.valueOf(taskObject.getEffort()));
        taskMembers.setText(android.text.TextUtils.join(",", taskObject.getTeamMembers()));

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        return builder
                .setView(view)
                .setTitle("Assign Members")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String task_ = taskTitle.getText().toString();
                        String effort_ = effort.getText().toString();
                        String taskmember[] = taskMembers.getText().toString().split(",");

                        taskObject.setTaskTitle(task_);
                        taskObject.setEffort(Integer.valueOf(effort_));
                        taskObject.setTeamMembers(taskmember);
                        listener.onEditPressed(taskObject);
                    }
                }).create();
    }

}

