package lesson7.project;

public final class GlobalState {

    private static GlobalState INSTANCE;
    private String selectedCity = null;
    public final String API_KEY = "ILbQQBdthiZ5xPIC9HLNYoXGXg10HQha";//"txu63JQSOahU7R4v0QdSBktxdFSBb8yc";//"LyZCKpBgoMrLXVoSShUe8MKqNBTTH1Vm";

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
