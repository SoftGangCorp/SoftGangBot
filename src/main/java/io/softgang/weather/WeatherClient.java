package io.softgang.weather;

import com.google.gson.Gson;
import io.softgang.crypto.model.PriceData;
import io.softgang.weather.model.WeatherData;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherClient {
    public WeatherData getWeatherData() throws Exception {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=cape+town,za&units=metric&APPID=69f679667ebbc8dab77e3913b0028ddb");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responsecode = conn.getResponseCode();
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        } else {

            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }
            scanner.close();
            Gson gson = new Gson();
            WeatherData weatherData = gson.fromJson(inline, WeatherData.class);
            return weatherData;
        }
    }

}
