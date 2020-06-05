package com.example.track;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Home extends Fragment {
TextView project_name;
ImageView imageView,imageView2;
ProgressBar progressBar;
Data data;
int counter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar=(ProgressBar)view.findViewById(R.id.progressbar);
        imageView=view.findViewById(R.id.imageview);
        imageView2=view.findViewById(R.id.imageview2);
        project_name=view.findViewById(R.id.project_name);
            data= new Data();
        project_name.setText("Project " + data.name);
        progressBar.setProgress(data.value);
        Picasso.get().load("https://ih1.redbubble.net/image.247965431.4858/flat,750x,075,f-pad,750x1000,f8f8f8.u2.jpg").resize(200,200).centerCrop().into(imageView);
        Picasso.get().load("https://ih1.redbubble.net/image.247965431.4858/flat,750x,075,f-pad,750x1000,f8f8f8.u2.jpg").resize(200,200).centerCrop().into(imageView2);


}


    public void prog(){
//        progressBar=(ProgressBar)view.findViewById(R.id.progressbar);
        Timer t =new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);
            }
        };
        t.schedule(tt,0,100);
    }
}
