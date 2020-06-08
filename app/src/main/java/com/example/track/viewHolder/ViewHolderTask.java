package com.example.track.viewHolder;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.track.Data.DataTask;
import com.example.track.R;

public class ViewHolderTask extends RecyclerView.ViewHolder {
RadioButton isdone;
TextView task,textdate;
    public ViewHolderTask(@NonNull View itemView) {
        super(itemView);
        isdone=itemView.findViewById(R.id.isdone);
        task=itemView.findViewById(R.id.task);
        textdate=itemView.findViewById(R.id.textdate);

    }


    public void setvalues (DataTask dataTask){
        task.setText(dataTask.getTask());
        isdone.setChecked(dataTask.isIsdone());
        textdate.setText(dataTask.getDate().getHours()+": " +dataTask.getDate().getMinutes()+": "+dataTask.getDate().getDate()+"");
    }
}
