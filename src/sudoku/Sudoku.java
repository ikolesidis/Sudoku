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


/**
 *
 * @author Ilias Kolesidis
 */
public class Sudoku {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            int counts=0;
        while (counts<100){    
            
        GenerateRandom board = new GenerateRandom();
        if (!board.checkNull){
        PrintStream out = new PrintStream(new FileOutputStream("`Sudoku_Puzzles.txt",true));
        out.printf("\n");
        for (int j=0;j<9;j++){
            for (int i=0;i<9;i+=3){
                out.printf("%d %d %d | ",board.getKey( i, j),board.getKey( i+1, j),board.getKey( i+2, j));
            }
            out.printf("\n");
            if ((j+1)%3==0){
                out.printf("- - -  - - -  - - - \n");
            }
        }
        out.printf("\n");
        counts++;
        }
        }
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    }
}
