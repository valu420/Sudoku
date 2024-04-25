package com.example.sudoku;

import com.example.sudoku.view.GameStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * The Main class serves as the entry point for the Sudoku application.
 */
public class Main extends Application {
    /**
     * The start method is called when the JavaFX application is started.
     * It initializes and displays the main game stage.
     *
     * @param primaryStage The primary stage for this application.
     * @throws IOException If an error occurs while loading the game stage.
     */

    @Override
    public void start(Stage primaryStage) throws IOException {
        GameStage.getInstance();
    }
    /**
     * The main method is the entry point of the application.
     * It launches the JavaFX application.
     *
     * @param args Command line arguments.
     */

    public static void main(String[] args) {
        launch(args);
    }
}
