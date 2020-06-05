package com.example.track;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

class Adaptor extends RecyclerView.Adapter<viewholder> {
List<Data>list;

    public Adaptor(List<Data> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.taskitem, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.setvalues(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class viewholder extends RecyclerView.ViewHolder {
    ProgressBar progressBar;
    TextView project_name, progress;
    ImageView imageView;

    public viewholder(@NonNull View itemView) {
        super(itemView);
        progressBar = itemView.findViewById(R.id.taskprogres);
        project_name = itemView.findViewById(R.id.project_name);
        progress = itemView.findViewById(R.id.taskprogresstext);
        imageView = itemView.findViewById(R.id.imageview);

    }

    public void setvalues(Data data){
        project_name.setText(data.name);
        progressBar.setProgress(data.progress);
        progress.setText(data.progress+" % done");
        Picasso.get().load(data.imgUrl).into(imageView);
    }
}
