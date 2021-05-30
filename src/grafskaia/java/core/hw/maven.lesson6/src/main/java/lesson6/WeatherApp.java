package lesson6;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.JSONParser;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.*;

public class WeatherApp {

        // 16 days weatherforecast, API  Weatherbit.io

        //https://api.weatherbit.io/v2.0/forecast/daily?city=Saint_Petersburg&key=f7b5648f5a634912b5497222d1d43f1d
        private static final String BASE_HOST = "api.weatherbit.io";
        private static final String FORECAST = "forecast";
        private static final String API_VERSION = "v2.0";
        private static final String FORECAST_TYPE = "daily";
        private static final String CITY_KEY = "Saint_Petersburg";
        private static final String API_KEY = "f7b5648f5a634912b5497222d1d43f1d";
        private static final String DAYS = "5";

        public static void main(String[] args) throws IOException {
            OkHttpClient client = new OkHttpClient();

            HttpUrl url = new HttpUrl.Builder()
                    .scheme("https")
                    .host(BASE_HOST)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST)
                    .addPathSegment(FORECAST_TYPE)
                    .addQueryParameter("city",CITY_KEY)
                    .addQueryParameter("key", API_KEY)
                    .addQueryParameter("days", DAYS)
                    .build();

            System.out.println(url.toString());

            Request requesthttps = new Request.Builder()
                    .url(url)
                    .build();

            String jsonResponse = client.newCall(requesthttps).execute().body().string();
            System.out.println(jsonResponse);
            Map<String, Object> jsonmap = new Gson().fromJson(jsonResponse, new TypeToken<HashMap<String,Object>>() {}.getType());
            System.out.println(jsonmap);
        }
    }


