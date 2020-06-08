package com.example.track.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.track.Data.DataTask;
import com.example.track.OnAddTaskListener;
import com.example.track.OnChangeFragmentListener;
import com.example.track.R;
import com.example.track.adaptor.AdaptorTask;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.content.ContentValues.TAG;


public class TaskFragment extends Fragment implements OnAddTaskListener {
    RecyclerView taskRecyclerview;
    AdaptorTask adaptorTask;
    List<DataTask> taskList;
    FloatingActionButton fab;
    private OnChangeFragmentListener onChangeFragmentListener;

    public TaskFragment(OnChangeFragmentListener onChangeFragmentListener) {
        this.onChangeFragmentListener = onChangeFragmentListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab=view.findViewById(R.id.fab);
        taskRecyclerview = view.findViewById(R.id.TaskRecyclerview);
        taskList = new ArrayList<>();
        adaptorTask = new AdaptorTask(taskList);
        taskRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        taskRecyclerview.setAdapter(adaptorTask);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onChangeFragmentListener.onfragmentchange(new AddTaskBottomFragmet(TaskFragment.this) );
                new AddTaskBottomFragmet(TaskFragment.this).show(getChildFragmentManager(),"add Task");

            }
        });
        datasync();

    }

    void datasync() {
        taskList.add(new DataTask("this is task 1 ", new Date(), true, new Date()));
        taskList.add(new DataTask("this is task 2 ", new Date(), false, new Date()));
        taskList.add(new DataTask("this is task 3 ", new Date(), true, new Date()));
        taskList.add(new DataTask("this is task 4 ", new Date(), true, new Date()));
        Log.d(TAG, "datasync: "+taskList.size());

        adaptorTask.notifyDataSetChanged();
    }

    @Override
    public void onaddtask(DataTask dataTask) {
        taskList.add(dataTask);
        adaptorTask.notifyDataSetChanged();
    }
}