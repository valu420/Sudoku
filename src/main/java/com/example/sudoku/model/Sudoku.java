package com.example.sudoku.model;

/**
 * The Sudoku class represents a Sudoku puzzle and implements the ISudoku interface.
 */
public class Sudoku implements ISudoku {
    private int [][] sudokuBoard;
    /**
     * Constructor to initialize the Sudoku board with a predefined puzzle.
     */

    // Constructor to initialize the Sudoku board with a predefined puzzle
    public Sudoku(){
        this.sudokuBoard = new int[][]{
                {0,0,3,5,9,0,8,2,0},
                {0,1,0,0,0,3,5,0,9},
                {7,0,9,0,1,0,0,0,0},
                {0,6,2,7,0,1,0,9,0},
                {9,0,0,0,0,0,0,5,0},
                {0,8,0,3,0,9,1,4,0},
                {0,7,0,0,8,0,9,0,2},
                {8,0,4,1,7,0,0,3,0},
                {0,2,6,0,3,0,0,0,4}
        };
    }
    /**
     * Method to check if a given number already exists horizontally in a specified row.
     *
     * @param number The number to check.
     * @param row    The index of the row to check.
     * @return true if the number exists more than once in the row, false otherwise.
     */

    // Method to check if a given number already exists horizontally in a specified row
    @Override
    public Boolean isNumberHorizontal(int number, int row) {
        int count = 0;
        for(int i=0; i<9; i++){
            if(this.sudokuBoard[row][i] == number){
                count = count + 1;
            }
        }
        return count > 1;
    }
    /**
     * Method to check if a given number already exists vertically in a specified column.
     *
     * @param number The number to check.
     * @param col    The index of the column to check.
     * @return true if the number exists more than once in the column, false otherwise.
     */

    // Method to check if a given number already exists vertically in a specified column
    @Override
    public Boolean isNumberVertical(int number, int col) {
        int count = 0;
        for(int i=0; i<9; i++){
            if(this.sudokuBoard[i][col] == number){
                count = count + 1;
            }
        }
        return count > 1;
    }

    /**
     * Method to set a number in the Sudoku table at a specified row and column.
     *
     * @param number The number to set.
     * @param row    The index of the row.
     * @param col    The index of the column.
     */
    // Method to set a number in the Sudoku table at a specified row and column
    @Override
    public void setNumberInTableSudoku(int number, int row, int col) {
        this.sudokuBoard[row][col] = number;
    }

    /**
     * Getter method to retrieve the Sudoku board.
     *
     * @return The Sudoku board as a 2D array.
     */

    // Getter method to retrieve the Sudoku board
    public int[][] getSudokuBoard() {
        return sudokuBoard;
    }


}
