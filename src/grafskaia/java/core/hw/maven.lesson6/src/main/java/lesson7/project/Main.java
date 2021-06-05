package lesson7.project;

import lesson7.project.view.IUserInterface;
import lesson7.project.view.UserInterface;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IUserInterface userInterface = new UserInterface();
        userInterface.showUI();
    }
}
