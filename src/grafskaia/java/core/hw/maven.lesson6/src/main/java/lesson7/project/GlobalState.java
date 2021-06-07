package lesson7.project;

import java.sql.Connection;

public final class GlobalState {

    private static GlobalState INSTANCE;
    private String selectedCity = null;
    public final String API_KEY = "ILbQQBdthiZ5xPIC9HLNYoXGXg10HQha";//"txu63JQSOahU7R4v0QdSBktxdFSBb8yc";//"LyZCKpBgoMrLXVoSShUe8MKqNBTTH1Vm";//
    public final String DB_NAME = "application.db";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private GlobalState(){    }

    public static GlobalState getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new GlobalState();
        }
        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public static GlobalState getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(GlobalState INSTANCE) {
        GlobalState.INSTANCE = INSTANCE;
    }
}
