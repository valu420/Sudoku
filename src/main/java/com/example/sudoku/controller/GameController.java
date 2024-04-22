package com.example.sudoku.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private GridPane sudokuBoard;

    @FXML
    public void initialize(){
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                TextField numTxt = new TextField();
                sudokuBoard.add(numTxt, i, j);
            }
        }
    }

}
