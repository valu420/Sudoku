package com.example.sudoku.model;

public class Sudoku implements ISudoku {
    private int [][] sudokuBoard;

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


    @Override
    public void setNumberInTableSudoku(int number, int row, int col) {
        this.sudokuBoard[row][col] = number;
    }

    public int[][] getSudokuBoard() {
        return sudokuBoard;
    }


}
