package com.example.maximovd.weather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;


public class AllCityInfo extends Fragment {
//    String city;
//    String temperature;
//    int cloudy;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cardview_activity, container, false);

        initViews(view);
        return view;
    }

    private void initViews(View view) {
        TextView cityName = view.findViewById(R.id.city);
        cityName.setText(cityFirstUpperCase());
        TextView temper = view.findViewById(R.id.temperature);
        assert getArguments() != null;
        temper.setText(String.format("%s%n%s %s", getString(R.string.temperature), getArguments().getString("temper"), getString(R.string.degree)));
        ConstraintLayout constraintLayout = view.findViewById(R.id.fragment_card);
        constraintLayout.setBackgroundResource(getArguments().getInt("cloudy"));
    }

    private String cityFirstUpperCase() {
        assert getArguments() != null;
        String cityIn = Objects.requireNonNull(getArguments().getString("city"));
        return Objects.requireNonNull(cityIn).substring(0, 1).toUpperCase() + cityIn.substring(1);
    }




}
