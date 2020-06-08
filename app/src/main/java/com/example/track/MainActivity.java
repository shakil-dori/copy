package com.example.track;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.track.Fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements OnChangeFragmentListener {
    Fragment home, bell, badge, menu;
    public final static String TAG="MY_LOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = new HomeFragment(this);

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

        getSupportFragmentManager().beginTransaction().add(R.id.frame, home).commit();
    }

    public void onfragmentchange(Fragment fragment) {


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}

