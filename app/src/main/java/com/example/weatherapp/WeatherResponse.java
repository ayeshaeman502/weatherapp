package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    @SerializedName("weather")
    private Weather[] weather;

    @SerializedName("main")
    private Main main;

    @SerializedName("name")
    private String name;

    public Weather[] getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public String getName() {
        return name;
    }

    public class Weather {
        @SerializedName("description")
        private String description;

        public String getDescription() {
            return description;
        }
    }

    public class Main {
        @SerializedName("temp")
        private float temp;

        public float getTemp() {
            return temp;
        }
    }
}
