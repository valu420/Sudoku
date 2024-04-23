package com.example.sudoku.view.alert;

import com.example.sudoku.view.GameStage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;

public class GameStatusAlert implements IAlertBox {

    @Override
    public void showMessage(String title, String message){
        Alert gameStatusAlert = new Alert(Alert.AlertType.INFORMATION);
        gameStatusAlert.setTitle(title);
        gameStatusAlert.setHeaderText(null);
        gameStatusAlert.setContentText(message);
        gameStatusAlert.getButtonTypes().setAll(ButtonType.OK);
        gameStatusAlert.setOnCloseRequest(eventOver -> {
            GameStage.deleteInstance();
            try {
                GameStage.getInstance();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        gameStatusAlert.showAndWait();
    }
}
