package lesson7.project.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.project.GlobalState;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AccuWeatherProvider implements IWeatherProvider {

//http://dataservice.accuweather.com/locations/v1/cities/search
    private final String BASE_HOST = "dataservice.accuweather.com";
    private final String LOCATIONS = "locations";
    private final String VERSION = "v1";
    private final String CITIES = "cities";
    private final String SEARCH = "search";
    private final String LANGUAGE = "ru";
    private final String FORECASTS = "forecasts";
    private final String DAILY = "daily";
    private final String ONEDAY = "1day";
    private final String FIVEDAY = "5day";
    private final String METRIC = "true";
    private final OkHttpClient okHttpClient = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Period period) throws RuntimeException {
        String key = detectCityKeyNyName();
        if (period.equals(Period.NOW)){
            Request request = makeRequest(makeRequestURL(Period.NOW, key));
            try {
                String weatherResponse = okHttpClient.newCall(request).execute().body().string();
                if (objectMapper.readTree(weatherResponse).size() > 0) {
                    makeWeatherForecast(weatherResponse);
                } else {
                    throw new RuntimeException(GlobalState.getInstance().getSelectedCity()+" - такой город не найден\n");
                }
            } catch (RuntimeException | IOException | ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (period.equals(Period.FIVE_DAYS)) {
            Request request = makeRequest(makeRequestURL(Period.FIVE_DAYS, key));
            try {
                String weatherResponse = okHttpClient.newCall(request).execute().body().string();
                if (objectMapper.readTree(weatherResponse).size() > 0) {
                        makeWeatherForecast(weatherResponse);
                    } else {
                    throw new RuntimeException(GlobalState.getInstance().getSelectedCity()+" - такой город не найден\n");
                }
            } catch (RuntimeException | IOException | ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException(period + " - такой временной интервал не верен\n");
        }
    }

    private String detectCityKeyNyName() {
        String selectedCity = GlobalState.getInstance().getSelectedCity();
        Request request = makeRequest(makeRequestURL(selectedCity));

        Response locationResponse = null;
        try {
            locationResponse = okHttpClient.newCall(request).execute();
            if (!locationResponse.isSuccessful()) {
                throw new RuntimeException("Сервер ответил "+locationResponse.code());
            }
            String jsonResponse = locationResponse.body().string();
            if (objectMapper.readTree(jsonResponse).size() > 0) {
                String code = objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
                String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
                String countryName =  objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
                System.out.printf("Найден город %s в стране %s, код - %s\n", cityName,countryName, code);
                return code;
            } else {
                throw new RuntimeException(selectedCity+" - такой город не найден\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpUrl makeRequestURL(Period period, String key) {
        String forecastPeriod = "";
        if (period.equals(Period.NOW)) {
            forecastPeriod = ONEDAY;
        } else if (period.equals(Period.FIVE_DAYS)) {
            forecastPeriod = FIVEDAY;
        } else {
            System.out.println("Неверный формат для прогноза погоды");
            return null;
        }
        HttpUrl weatherURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(DAILY)
                .addPathSegment(forecastPeriod)
                .addPathSegment(key)
                .addQueryParameter("apikey", GlobalState.getInstance().API_KEY)
                .addQueryParameter("language",LANGUAGE)
                .addQueryParameter("metric", METRIC)
                .build();
        return weatherURL;
    }

    private HttpUrl makeRequestURL(String selectedCity) {
        String forecastPeriod = "";
        if (selectedCity.length() != 0) {
            HttpUrl detectLocationURL = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(LOCATIONS)
                    .addPathSegment(VERSION)
                    .addPathSegment(CITIES)
                    .addPathSegment(SEARCH)
                    .addQueryParameter("apikey", GlobalState.getInstance().API_KEY)
                    .addQueryParameter("q", selectedCity)
                    .build();
            return detectLocationURL;
        } else {
            System.out.println("Неверный формат для поиска кода города");
            return null;
        }
    }

    private Request makeRequest(HttpUrl url) {
        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();
        return request;
    }

    private String changeDateFormat(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat output = new SimpleDateFormat("dd MMMM yyyy г.", new Locale("ru"));
        Date newDate = sdf.parse(date);
        Date d = sdf.parse(date);
        String formattedTime = output.format(d);
        return formattedTime;
    }

    private void makeWeatherForecast(String jsonResponse) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        WeatherResponse weatherResponse = objectMapper.readValue(jsonResponse,new TypeReference<WeatherResponse>() {});
        for (DailyForecasts i: weatherResponse.getDailyForecasts()) {
            System.out.printf("В городе %s на дату %s днем ожидается %s, вечером - %s. Максимальная температура составит %s \u00B0С, минимальная - %s \u00B0С.\n", GlobalState.getInstance().getSelectedCity(),changeDateFormat(i.getDate()), i.getDay().getDescription(), i.getNight().getDescription(), i.getTempInfo().getMax().getTemperatureValue(), i.getTempInfo().getMin().getTemperatureValue());
        }
    }
}
