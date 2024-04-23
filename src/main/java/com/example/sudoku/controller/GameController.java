package com.example.sudoku.controller;

import com.example.sudoku.view.alert.AlertBox;
import com.example.sudoku.view.alert.IAlertBox;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private GridPane sudokuBoard;

    @FXML
    public void initialize(){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                TextField numTxt = new TextField();
                sudokuBoard.add(numTxt, i, j);
                onKeyReleased(numTxt);
            }
        }
    }

    private void onKeyReleased(TextField numTxt) {
        numTxt.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String num = numTxt.getText();
                if (!isValidNum(num)) {
                    AlertBox alertBox = new AlertBox();
                    alertBox.showMessage("Error","Has ingresado un caracter invalido," +
                            "por favor intenta de nuevo");
                }
            }
        });
    }

    private boolean isValidNum(String num) {
        return num.matches("[1-9]") && num.length() == 1;
    }

}
