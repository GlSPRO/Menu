package com.example.a15pract;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;
public class SecondFragment extends Fragment {
    private int count = 0;
    private int level = 1;
    private int clickBonusThreshold = 5;
    private Random random = new Random();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        view.setBackgroundResource(R.color.black);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton button = view.findViewById(R.id.imageButton);

        button.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(getActivity(), button);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                if (id == R.id.increment) {
                    handleIncrement();
                    return true;
                } else if (id == R.id.reset) {
                    resetCounter();
                    return true;
                } else {
                    return false;
                }
            });
            popup.show();
        });
    }

    private void handleIncrement() {
        count++;
        if (count % clickBonusThreshold == 0) {
            int bonus = random.nextInt(3) + 1;
            count += bonus;
            Toast.makeText(getActivity(), "Бонус за серию! +" + bonus + " очков!", Toast.LENGTH_SHORT).show();
        }
        if (count % 10 == 0) {
            level++;
            Toast.makeText(getActivity(), "Поздравляем! Вы достигли уровня " + level + "!", Toast.LENGTH_SHORT).show();
            changeBackgroundColor();
        }
        Toast.makeText(getActivity(), "Кликер нажат: " + count, Toast.LENGTH_SHORT).show();
    }

    private void resetCounter() {
        count = 0;
        level = 1;
        Toast.makeText(getActivity(), "Кликер сброшен", Toast.LENGTH_SHORT).show();
    }

    private void changeBackgroundColor() {
        int[] colors = {R.color.red, R.color.green, R.color.blue, R.color.yellow};
        getView().setBackgroundResource(colors[level % colors.length]);
    }
}