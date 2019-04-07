package com.example.bottomnavigationsample;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


        BottomNavigationView bottomNavigationView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            bottomNavigationView = findViewById(R.id.btm);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    if(menuItem.getItemId()==R.id.home) {
                        Toast.makeText(MainActivity.this,"home",Toast.LENGTH_SHORT).show();
                        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new FavoriteFragment());
                        fragmentTransaction.commit();

                    }

                    else if(menuItem.getItemId()==R.id.health){
                        Toast.makeText(MainActivity.this,"saglik",Toast.LENGTH_SHORT).show();
                        FragmentTransaction fragmentTransaction1=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frame_layout, new HealthFragment());
                        fragmentTransaction1.commit();


                    }
                    else if(menuItem.getItemId()==R.id.diet){
                        Toast.makeText(MainActivity.this,"diet",Toast.LENGTH_SHORT).show();
                    }
                    return false;
                }
            });

            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new FavoriteFragment());
            fragmentTransaction.commit();



        }
    }

