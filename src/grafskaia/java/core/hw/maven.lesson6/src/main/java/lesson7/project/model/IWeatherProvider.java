package lesson7.project.model;

import lesson7.project.entity.WeatherObject;

import java.io.IOException;
import java.util.List;

public interface IWeatherProvider {
    List<WeatherObject> getWeather(Period period) throws IOException;
}
