package com.example.a15pract;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    private int count = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        view.setBackgroundResource(R.color.red);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(getActivity(), button);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                if (id == R.id.increment) {
                    count++;
                    Toast.makeText(getActivity(), "Кликер нажат: " + count, Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.reset) {
                    count = 0;
                    Toast.makeText(getActivity(), "Кликер сброшен", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            });
            popup.show();
        });
    }
}