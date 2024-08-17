package com.example.weatherapp;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends AndroidViewModel {

    private MutableLiveData<WeatherResponse> weatherData;
    private MutableLiveData<ForecastResponse> forecastData;
    private WeatherApiService apiService;
    private final String API_KEY = "YOUR_API_KEY_HERE";

    public WeatherViewModel(Application application) {
        super(application);
        apiService = ApiClient.getClient().create(WeatherApiService.class);
        weatherData = new MutableLiveData<>();
        forecastData = new MutableLiveData<>();
    }

    public LiveData<WeatherResponse> getWeatherData() {
        return weatherData;
    }

    public LiveData<ForecastResponse> getForecastData() {
        return forecastData;
    }

    public void fetchWeather(String cityName) {
        Call<WeatherResponse> call = apiService.getCurrentWeather(cityName, API_KEY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    weatherData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                // Handle the error
            }
        });
    }

    public void fetchForecast(String cityName) {
        Call<ForecastResponse> call = apiService.getWeatherForecast(cityName, API_KEY);
        call.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                if (response.isSuccessful()) {
                    forecastData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                // Handle the error
            }
        });
    }
}
