package com.example.track.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.track.Data.DataProgress;
import com.example.track.OnChangeFragmentListener;
import com.example.track.R;
import com.example.track.Fragment.TaskFragment;
import com.squareup.picasso.Picasso;

public class ViewHolderProgress extends RecyclerView.ViewHolder {
    ProgressBar progressBar;
    TextView project_name, progress;
    ImageView imageView;
    private OnChangeFragmentListener onChangeFragmentListener;

    public ViewHolderProgress(@NonNull View itemView, final OnChangeFragmentListener onChangeFragmentListener) {
        super(itemView);
        this.onChangeFragmentListener=onChangeFragmentListener;
        progressBar = itemView.findViewById(R.id.taskprogres);
        project_name = itemView.findViewById(R.id.project_name);
        progress = itemView.findViewById(R.id.taskprogresstext);
        imageView = itemView.findViewById(R.id.imageview);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChangeFragmentListener.onfragmentchange(new TaskFragment(onChangeFragmentListener));
            }
        });

    }

//  set value  for progress
    public void setvalues(DataProgress data){
        project_name.setText(data.name);
        progressBar.setProgress(data.progress);
        progress.setText(data.progress+" % done");
        Picasso.get().load(data.imgUrl).into(imageView);
    }
}