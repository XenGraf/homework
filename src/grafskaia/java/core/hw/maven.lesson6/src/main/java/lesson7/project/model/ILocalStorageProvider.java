package lesson7.project.model;

import lesson7.project.entity.WeatherObject;

import java.sql.SQLException;
import java.util.List;

public interface ILocalStorageProvider {
    void saveWeather(WeatherObject weatherObject) throws SQLException;
    List<WeatherObject> getAllWeather() throws SQLException;
}
