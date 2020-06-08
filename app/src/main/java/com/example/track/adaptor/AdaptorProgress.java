package com.example.track.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.track.Data.DataProgress;
import com.example.track.OnChangeFragmentListener;
import com.example.track.R;
import com.example.track.viewHolder.ViewHolderProgress;


import java.util.List;

public class AdaptorProgress extends RecyclerView.Adapter<ViewHolderProgress> {
List<DataProgress> list;
private OnChangeFragmentListener onChangeFragmentListener;

    public AdaptorProgress(List<DataProgress> list, OnChangeFragmentListener onChangeFragmentListener) {
        this.list = list;
        this.onChangeFragmentListener = onChangeFragmentListener;
    }


    @NonNull
    @Override
    public ViewHolderProgress onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_item, parent, false);
        return new ViewHolderProgress(view,onChangeFragmentListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProgress holder, int position) {
        holder.setvalues(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
