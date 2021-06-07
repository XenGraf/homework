package lesson7.project;

import lesson7.project.view.IUserInterface;
import lesson7.project.view.UserInterface;

import java.awt.dnd.DragGestureEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:"+GlobalState.getInstance().DB_NAME);
        GlobalState.getInstance().setConnection(connection);
        connection.createStatement().executeUpdate("DELETE FROM weather");
        IUserInterface userInterface = new UserInterface();
        userInterface.showUI();
    }
}
