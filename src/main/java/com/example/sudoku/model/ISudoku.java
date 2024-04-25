package com.example.sudoku.model;
/**
 * The ISudoku interface defines the functionality required for Sudoku.
 */

// Interface for Sudoku functionality
public interface ISudoku {
    /**
     * Method to check if a number is present horizontally in a row.
     *
     * @param number The number to check.
     * @param row The index of the row to check.
     * @return true if the number is present more than once in the row, false otherwise.
     */

    // Method to check if a number is present horizontally in a row
    Boolean isNumberHorizontal(int number, int row);
    /**
     * Method to check if a number is present vertically in a column.
     *
     * @param number The number to check.
     * @param col The index of the column to check.
     * @return true if the number is present more than once in the column, false otherwise.
     */

    // Method to check if a number is present vertically in a column
    Boolean isNumberVertical(int number, int col);
    /**
     * Method to set a number in the Sudoku table at specified row and column.
     *
     * @param number The number to set.
     * @param row The index of the row.
     * @param col The index of the column.
     */

    // Method to set a number in the Sudoku table at specified row and column
    void setNumberInTableSudoku(int number, int row, int col);
}
