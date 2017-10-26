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

    private int[] totalLines = new int[9];
    private int[] totalColumns = new int[9];
    private int[][] board;
    public Board() {
        board = new int[9][9];
    }
    
    private int[] currentLine(int j){
        int[] line = new int[9];
        for (int i=0;i<9;i++){
            line[i]=board[i][j];
        }
        return line;
    }
    
    private int[] CurrentColumn(int i){
        int[] column = new int[9];
        for (int j=0;j<9;j++){
            column[j]=board[i][j];
        }
        return column;
    }
    public boolean addKey(int key,int i, int j){
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
    public boolean removeKey(int i,int j){
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
    public int getKey(Board keyValues, int i , int j){
        return keyValues.board[i][j];
    }
}
