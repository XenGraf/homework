package lesson7.project.model;

import java.io.IOException;

public interface IWeatherProvider {
    void getWeather(Period period) throws IOException;
}
