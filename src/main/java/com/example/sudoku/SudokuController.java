package com.example.sudoku;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuController {
    @FXML
    private GridPane grid;

    private SudokuGame game;

    @FXML
    public void initialize() {
        game = new SudokuGame();
        for (var ref = new Object() {
            int row = 0;
        }; ref.row < 9; ref.row++) {
            for (int col = 0; col < 9; col++) {
                TextField textField = new TextField();
                textField.setPrefHeight(50);
                textField.setPrefWidth(50);
                int num = game.getBoard()[ref.row][col];
                textField.setText(num == 0 ? "" : Integer.toString(num));
                int finalCol = col;
                textField.textProperty().addListener((obs, oldVal, newVal) -> {
                    if (!newVal.matches("\\d*")) {
                        textField.setText(newVal.replaceAll("\\D", ""));
                    }
                    if (!newVal.isEmpty()) {
                        int number = Integer.parseInt(newVal);
                        game.placeNumber(ref.row, finalCol, number);
                    }
                });
                grid.add(textField, col, ref.row);
            }
        }
    }
}