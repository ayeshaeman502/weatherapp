package com.example.weatherapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WeatherDetailActivity extends AppCompatActivity {

    private TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        weatherTextView = findViewById(R.id.weather_text_view);

        String cityName = getIntent().getStringExtra("CITY_NAME");

        // Fetch weather data from API and update UI
        // This is a placeholder
        weatherTextView.setText("Weather details for " + cityName);
    }
}
