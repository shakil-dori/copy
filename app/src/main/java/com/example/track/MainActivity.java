package com.example.track;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {
Fragment home,bell,badge,menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home =new Home();

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.badge:
                                onfragmentchange(badge);
                                break;
                            case R.id.menu:
                                onfragmentchange(menu);

                                break;
                            case R.id.bell:
                                onfragmentchange(bell);
                                break;
                            case R.id.home:
                                onfragmentchange(home);
                                break;
                        }
                        return false;
                    }
                });


        getSupportFragmentManager().beginTransaction().add(R.id.frame,home).commit();




    }

    public void onfragmentchange(Fragment fragment){

        
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame,fragment)
                .addToBackStack(null)
                .commit();
    }
}

