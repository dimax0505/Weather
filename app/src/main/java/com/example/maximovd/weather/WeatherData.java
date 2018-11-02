package com.example.maximovd.weather;


import android.content.Context;

class WeatherData {
    private int position;
    private String name;
    private String[] city = {"", "", ""};

    WeatherData(Context context, String name) {
        this.name = nameToValidInput(name);
        upDateDataBase(context);
    }

    WeatherData(Context context, int position) {
        this.position = position;
        upDateDataBase(context);
        this.name = city[position];
    }


    private int[] temperature = {10, 20, 30};
    private int[] humidity = {10, 20, 30};
    private int[] speedOfWind = {10, 20, 30};
    private int[] pressure = {10, 20, 30};

    private String nameToValidInput(String name) {
        name = name.toLowerCase();
        name = name.trim();
        return name;

    }

    private void upDateDataBase(Context context) {
        city[0] = context.getResources().getString(R.string.moscow);
        city[1] = context.getResources().getString(R.string.london);
        city[2] = context.getResources().getString(R.string.paris);
    }

    boolean isValidCity() {
        for (String aCity : city) {
            if (aCity.equals(name)) return true;
        }
        return false;
    }

    String getTemper() {

        for (int i = 0; i < city.length; i++) {
            if (city[i].equals(name)) {
                return String.valueOf(temperature[i]);
            }
        }
        return null;
    }

    String getHumidity() {

        for (int i = 0; i < city.length; i++) {
            if (city[i].equals(name)) {
                return String.valueOf(humidity[i]);
            }
        }
        return null;
    }

    String getSpeedOfWind() {

        for (int i = 0; i < city.length; i++) {
            if (city[i].equals(name)) {
                return String.valueOf(speedOfWind[i]);
            }
        }
        return null;
    }

    String getPressure() {

        for (int i = 0; i < city.length; i++) {
            if (city[i].equals(name)) {
                return String.valueOf(pressure[i]);
            }
        }
        return null;
    }
}
