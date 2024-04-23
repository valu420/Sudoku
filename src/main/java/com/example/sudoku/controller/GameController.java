package com.example.sudoku.controller;

import com.example.sudoku.model.Sudoku;
import com.example.sudoku.view.alert.AlertBox;
import com.example.sudoku.view.alert.GameStatusAlert;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GameController {

    @FXML
    private GridPane sudokuBoard;

    Sudoku sudoku = new Sudoku();

    @FXML
    public void initialize(){
        String baby_blue, blue;
        baby_blue = "#bcceff";
        blue = "#def7ff";
        Color color = Color.web(baby_blue);
        Color colorcito = Color.web(blue);
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                TextField numTxt = new TextField();
                numTxt.setPrefHeight(56);
                numTxt.setPrefWidth(56);
                numTxt.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, new BorderWidths(1))));
                numTxt.setAlignment(Pos.CENTER);
                numTxt.setText(String.valueOf(sudoku.getSudokuBoard()[i][j]));
                if (sudoku.getSudokuBoard()[i][j] > 0){
                    numTxt.setEditable(false);
                    numTxt.setBackground(new Background(new BackgroundFill(color, null, null)));
                }
                else{
                    numTxt.setText("");
                    numTxt.setBackground(new Background(new BackgroundFill(colorcito, null, null)));
                }
                sudokuBoard.add(numTxt, i, j);
                onKeyReleased(numTxt, i, j);
            }
        }
    }

    private void onKeyReleased(TextField numTxt, int i, int j) {
        numTxt.setOnKeyReleased(keyEvent -> {
            String num = numTxt.getText();
            if (!isValidNum(num)) {
                AlertBox alertBox = new AlertBox();
                alertBox.showMessage("Error","Has ingresado un caracter invalido," +
                        "por favor intenta de nuevo");
                numTxt.setText("");
            }
            else{
                sudoku.setNumberInTableSudoku(Integer.parseInt(num) ,i, j);
                gameStatus(sudoku.getSudokuBoard());
            }
        });
    }

    private boolean isValidNum(String num) {
        return num.matches("[1-9]") && num.length() == 1;
    }

    public void gameStatus(int[][] sudokuBoard){
        boolean sudokuBoardFull = true;
        outerloop:
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuBoard[i][j] == 0){
                    sudokuBoardFull = false;
                    break outerloop;
                }
            }
        }
        if (sudokuBoardFull){
            GameStatusAlert gameStatusAlert = new GameStatusAlert();
            gameStatusAlert.showMessage("VICTORIA", "Felicidades, has ganado");
        }
    }
}
