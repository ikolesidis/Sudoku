/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import SudokuGenerator.GenerateRandom;
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
        for (int i=0;i<10;i++){
            GenerateRandom aBoard = new GenerateRandom();
            aBoard.generateUntilCompleted();
            aBoard.printBoard();
        }
    }
    
}
