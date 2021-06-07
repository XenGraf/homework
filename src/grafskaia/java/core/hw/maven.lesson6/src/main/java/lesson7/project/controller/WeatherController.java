package lesson7.project.controller;

import lesson7.project.GlobalState;
import lesson7.project.entity.WeatherObject;
import lesson7.project.model.*;

import java.io.IOException;
import java.sql.SQLException;

public class WeatherController implements IWeatherController {

    private IWeatherRepository weatherRepository = new WeatherRepository();

    @Override
    public void onUserInput(int command) throws IOException, SQLException {
        switch (command){
            case 1:
                getCurrentWeather();
                break;
            case 2:
                getFiveDayWeather();
                break;
            case 3:
                getAllFromDb();
                break;
            default:
                System.out.println("Нет такой команды");
                try {
                    GlobalState.getInstance().getConnection().close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                System.exit(1);
        }
    }

    private void getCurrentWeather() throws IOException {
        //weatherRepository.readWeatherInfoFromApi(Period.NOW);
        weatherRepository.writeWeatherInfoInDb(weatherRepository.readWeatherInfoFromApi(Period.NOW));
    }

    private void getFiveDayWeather() throws IOException {
       // weatherRepository.readWeatherInfoFromApi(Period.FIVE_DAYS);
        weatherRepository.writeWeatherInfoInDb(weatherRepository.readWeatherInfoFromApi(Period.FIVE_DAYS));
    }

    private void getAllFromDb() throws SQLException {
        for (WeatherObject i: weatherRepository.readWeatherInfoFromDb()) {
            System.out.println(i);
        }
    }
}
