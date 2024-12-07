package com.example.a15pract;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    // TextView для отображения фактов о машинах
    TextView tvCarFact;

    // Константы для идентификации пунктов контекстного меню
    final int MENU_CAR_FACT_1 = 1;
    final int MENU_CAR_FACT_2 = 2;
    final int MENU_CAR_FACT_3 = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Инфляция макета фрагмента
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        // Инициализация TextView для фактов о машинах
        tvCarFact = view.findViewById(R.id.tvFact);
        registerForContextMenu(tvCarFact);
        return view;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // Проверка, что контекстное меню создаётся для правильного View
        if (v.getId() == R.id.tvFact) {
            menu.add(0, MENU_CAR_FACT_1, 0, "Факт о Rolls Royce 1");
            menu.add(0, MENU_CAR_FACT_2, 0, "Факт о Rolls Royce 2");
            menu.add(0, MENU_CAR_FACT_3, 0, "Факт о Rolls Royce 3");
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Обработка выбора пункта контекстного меню
        switch (item.getItemId()) {
            case MENU_CAR_FACT_1:
                tvCarFact.setText("Rolls Royce Phantom — это символ роскоши и статуса, который сочетает в себе выдающийся дизайн и мощный двигатель.");
                break;
            case MENU_CAR_FACT_2:
                tvCarFact.setText("Модель Rolls Royce Ghost предлагает уникальный опыт вождения благодаря своей бесшумной работе и высококачественным материалам.");
                break;
            case MENU_CAR_FACT_3:
                tvCarFact.setText("Каждый Rolls Royce создаётся вручную с использованием традиционных методов и материалов высшего качества.");
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }
}