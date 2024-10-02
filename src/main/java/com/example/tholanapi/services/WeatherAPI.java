package com.example.tholanapi.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class WeatherAPI {
    public static String fetchWeatherDataForThanjavur() throws Exception {
        // Replace 'YOUR_API_KEY' with your actual API key
        String apiKey = "b7898bc70b4166f63bb3fa82fd10143a";
        String city = "Thanjavur"; // Assuming you want weather data for Thanjavur

        // Construct the URL for the weather API -

        String url = "http://api.openweathermap.org/data/2.5/weather?q="+ city +"&appid="+ apiKey;

        // Create a RestTemplate to make the HTTP request
        RestTemplate restTemplate = new RestTemplate();

        // Send HTTP GET request to the weather API and retrieve JSON data
        String weatherData = restTemplate.getForObject(url, String.class);

        // Parse the JSON data
        JSONObject jsonObject = new JSONObject(weatherData);

        // Extract the "weather" array
        JSONArray weatherArray = jsonObject.getJSONArray("weather");

        // Extract the first object from the "weather" array
        JSONObject weatherObject = weatherArray.getJSONObject(0);

        // Extract the "main" and "description" fields
        String mainWeather = weatherObject.getString("main");
        String description = weatherObject.getString("description");

        // Return a formatted string with the extracted fields
        return "Weather: " + mainWeather + ", Description: " + description;
    }
}
