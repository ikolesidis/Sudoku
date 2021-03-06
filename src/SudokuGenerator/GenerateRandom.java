/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SudokuGenerator;
import Board.Board;
import Board.Cell;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ilias Kolesidis
 */
public class GenerateRandom {
    private Board generatedBoard = new Board();     //Main Board
    private Random randomKey = new Random();        //Random number generator
    public boolean checkIfCompleted=false;      //Boolean that checks if the board if complete
    private Cell[] testLine = new Cell[9];        //an array that holds all 9 lines of the board
    private Cell[] testColumn = new Cell[9];      //an array that holds all 9 columns of the board
    private Cell[][] testCell = new Cell[3][3];       //an array that holds all 9 cells of the board, cells are 3x3 regions
    private Set<Integer> keySet = new HashSet<>(9);     //A set that holds 9 integers
    private int counting;
    
    
    public GenerateRandom() {

    }
    public Board generateUntilCompleted(){
        generateBoard();
        while (!checkIfCompleted){
            generateBoard();
        }
        return generatedBoard;
    }
    private void generateBoard(){
        int key=0;      // the key that will be put in the board
        int aKey=0;     //placeholder key
        counting =0;
        for (int k=0;k<3;k++){      //this and
            for (int l=0;l<3;l++){      //this is for traversal of the board cell by cell
                for (int x=(k+1)*3;x>k*3;x--){      //this and
                    for (int y=(l+1)*3;y>l*3;y--){      //this is for traversal within the cell
                        if(key!=-1){        //-1 is the value that means the generation has failed
                        key=generateRandomKeyAndCheck(aKey, keySet,x-1,y-1);        //generate a number that can fit
                        keySet.add(key);        //add the key to the set so that it can be checked for future generation
                        generatedBoard.addCell(key, x-1, y-1);       //input the key to the board
                        counting++;
                        }
                    }
                }
                keySet.clear();     // since the cell is completed then the set is reset
            }
        }
        if (key!=-1){       //if the key isnt -1 then generation was successful
            checkIfCompleted=true;
        }
        if(counting>1){
        System.out.printf("\n%d",counting);}
    }
    private int generateRandomKeyAndCheck(int key,Set<Integer> keysSet,int x, int y){   //generate a number and check if it can fit
        key=randomKey.nextInt(9)+1;     //key = new random number (1-9)
        int flag1=0;        
        int flag2=0;
        int count=0;        //counts how many times the random number isnt correct
        testLine = generatedBoard.currentLine(y);         
        testColumn = generatedBoard.currentColumn(x);
        while (flag1==0||flag2==0){
                for (int i =0;i<9;i++){     //check if the key is already in its line
                    if (testLine[i].getKey()==key){
                        count++;
                        if (count==50){     // if it has failed 50 times the generation has failed
                            return -1;
                        }
                        flag2=1;
                        break;
                    }
                }
                if (flag2==0){      //check if the key is already in it column
                    for (int j=0;j<9;j++){
                        if (testColumn[j].getKey()==key){
                            count++;
                            if(count==50){
                                return -1;
                            }
                            flag2=1;
                            break;
                        }
                    }
                }
                if (flag2==0){      //if it is not in its line and column then check its cell
                    if (keySet.contains(key)){
                        key=randomKey.nextInt(9)+1;
                        count++;
                        if (count==50){
                            return -1;
                        }
                    }else{      //exit the while
                        flag1=1;
                        flag2=1;
                    }
                }else {
                    flag2=0;
                    key=randomKey.nextInt(9)+1;
                    count++;
                    if (count==50){
                        return -1;
                    }
                }
                
            }
        return key;
    }
    public void printBoard(){
        try{
            PrintStream out = new PrintStream(new FileOutputStream("`Sudoku_Puzzles.txt",true));
            System.out.println("Printed");
            out.printf("\n");
            for (int j=0;j<9;j++){
                for (int i=0;i<9;i=i+3){
                    out.printf("%d %d %d  ",generatedBoard.getKey(i, j),generatedBoard.getKey(i+1, j),generatedBoard.getKey(i+2, j));
                }
                out.printf("\n");
                if ((j+1)%3==0){
                    out.printf("\n");
                }
            }
        }
        catch (FileNotFoundException e){
        }
    }
}
