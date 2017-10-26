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
    public boolean checkNull=false;
    //int key = randomKey.nextInt(9)+1;
    private int[] testLine = new int[9];
    private int[] testColumn = new int[9];
    private int[][] testCell = new int[3][3];
    private PlaceholderCmdUI gui=  new PlaceholderCmdUI(generatedBoard);
    private Set<Integer> keySet = new HashSet<>(9);
    public GenerateRandom() {
        int flag=0;
        int key=0;
        int aKey=0;
        int counts=0;
        for (int k=0;k<3;k++){
            for (int l=0;l<3;l++){
                for (int x=(k+1)*3;x>k*3;x--){
                    for (int y=(l+1)*3;y>l*3;y--){
                        if(key!=-1){
                        key=generateRandomKeyAndCheck(aKey, keySet,x,y);
                        keySet.add(key);
                        counts++;
                        System.out.printf("\n %d : %d -k: %d l: %d  x: %d  y :%d ",counts,key,k,l,x,y);
                        generatedBoard.addKey(key, x, y);
                        //gui = new PlaceholderCmdUI(generatedBoard);
                        //gui.printBoard(generatedBoard);
                        //System.out.println("fcg");
                        //key=0;
                        //aKey=0;
                        }
                        //key=-1;
                    }
                }
                //int kool=0;
                keySet.clear();
            }
        }
        if (key==-1){
            checkNull=true;
        }
//    gui = new PlaceholderCmdUI(generatedBoard);
//    gui.startCmd(); 
    }
    private int generateRandomKeyAndCheck(int key,Set<Integer> keysSet,int x, int y){
        key=randomKey.nextInt(9)+1;
        int flag1=0;
        int flag2=0;
        int count=0;
        testLine = generatedBoard.currentLine(y-1);
        testColumn = generatedBoard.CurrentColumn(x-1);
        while (flag1==0||flag2==0){
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
                if (flag2==0){
                    if (keySet.contains(key)){
                        key=randomKey.nextInt(9)+1;
                        count++;
                        if (count==100){
                            return -1;
                        }
                    }else{
                        flag1=1;
                        flag2=1;
                    }
                }else {
                    flag2=0;
                    key=randomKey.nextInt(9)+1;
                    count++;
                    if (count==100){
                        return -1;
                    }
                }
                
            }
        return key;
    }

    
    
    //    ------  temp getBoard
    public int getKey(int i, int j){
        return generatedBoard.getKey(generatedBoard, i, j);
    }
}
