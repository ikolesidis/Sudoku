/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 *
 * @author Ilias Kolesidis
 */
public class Cell {
    private int key;
    private int[] pencilMarks = new int[9];

    public Cell() {
        key=0;
        for (int i=0;i<9;i++){
            pencilMarks[i]=0;
        }
    }
    public int getKey(){
        return key;
    }
    public void changeKey(int aKey){
        key=aKey;
    }
    public int getPencilMark(int i){
        return pencilMarks[i-1];
    }
    public void addPencilMark(int i){
        pencilMarks[i-1]=i;
    }
}
