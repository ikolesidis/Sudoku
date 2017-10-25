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
public class PlaceholderCmdUI {

    private Board boardCMD;
    private Scanner scan = new Scanner(System.in);
    private String stringCommand;
    public PlaceholderCmdUI(Board input) {
        boardCMD=input;
    }
    public void startCmd(){
        int command=0;
        while (command!=3){
            printBoard();
            //System.out.println("\n");
            System.out.println("1 - Insert key");
            System.out.println("2 - Delete key");
            System.out.println("3 - Exit");
            stringCommand = scan.next();
            command=Integer.parseInt(stringCommand);
            commandExecute(command);
        }
        scan.close();
    }
    private void printBoard(){
        System.out.printf("\n");
        for (int j=0;j<9;j++){
            for (int i=0;i<9;i+=3){
                System.out.printf("%d %d %d | ",boardCMD.board[i][j],boardCMD.board[i+1][j],boardCMD.board[i+2][j]);
            }
            System.out.printf("\n");
            if ((j+1)%3==0){
                System.out.printf("- - -  - - -  - - - \n");
            }
        }
    }
    private void commandExecute(int i){
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
            boardCMD.addKey(key, line, column);
        }else if (i == 2){
            System.out.println("Please enter the line");
            stringCommand = scan.next();
            line=Integer.parseInt(stringCommand);
            System.out.println("Please enter the column");
            stringCommand = scan.next();
            column=Integer.parseInt(stringCommand);
            boardCMD.removeKey(line, column);
        }else if (i ==3){
        }else{
            System.out.println("Wrong command please input a correct one");
            stringCommand = scan.next();
            key=Integer.parseInt(stringCommand);
            commandExecute(key);
        }
    }
    
}
