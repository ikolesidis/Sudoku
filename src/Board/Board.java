/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 *
 * @author Ilias Kolesidis
 */
public class Board {

    private Cell[] totalines = new Cell[9];
    private Cell[] totalColumns = new Cell[9];
    private Cell[] totalBlocks = new Cell[9];
    private Cell[][] board;      //a board that holds all 81 keys
    public Board() {        //create an empty array
        board = new Cell[9][9];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                board[i][j]= new Cell();
            }
        }
    }
    
    public Cell[] currentLine(int j){        //returns an array with the values of the line's keys
        Cell[] line = new Cell[9];
        for (int i=0;i<9;i++){
            line[i]=board[i][j];
        }
        return line;
    }
    
    public Cell[] currentColumn(int i){      //returns an array with the values of the column's keys
        Cell[] column = new Cell[9];
        for (int j=0;j<9;j++){
            column[j]=board[i][j];
        }
        return column;
    }
    
    public Cell[][] currentCell (int i, int j){      //returns an array with the values of the column's keys
        Cell[][] cell = new Cell[3][3];
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
        return  cell;
    }
    public boolean addCell(int key,int i, int j){        //adds a cell to the board
        if (i>=0&&i<9){
            if (j>=0&&j<9){
                if (key>0&&key<10){
//                    Cell aCell = this.getCell(i,j);
//                    aCell.changeKey(key);
                    board[i][j].changeKey(key);
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
    private Cell getCell(int i, int j){
        return board[i-1][j-1];
    }
    public boolean removeKey(int i,int j){      //removes a key from the board
        if (i>=0&&i<9){
            if (j>=0&&j<9){
//                Cell aCell = this.getCell(i, j);
//                aCell.changeKey(0);
                board[i][j].changeKey(0);
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
    public int getKey( int i , int j){  //returns a key from a selected possition
        return board[i][j].getKey();
    }
}
