package com.example.maximovd.weather;


import android.content.Context;

class WeatherData {
    private static WeatherData weatherData;
    private String name;
    private String[] city = {"", "", ""};

    private WeatherData(Context context, String name) {
        this.name = nameToValidInput(name);
        upDateDataBase(context);
    }

    private int[] temperature = {10, 20, 30};
    private int[] humidity = {10, 20, 30};
    private int[] speedOfWind = {10, 20, 30};
    private int[] pressure = {10, 20, 30};
    private int[] cloudy = {R.drawable.rainy, R.drawable.cloudy, R.drawable.sunny};

    static WeatherData getInstance(Context context, String value) {
        if (weatherData == null)
            synchronized (WeatherData.class){
            if(weatherData == null)
                weatherData = new WeatherData(context, value);
            }
            weatherData.setName(weatherData.nameToValidInput(value));
            return weatherData;
    }

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
    int getCloudy() {
        for (int i = 0; i < city.length; i++) {
            if (city[i].equals(name)) {
                return cloudy[i];
            }
        }
        return R.drawable.ic_launcher_background;
    }

    public void setName(String name) {
        this.name = name;
    }
}
