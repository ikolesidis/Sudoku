/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SudokuGenerator;
import java.util.Scanner;

/**
 *
 * @author Ilias Kolesidis
 */
public class DIfficulty {
    private Scanner input = new Scanner(System.in);
    private int command;
    private String stringCommand;
    public DIfficulty() {
        System.out.println("Select difficulty");
        System.out.println("1 - Easy");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");
        System.out.println("4 - Hell");
        stringCommand = input.next();
        command=Integer.parseInt(stringCommand);        
    }    
}
