/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SudokuGenerator;
import sudoku.Board;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import sudoku.PlaceholderCmdUI;

/**
 *
 * @author Ilias Kolesidis
 */
public class GenerateRandom {
    private Board generatedBoard = new Board();
    private Random randomKey = new Random();
    //int key = randomKey.nextInt(9)+1;
    private int[] testLine = new int[9];
    private int[] testColumn = new int[9];
    private int[][] testCell = new int[3][3];
    private PlaceholderCmdUI gui=  new PlaceholderCmdUI(generatedBoard);
    private Set<Integer> keySet = new HashSet<>(9);
    public GenerateRandom() {
        int flag=0;
        int key;
        int aKey=0;
        int counts=0;
        //int tempX;
        //int tempY;
        for (int k=0;k<3;k++){
            for (int l=0;l<3;l++){
                for (int x=(k+1)*3;x>k*3;x--){
                    for (int y=(l+1)*3;y>l*3;y--){
                        key=generateRandomKeyAndCheck(aKey, keySet,x,y);
                        keySet.add(key);
                        counts++;
                        System.out.printf("\n %d : %d - %d  %d   ",counts,key,x,y);
                        //gui = new PlaceholderCmdUI(generatedBoard);
                        //gui.startCmd();
                        generatedBoard.addKey(key, x, y);
                    }
                }
                keySet.clear();
            }
        }
//    gui = new PlaceholderCmdUI(generatedBoard);
    gui.startCmd(); 
    }
    private int generateRandomKeyAndCheck(int key,Set<Integer> keysSet,int x, int y){
        key=randomKey.nextInt(9)+1;
        int flag1=0;
        int flag2=0;
        testLine = generatedBoard.currentLine(y);
        testColumn = generatedBoard.CurrentColumn(x);
        while (flag1==0||flag2==0){
            if (keySet.contains(key)){
                
            }else{
            flag1=1;
                for (int i =0;i<9;i++){
                    if (testLine[i]==key){
                        flag2=1;
                        break;
                    }
                }
                if (flag2==0){
                    for (int j=0;j<9;j++){
                        if (testColumn[j]==key){
                            flag2=1;
                            break;
                        }
                    }
                }
                if (flag2==1){
                    flag2=0;
                    key=randomKey.nextInt(9)+1;
                }else{
                    flag2=1;
                }
            }
        }
        return key;
    }
        
//        for (int cellX=0;cellX<9;cellX++) {
//            for (int cellY=0;cellY<9;cellY++){
//                flag =0;
//                key = randomKey.nextInt(9)+1;
//                testLine = genaratedBoard.currentLine(cellY);
//                testColumn = genaratedBoard.CurrentColumn(cellX);
//                testCell = genaratedBoard.CurrentCell(cellX,cellY);
//                for (int i =0;i<9;i++){
//                    if (testLine[i]==key){
//                        flag=1;
//                        break;
//                    }
//                }
//                if (flag==0){
//                    for (int j=0;j<9;j++){
//                        if (testColumn[j]==key){
//                            flag=1;
//                            break;
//                        }
//                    }
//                }
//                if (flag==0){
//                    for (int i =0;i<3;i++){
//                        for (int j=0;j<3;j++){
//                            if (testCell[i][j]==key){
//                                flag=1;
//                                break;
//                            }
//                        }
//                    }
//                }
//                if (flag==0){
//                    tempX=cellX+1;
//                    tempY=cellY+1;
//                    genaratedBoard.addKey(key, tempX,tempY);
//                }else {
//                    cellY--;
//                }
//            }
//        }

    

}
