package lesson7.project.model;

import lesson7.project.entity.WeatherObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class WeatherRepository implements IWeatherRepository{
    IWeatherProvider apiWeatherProvider = new AccuWeatherProvider();
    ILocalStorageProvider localStorageProvider = new SqLiteWeatherStorage();

    @Override
    public List<WeatherObject> readWeatherInfoFromApi(Period period) throws IOException {
        List<WeatherObject> weatherInfo = apiWeatherProvider.getWeather(period);
        System.out.println(weatherInfo);
        return weatherInfo;
    }

    @Override
    public List<WeatherObject> readWeatherInfoFromDb() throws SQLException {
        List<WeatherObject> weatherObjectsFromDB = localStorageProvider.getAllWeather();
        return weatherObjectsFromDB;
    }

    @Override
    public void writeWeatherInfoInDb(List<WeatherObject> weatherObjects) {
        weatherObjects.forEach(weatherObject -> {
            try {
                localStorageProvider.saveWeather(weatherObject);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}
