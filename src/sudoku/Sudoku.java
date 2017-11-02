/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import SudokuGenerator.GenerateRandom;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import Help.PencilMarks;


/**
 *
 * @author Ilias Kolesidis
 */
public class Sudoku {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //generateAndPrintRandomBoard(100);
        BoardGui a;
        //PencilMarks marks = new PencilMarks();
        a = new BoardGui();
        a.setVisible(true);
    }
    
    public static Board createRandomCompletedBoard(){ //Creates a completed board and returns it
        GenerateRandom newBoard = new GenerateRandom();
        while (!newBoard.checkIfCompleted){ // while is here because GenerateRandom is brute force and doesnt always completes a board
            newBoard = new GenerateRandom();
        }
        return newBoard.getBoard();
    }
    
    
    private static void generateAndPrintRandomBoard(int count){  // prints to a .txt file complete boards
        try{
            for (int k=0;k<count;k++){
                Board aBoard = createRandomCompletedBoard();
                PrintStream out = new PrintStream(new FileOutputStream("`Sudoku_Puzzles.txt",true));
                out.printf("\n");
                for (int j=0;j<9;j++){
                    for (int i=0;i<9;i+=3){
                        out.printf("%d %d %d  ",aBoard.getKey( aBoard,i, j),aBoard.getKey( aBoard,i+1, j),aBoard.getKey( aBoard,i+2, j));
                    }
                    out.printf("\n");
                    if ((j+1)%3==0){
                     out.printf("\n");
                    }
                }
            }
        }
        catch (FileNotFoundException e){
        }
       
    }
    
}
