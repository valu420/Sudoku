package com.example.sudoku.model;

public class Sudoku implements ISudoku {
    private int [][] tableSudoku;

    public Sudoku(){
        this.tableSudoku = new int[9][9];
        fillSudoku();
    }

    @Override
    public Boolean isNumberHorizontal(int number, int row) {
        for(int i=0; i<9; i++){
            if(this.tableSudoku[row][i] == number){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean isNumberVertical(int number, int col) {
        for(int i=0; i<9; i++){
            if(this.tableSudoku[i][col] == number){
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean isNumberInGroupCell(int number, int row, int col) {
        
        return true;
    }



    private void fillSudoku(){
        this.tableSudoku[0][3] = 9;
    }

    @Override
    public void setNumberInTableSudoku(int number, int row, int col) {
        this.tableSudoku[number] [row] = number;
    }

    public int[][] getTableSudoku() {
        return tableSudoku;
    }

    public void setTableSudoku(int[][] tableSudoku) {
        this.tableSudoku = tableSudoku;
    }
}
