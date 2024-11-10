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

    TextView tvFact;
    final int MENU_FACT_1 = 1;
    final int MENU_FACT_2 = 2;
    final int MENU_FACT_3 = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Инфляция макета фрагмента
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        // Инициализация TextView
        tvFact = view.findViewById(R.id.tvFact);

        // Регистрация для контекстного меню
        registerForContextMenu(tvFact);

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.tvFact) {
            menu.add(0, MENU_FACT_1, 0, "Интересный факт 1");
            menu.add(0, MENU_FACT_2, 0, "Интересный факт 2");
            menu.add(0, MENU_FACT_3, 0, "Интересный факт 3");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_FACT_1:
                tvFact.setText("Индивидуальные ювелирные украшения часто вдохновлены природой, используя элементы, такие как листья, цветы и животные, чтобы создать уникальные изделия.");
                break;
            case MENU_FACT_2:
                tvFact.setText("Мастера ювелирного дела используют экологически чистые материалы, такие как переработанные металлы и натуральные камни, чтобы минимизировать воздействие на природу.");
                break;
            case MENU_FACT_3:
                tvFact.setText("Каждое украшение может рассказать свою историю, отражая любовь к природе и уникальность каждого клиента через индивидуальный дизайн.");
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }
}