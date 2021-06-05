package lesson7.project.controller;

import lesson7.project.model.AccuWeatherProvider;
import lesson7.project.model.IWeatherProvider;
import lesson7.project.model.Period;

import java.io.IOException;

public class WeatherController implements IWeatherController {

    private IWeatherProvider weatherProvider = new AccuWeatherProvider();

    @Override
    public void onUserInput(int command) throws IOException {
        switch (command){
            case 1:
                getCurrentWeather();
                break;
            case 2:
                getFiveDayWeather();
                break;
            default:
                System.out.println("Нет такой команды");
                System.exit(1);
        }
    }

    private void getCurrentWeather() throws IOException {
        weatherProvider.getWeather(Period.NOW);
    }

    private void getFiveDayWeather() throws IOException {
        weatherProvider.getWeather(Period.FIVE_DAYS);
    }
}
