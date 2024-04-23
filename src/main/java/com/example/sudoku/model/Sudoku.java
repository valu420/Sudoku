package com.example.sudoku.model;

public class Sudoku implements ISudoku {
    private int [][] sudokuBoard;

    public Sudoku(){
        this.sudokuBoard = new int[][]{
                {0,0,0,0,9,0,8,2,0},
                {0,1,0,0,0,0,5,0,9},
                {7,0,9,0,1,0,0,0,0},
                {0,6,2,7,0,1,0,9,0},
                {0,0,0,0,6,0,0,0,0},
                {0,8,0,3,0,9,1,4,0},
                {0,0,0,0,8,0,9,0,2},
                {8,0,4,0,0,0,0,3,0},
                {0,1,6,0,3,0,0,0,0}
        };
    }

    @Override
    public Boolean isNumberHorizontal(int number, int row) {
        for(int i=0; i<9; i++){
            if(this.sudokuBoard[row][i] == number){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean isNumberVertical(int number, int col) {
        for(int i=0; i<9; i++){
            if(this.sudokuBoard[i][col] == number){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean isNumberInGroupCell(int number, int row, int col) {

        return true;
    }

//    private void fillSudoku(){
//        this.sudokuBoard[0][3] = 9;
//    }

    @Override
    public void setNumberInTableSudoku(int number, int row, int col) {
        this.sudokuBoard[row][col] = number;
    }

    public int[][] getSudokuBoard() {
        return sudokuBoard;
    }

//    public void setSudokuBoard(int[][] sudokuBoard){
//        this.sudokuBoard = sudokuBoard;
//    }


}
