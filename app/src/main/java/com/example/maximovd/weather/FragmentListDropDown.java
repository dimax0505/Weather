package com.example.maximovd.weather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Objects;

public class FragmentListDropDown extends Fragment {
    private int currentPosition = 0;
    private WeatherData weatherData;
    Spinner spinner;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_drop_down, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), R.array.cities,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = Objects.requireNonNull(getView()).findViewById(R.id.spinner);
        if (savedInstanceState != null) spinner.setSelection(currentPosition);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                currentPosition = selectedItemPosition;
                showTemperature();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void showTemperature() {
        weatherData = new WeatherData(this.getContext(), spinner.getSelectedItem().toString());
        assert getFragmentManager() != null;
        FragmentInfo detail = (FragmentInfo) getFragmentManager().findFragmentById(R.id.fragment_info);
        assert detail != null;
        detail.setText(getWeather());
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_info, detail);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    private String getWeather() {
        return String.format("%s%n%s %s", getString(R.string.temperature), weatherData.getTemper(), getString(R.string.degree));
    }
}
