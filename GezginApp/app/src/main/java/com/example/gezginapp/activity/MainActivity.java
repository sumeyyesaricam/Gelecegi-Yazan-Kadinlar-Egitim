package com.example.gezginapp.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.gezginapp.R;
import com.example.gezginapp.fragment.HomeFragment;
import com.example.gezginapp.fragment.NotFragment_;
import com.example.gezginapp.fragment.ProfileFragment;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar
                , R.string.navigation_drawer_open
                , R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        int id = menuItem.getItemId();
                        if (id == R.id.nav_home) {
                            fragment = new HomeFragment();
                        } else if (id == R.id.nav_profile) {
                            fragment = new ProfileFragment();
                        } else if (id == R.id.nav_note) {
                            fragment = new NotFragment_();
                        }
                        loadFragment(fragment);
                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });


        FragmentTransaction transaction
                = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new HomeFragment());
        transaction.commit();


    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
