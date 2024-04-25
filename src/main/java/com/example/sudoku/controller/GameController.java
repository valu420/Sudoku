package com.example.sudoku.controller;

import com.example.sudoku.model.Sudoku;
import com.example.sudoku.view.alert.AlertBox;
import com.example.sudoku.view.alert.GameStatusAlert;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * The GameController class controls the Sudoku game logic and user interaction.
 */
public class GameController {

    @FXML
    private GridPane sudokuBoard;

    Sudoku sudoku = new Sudoku();
    /**
     * The initialize method is called when the FXML file is loaded.
     * It sets up the Sudoku grid and handles user input.
     */

    // This method is called when the FXML file is loaded
    @FXML
    public void initialize(){
        // Define colors for cells
        Color cellColor = Color.web("#BF93F3");
        Color defaultcellColor = Color.web("#D9C1F5");

        // Loop through each cell in the Sudoku grid
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){

                // Create a TextField for each cell
                TextField numTxt = new TextField();
                numTxt.setPrefHeight(56);
                numTxt.setPrefWidth(56);
                numTxt.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, new BorderWidths(1))));
                numTxt.setAlignment(Pos.CENTER);
                //numTxt.setText(String.valueOf(sudoku.getSudokuBoard()[i][j]));

                // If the cell has a pre-filled number, set it and make the TextField uneditable
                if (sudoku.getSudokuBoard()[i][j] > 0){
                    numTxt.setText(String.valueOf(sudoku.getSudokuBoard()[i][j]));
                    numTxt.setEditable(false);
                    numTxt.setBackground(new Background(new BackgroundFill(cellColor, null, null)));
                }
                else{
                    numTxt.setText("");
                    numTxt.setBackground(new Background(new BackgroundFill(defaultcellColor, null, null)));
                }

                // Add the TextField to the GridPane
                sudokuBoard.add(numTxt,j,i);
                // Call onKeyReleased method for each TextField
                onKeyReleased(numTxt, i, j);
            }
        }
    }
    /**
     * Method to handle key release events for text fields.
     * It validates user input and updates the Sudoku board accordingly.
     *
     * @param numTxt The TextField object representing the current cell.
     * @param i The row index of the current cell.
     * @param j The column index of the current cell.
     */

    // Method to handle key release events for text fields
    private void onKeyReleased(TextField numTxt, int i, int j) {
        numTxt.setOnKeyReleased(keyEvent -> {
            String num = numTxt.getText();

            // Show an error message if the entered character is invalid
            if (!isValidNum(num)) {
                AlertBox alertBox = new AlertBox();
                alertBox.showMessage("Error","Has ingresado un caracter invalido," +
                        "por favor intenta de nuevo");
                numTxt.setText("");
            }

            else{
                // Set the number in the Sudoku table
                sudoku.setNumberInTableSudoku(Integer.parseInt(num) ,i, j);
                // Check if the entered number is repeated in its row or column
                isRepeatedNum(sudoku, numTxt, i, j);
<<<<<<< HEAD
                // Check the game status
                gameStatus(sudoku.getSudokuBoard());
=======

>>>>>>> cdd36013d9e3d65c0b47c206b65d7b6cf0fd1f22
            }
        });
    }
    /**
     * Method to check if the entered number is valid (between 1 and 9).
     *
     * @param num The string representation of the entered number.
     * @return true if the number is valid, false otherwise.
     */

    // Method to check if the entered number is valid (between 1 and 9)
    private boolean isValidNum(String num) {
        return num.matches("[1-9]") && num.length() == 1;
    }

    /**
     * Method to check the game status (if the Sudoku board is full).
     * If the board is full, it displays a victory message.
     *
     * @param sudokuBoard The 2D array representing the Sudoku board.
     */
    // Method to check the game status (if the Sudoku board is full)
    public void gameStatus(int[][] sudokuBoard){
        boolean sudokuBoardFull = true;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuBoard[i][j] == 0){
                    sudokuBoardFull = false;

                }
            }
        }

        if (sudokuBoardFull){
            // Show a victory message if the Sudoku board is full
            GameStatusAlert gameStatusAlert = new GameStatusAlert();
            gameStatusAlert.showMessage("VICTORIA", "Felicidades, has ganado");

        }
    }
    /**
     * Method to check if the entered number is repeated in its row or column.
     * If it's repeated, it displays an error message.
     *
     * @param sudoku The Sudoku object representing the game state.
     * @param numTxt The TextField object representing the current cell.
     * @param i The row index of the current cell.
     * @param j The column index of the current cell.
     */

    // Method to check if the entered number is repeated in its row or column
    private void isRepeatedNum(Sudoku sudoku, TextField numTxt, int i, int j) {
        if ((sudoku.isNumberVertical(sudoku.getSudokuBoard()[i][j], j)) ||
                (sudoku.isNumberHorizontal(sudoku.getSudokuBoard()[i][j], i))) {

            // Show an error message if the entered number is repeated in its row or column
            AlertBox alertBox = new AlertBox();
            alertBox.showMessage("ERROR", "El digito que ingresaste se repite en su columna y/o fila. Ingresa de nuevo un digito");
            numTxt.setText("");

        }
        else{
            gameStatus(sudoku.getSudokuBoard());
        }

    }
}
