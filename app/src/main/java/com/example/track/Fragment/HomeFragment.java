package com.example.track.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.track.Data.DataProgress;
import com.example.track.OnChangeFragmentListener;
import com.example.track.R;
import com.example.track.adaptor.AdaptorProgress;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    TextView project_name;
    ImageView imageView, imageView2;
    ProgressBar progressBar;
    DataProgress data;
    int counter;
    RecyclerView recyclerView;
    AdaptorProgress adaptor;
    List<DataProgress> list;
    private OnChangeFragmentListener onChangeFragmentListener;

    public HomeFragment(OnChangeFragmentListener onChangeFragmentListener) {

        this.onChangeFragmentListener = onChangeFragmentListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adaptor = new AdaptorProgress(list,onChangeFragmentListener);
        recyclerView.setAdapter(adaptor);

        datasync();

    }

    public void datasync() {
        list.add(new DataProgress(
                "Project saurav ",
                30,
                "https://i.pinimg.com/originals/41/9d/54/419d5479ec3c3d495cefca011277da16.jpg"
        ));
        list.add(new DataProgress(
                "Project shakil",
                100,
                "https://i.pinimg.com/originals/41/9d/54/419d5479ec3c3d495cefca011277da16.jpg"
        ));
        list.add(new DataProgress(
                "Project tanmoy",
                10,
                "https://i.pinimg.com/originals/41/9d/54/419d5479ec3c3d495cefca011277da16.jpg"
        ));

        adaptor.notifyDataSetChanged();
    }


}
