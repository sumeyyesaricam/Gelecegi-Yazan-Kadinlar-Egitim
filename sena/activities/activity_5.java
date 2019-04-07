package com.example.ms.activity5.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ms.activity5.R;
import com.example.ms.activity5.fragments.DietFragment;
import com.example.ms.activity5.fragments.FavoriteFragment;
import com.example.ms.activity5.fragments.HealthFragment;

public class activity_5 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        bottomNavigationView = findViewById(R.id.bottonNV);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.favorite) {
                    FragmentTransaction transaction
                            = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, new FavoriteFragment());
                    transaction.commit();

                } else if (menuItem.getItemId() == R.id.book) {
                    FragmentTransaction transaction
                            = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, new DietFragment());
                    transaction.commit();

                } else if (menuItem.getItemId() == R.id.music) {
                    FragmentTransaction transaction
                            = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, new HealthFragment());
                    transaction.commit();

                }
                return false;
            }
        });
        FragmentTransaction transaction
                = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new FavoriteFragment());
        transaction.commit();

    }

}
