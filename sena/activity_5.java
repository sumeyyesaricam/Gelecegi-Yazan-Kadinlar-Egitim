package com.example.ms.activity5;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

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
                    Toast.makeText(activity_5.this, "beğendiklerim", Toast.LENGTH_SHORT).show();
                } else if (menuItem.getItemId() == R.id.book) {
                    Toast.makeText(activity_5.this, "kitaplarım", Toast.LENGTH_SHORT).show();
                } else if (menuItem.getItemId() == R.id.music) {
                    Toast.makeText(activity_5.this, "müziklerim", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private BottomNavigationView findViewById(Object p0) { }
}
