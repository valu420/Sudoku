package com.example.sudoku.model;

public interface ISudoku {
    Boolean isNumberHorizontal(int number, int row);
    Boolean isNumberVertical(int number, int col);
    void setNumberInTableSudoku(int number, int row, int col);
}
