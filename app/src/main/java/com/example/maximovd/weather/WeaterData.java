package com.example.maximovd.weather;

public class WeaterData {
    private String [] city = {"москва", "лондон", "париж"};
    private int [] temperature = {10,20,30};
    private int [] humidity = {10,20,30};
    private int [] speed_of_wind = {10,20,30};
    private int [] pressure = {10,20,30};


    public boolean isValidCity (String name) {
        name = name.toLowerCase();
        for (int i = 0; i<city.length; i++){
            if (city[i].equals(name)) return true;
        }return false;
    }

    public String getTemper (String name) {
        name = name.toLowerCase();
        for (int i = 0; i<city.length; i++){
            if (city[i].equals(name)) {return String.valueOf(temperature[i]);}
        }return null;
    }
    public String getHumidity (String name) {
        name = name.toLowerCase();
        for (int i = 0; i<city.length; i++){
            if (city[i].equals(name)) {return String.valueOf(humidity[i]);}
        }return null;
    }
    public String getSpeedOfWind (String name) {
        name = name.toLowerCase();
        for (int i = 0; i<city.length; i++){
            if (city[i].equals(name)) {return String.valueOf(speed_of_wind[i]);}
        }return null;
    }
    public String getPressure (String name) {
        name = name.toLowerCase();
        for (int i = 0; i<city.length; i++){
            if (city[i].equals(name)) {return String.valueOf(pressure[i]);}
        }return null;
    }
}
