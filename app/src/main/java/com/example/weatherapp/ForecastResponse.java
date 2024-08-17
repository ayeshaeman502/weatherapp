package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class ForecastResponse {

    @SerializedName("list")
    private Forecast[] forecasts;

    public Forecast[] getForecasts() {
        return forecasts;
    }

    public class Forecast {
        @SerializedName("main")
        private Main main;

        @SerializedName("weather")
        private Weather[] weather;

        public Main getMain() {
            return main;
        }

        public Weather[] getWeather() {
            return weather;
        }

        public class Main {
            @SerializedName("temp")
            private float temp;

            public float getTemp() {
                return temp;
            }
        }

        public class Weather {
            @SerializedName("description")
            private String description;

            public String getDescription() {
                return description;
            }
        }
    }
}
