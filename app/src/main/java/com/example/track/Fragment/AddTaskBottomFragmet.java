package com.example.track.Fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.track.Data.DataTask;
import com.example.track.OnAddTaskListener;
import com.example.track.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Date;

public class AddTaskBottomFragmet extends BottomSheetDialogFragment {
    EditText addtask;

    OnAddTaskListener onAddTaskListener;

    public AddTaskBottomFragmet(OnAddTaskListener onAddTaskListener) {
        this.onAddTaskListener = onAddTaskListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.addtask_item, container, false);
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addtask=view.findViewById(R.id.addtask);

        addtask.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //if the event is a key-down event on the "enter" button
                if((event.getAction()==KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)){
                    //Perform action on key press
                        String add_task =  addtask.getText().toString();
                         onAddTaskListener.onaddtask(new DataTask( add_task,new Date(),false,new Date()));
                         dismiss();
                    return  true;
                }
                return false;
            }
        });
    }
}
