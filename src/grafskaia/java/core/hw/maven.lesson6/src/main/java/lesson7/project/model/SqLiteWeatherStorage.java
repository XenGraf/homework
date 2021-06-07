package lesson7.project.model;

import lesson7.project.GlobalState;
import lesson7.project.entity.WeatherObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqLiteWeatherStorage implements ILocalStorageProvider {

    private static Connection connection = GlobalState.getINSTANCE().getConnection();
    private static PreparedStatement preparedStatement;
    private static Statement statement;

    static {
        try {
            statement = GlobalState.getInstance().getConnection().createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void saveWeather(WeatherObject weatherObject) throws SQLException {
        String dbName = GlobalState.getINSTANCE().DB_NAME;
        try {
            String query = "CREATE TABLE IF NOT EXISTS weather (id INTEGER PRIMARY KEY AUTOINCREMENT, city VARCHAR(20), localDate VARCHAR(10), weatherDayText VARCHAR(50), weatherNightText VARCHAR(50),minTemperature DECIMAL(10,1),maxTemperature DECIMAL(10,1))";
            statement.executeUpdate(query);
            preparedStatement = connection.prepareStatement("INSERT INTO weather (city,localDate,weatherDayText,weatherNightText,minTemperature,maxTemperature) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1,weatherObject.getCityName());
            preparedStatement.setString(2,weatherObject.getDate());
            preparedStatement.setString(3,weatherObject.getDayDescription());
            preparedStatement.setString(4,weatherObject.getNightDescription());
            preparedStatement.setDouble(5,Double.parseDouble(weatherObject.getMinTemperature()));
            preparedStatement.setDouble(6,Double.parseDouble(weatherObject.getMaxTemperature()));
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<WeatherObject> getAllWeather() throws SQLException {
            List<WeatherObject> weatherObjects = new ArrayList<>();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM weather");// + GlobalState.getInstance().DB_NAME);
            while (resultSet.next()) {
                String cityName = resultSet.getString(2);
                String date = resultSet.getString(3);
                String dayDescription = resultSet.getString(4);
                String nightDescription = resultSet.getString(5);
                String maxTemp = Double.toString(resultSet.getDouble(6));
                String minTemp = Double.toString(resultSet.getDouble(7));
                WeatherObject weatherObject = new WeatherObject(cityName, date, dayDescription, nightDescription, maxTemp, minTemp);
                weatherObjects.add(weatherObject);
                weatherObject.toString();
                }
            return weatherObjects;
    }

}
