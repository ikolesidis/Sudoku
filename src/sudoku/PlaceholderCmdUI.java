/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.util.Scanner; 
/**
 *
 * @author Ilias Kolesidis
 */
public class PlaceholderCmdUI {     //placeholder gui while i create a proper gui

    private Board boardCMD;     //a board to work with
    private Scanner scan = new Scanner(System.in);      //scanner to scan user input
    private String stringCommand;       //string to save the commands to
    public PlaceholderCmdUI(Board aBoard) {      
        boardCMD=aBoard;
    }
    public void startCmd(){     //start the cmd commands
        int command=0;
        while (command!=3){
            printBoard(boardCMD);
            //System.out.println("\n");
            System.out.println("1 - Insert key");
            System.out.println("2 - Delete key");
            System.out.println("3 - Exit");
            stringCommand = scan.next();
            command=Integer.parseInt(stringCommand);
            if (command!=3){
            commandExecute(command);}
        }
        //scan.close();
    }
    private void printBoard(Board boardCMD){        //prints the whole board with nice ascii
        System.out.printf("\n");
        for (int j=0;j<9;j++){
            for (int i=0;i<9;i+=3){
                System.out.printf("%d %d %d | ",boardCMD.getKey(boardCMD, i, j),boardCMD.getKey(boardCMD, i+1, j),boardCMD.getKey(boardCMD, i+2, j));
            }
            System.out.printf("\n");
            if ((j+1)%3==0){
                System.out.printf("- - -  - - -  - - - \n");
            }
        }
    }
    private void commandExecute(int i){     //execute the commands
        int key;
        int line;
        int column;
        if (i==1){
            System.out.println("Please enther the key");
            stringCommand = scan.next();
            key=Integer.parseInt(stringCommand);
            System.out.println("Please enter the line");
            stringCommand = scan.next();
            line=Integer.parseInt(stringCommand);
            System.out.println("Please enter the column");
            stringCommand = scan.next();
            column=Integer.parseInt(stringCommand);
            if (!boardCMD.addKey(key, line, column)){
                System.out.println("Wrong input please try again");
                commandExecute(i);
            }
        }else if (i == 2){
            System.out.println("Please enter the line");
            stringCommand = scan.next();
            line=Integer.parseInt(stringCommand);
            System.out.println("Please enter the column");
            stringCommand = scan.next();
            column=Integer.parseInt(stringCommand);
            if (!boardCMD.removeKey(line, column)){
                System.out.println("Wrong input please try again");
                commandExecute(i);
            }
        }else if (i ==3){
            
        }else{
            System.out.println("Wrong command please input a correct one");
            stringCommand = scan.next();
            key=Integer.parseInt(stringCommand);
            commandExecute(key);
        }
    }
    
}
