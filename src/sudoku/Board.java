/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Ilias Kolesidis
 */
public class Board {

    private int[] totalLines = new int[9];      //an array that holds all 9 lines
    private int[] totalColumns = new int[9];        //an array that holds all 9 columns
    private int[] totalCells = new int[9];      //an array that holds all 9 cells
    private int[][] board;      //a board that holds all 81 keys
    public Board() {        //create an empty array
        board = new int[9][9];
    }
    
    public int[] currentLine(int j){        //returns an array with the values of the line's keys
        int[] line = new int[9];
        for (int i=0;i<9;i++){
            line[i]=board[i][j];
        }
        int[] returnLine = line;
        return returnLine;
    }
    
    public int[] currentColumn(int i){      //returns an array with the values of the column's keys
        int[] column = new int[9];
        for (int j=0;j<9;j++){
            column[j]=board[i][j];
        }
        int[] returnColumn = column;
        return returnColumn;
    }
    
    public int[][] currentCell (int i, int j){      //returns an array with the values of the column's keys
        int[][] cell = new int[3][3];
        int x=0,y;
        if (i<3){
            i=0;
        }else if(i<6){
            i=3;
        }else {
            i=6;
        }
        if (j<3){
            j=0;
        }else if(j<6){
            j=3;
        }else {
            j=6;
        }
        for (int n=i;n<i+3;n++){
            y=0;
            for (int k=j;k<j+3;k++){
                cell[x][y]=board[n][k];
                y++;
            }
            x++;
        }
        int[][] returnCell = cell;
        return  returnCell;
    }
    public boolean addKey(int key,int i, int j){        //adds a key to the board
        if (i>0&&i<10){
            if (j>0&&j<10){
                if (key>0&&key<10){
                    board[i-1][j-1]=key;
                    return true;
                }else{
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
        
    }
    public boolean removeKey(int i,int j){      //removes a key from the board
        if (i>0&&i<10){
            if (j>0&&j<10){
                board[i-1][j-1]=0;
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
    public int getKey(Board keyValues, int i , int j){  //returns a key from a selected possition
        return keyValues.board[i][j];
    }
}
