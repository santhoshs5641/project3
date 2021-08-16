package com.example.appetiserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new Basee()).commit();
        navigationView.setSelectedItemId(R.id.basee);


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case  R.id.first:
                        fragment = new Basee();
                        break;
                    case  R.id.calender:
                        fragment = new calenderr();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,fragment).commit();



                return true;
            }
        });

    }
}