package com.example.track.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.track.Data.DataTask;
import com.example.track.R;
import com.example.track.viewHolder.ViewHolderTask;

import java.util.List;

public class AdaptorTask extends RecyclerView.Adapter<ViewHolderTask> {
    List<DataTask> TaskList;

    public AdaptorTask(List<DataTask> taskList) {
        TaskList = taskList;
    }

    @NonNull
    @Override
    public ViewHolderTask onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new ViewHolderTask(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTask holder, int position) {
        holder.setvalues(TaskList.get(position));
    }

    @Override
    public int getItemCount() {
        return TaskList.size();
    }
}
