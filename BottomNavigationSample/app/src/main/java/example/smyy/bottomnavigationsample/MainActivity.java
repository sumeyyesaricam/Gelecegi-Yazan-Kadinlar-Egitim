package example.smyy.bottomnavigationsample;

import android.support.annotation.NonNull;
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
        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Fragment selectedFragment = null;
                        FragmentTransaction transaction
                                = getSupportFragmentManager().beginTransaction();
                        if (menuItem.getItemId() == R.id.favorite) {
                            selectedFragment = new FavoriteFragment();
                        } else if (menuItem.getItemId() == R.id.music) {
                            selectedFragment = new HealthFragment();
                        } else if (menuItem.getItemId() == R.id.book) {
                            selectedFragment = new FavoriteFragment();
                        }
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return false;
                    }
                });
        FragmentTransaction transaction
                = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, new FavoriteFragment());
        transaction.commit();

    }


}
