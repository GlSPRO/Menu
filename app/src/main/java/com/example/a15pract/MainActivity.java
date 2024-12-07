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
    // Элементы интерфейса для навигации
    BottomNavigationView rollsRoyceBottomNav; // Нижняя навигация для Rolls Royce
    DrawerLayout rollsRoyceDrawer; // Боковое меню для Rolls Royce
    ActionBarDrawerToggle drawerToggle; // Переключатель бокового меню

    // Метод для замены текущего фрагмента
    public void displayFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, fragment, null).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов интерфейса
        rollsRoyceDrawer = findViewById(R.id.drawer_layout);
        NavigationView rollsRoyceNavigation = findViewById(R.id.navigation_view);

        // Настройка переключателя для бокового меню
        drawerToggle = new ActionBarDrawerToggle(this, rollsRoyceDrawer, R.string.open_drawer, R.string.close_drawer);
        rollsRoyceDrawer.addDrawerListener(drawerToggle);

        // Отображение кнопки для открытия бокового меню
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();

        // Инициализация нижней навигации и установка начального фрагмента
        rollsRoyceBottomNav = findViewById(R.id.bottom_nav);
        displayFragment(new FirstFragment());

        // Обработка выбора элемента в нижней навигации
        rollsRoyceBottomNav.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.first_item) {
                displayFragment(new FirstFragment());
                return true;
            } else if (id == R.id.second_item) {
                displayFragment(new SecondFragment());
                return true;
            }
            return false;
        });

        // Обработка выбора элемента в боковом меню
        rollsRoyceNavigation.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_item1) {
                displayFragment(new FirstFragment());
            } else if (id == R.id.nav_item2) {
                displayFragment(new SecondFragment());
            } else {
                return false; // Если ID не совпадает, возвращаем false
            }
            rollsRoyceDrawer.closeDrawers(); // Закрываем навигационное меню после выбора
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
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true; // Обработка нажатия на переключатель бокового меню
        }
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Вы выбрали параметры", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.firstFrag) {
            displayFragment(new FirstFragment());
            return true;
        } else if (id == R.id.twoFrag) {
            displayFragment(new SecondFragment());
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}