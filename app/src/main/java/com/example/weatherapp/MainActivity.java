package com.example.weatherapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.viewModels;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WeatherViewModel weatherViewModel;
    private TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherViewModel = new WeatherViewModel(getApplication());
        weatherTextView = findViewById(R.id.weather_text_view);

        String cityName = "London"; // Example city name
        weatherViewModel.fetchWeather(cityName);

        weatherViewModel.getWeatherData().observe(this, weatherResponse -> {
            if (weatherResponse != null) {
                String weatherInfo = "City: " + weatherResponse.getName() +
                        "\nTemperature: " + weatherResponse.getMain().getTemp() +
                        "\nDescription: " + weatherResponse.getWeather()[0].getDescription();
                weatherTextView.setText(weatherInfo);
            }
        });
    }
}
