package lesson7.project.model;

import lesson7.project.entity.WeatherObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IWeatherRepository {
    List<WeatherObject> readWeatherInfoFromApi(Period period) throws IOException;
    List<WeatherObject> readWeatherInfoFromDb() throws SQLException;
    void writeWeatherInfoInDb(List<WeatherObject> weatherObjects);
}
