package lesson7.project.controller;

import java.io.IOException;
import java.sql.SQLException;

public interface IWeatherController {
    void onUserInput(int command) throws IOException, SQLException;
}
