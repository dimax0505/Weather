package com.example.maximovd.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class AllCityInfo extends Fragment {
    String city;
    String temperature;
    int cloudy;
    TextView cityName;
    TextView temper;
    ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cardview_activity, container, false);

        initViews(view);
        return view;
    }

    void initViews(View view) {
        cityName = view.findViewById(R.id.city);
        cityName.setText(getArguments().getString("city"));
        temper = view.findViewById(R.id.temperature);
        temper.setText(getArguments().getString("temper"));
        imageView = view.findViewById(R.id.numberCard);
        imageView.setImageResource(getArguments().getInt("cloudy"));
    }




}
