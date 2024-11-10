package com.example.a15pract;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, fragment, null).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toggle.syncState();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        setFragment(new FirstFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.first_item) {
                setFragment(new FirstFragment());
                return true;
            } else if (id == R.id.second_item) {
                setFragment(new SecondFragment());
                return true;
            }
            return false;
        });

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_item1) {
                setFragment(new FirstFragment());
            } else if (id == R.id.nav_item2) {
                setFragment(new SecondFragment());
            } else {
                return false; // Если ID не совпадает, возвращаем false
            }
            drawerLayout.closeDrawers(); // Закрываем навигационное меню после выбора
            return true; // Возвращаем true, если обработали событие
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Настройки выбраны", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.firstFrag) {
            setFragment(new FirstFragment());
            return true;
        } else if (id == R.id.twoFrag) {
            setFragment(new SecondFragment());
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}