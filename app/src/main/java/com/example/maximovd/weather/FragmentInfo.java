package com.example.maximovd.weather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentInfo extends Fragment {
    TextView temperature;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        initViewsFragment(view);
        return view;
    }

    private void initViewsFragment(View view) {
        temperature = view.findViewById(R.id.temp);
    }

    void setText(String temper) {
        temperature.setText(temper);
    }
}
