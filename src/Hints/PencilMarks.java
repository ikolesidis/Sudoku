/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hints;
import java.util.HashSet;
import java.util.ArrayList;
/**
 *
 * @author Ilias Kolesidis
 */
public class PencilMarks {
//    private ArrayList<HashSet<Integer>> totalLines = new ArrayList<HashSet<Integer>>(9);
//    private ArrayList<HashSet<Integer>> totalColumns = new ArrayList<HashSet<Integer>>(9);
//    private ArrayList<HashSet<Integer>> totalCells = new ArrayList<HashSet<Integer>>(9);
    private ArrayList<ArrayList> DList = new ArrayList<ArrayList>(9);
    
    public PencilMarks() {
        for (int i=0;i<9;i++){
            ArrayList<HashSet> DDList = new ArrayList<HashSet>(9);
            //DList.add(DDList);
            for (int j=0;j<9;j++){
                HashSet<Integer> cellSet = new HashSet<Integer>(9);
                DDList.add(cellSet);
            }
            DList.add(DDList);
        }
    }
    public boolean addPencilMark(int key,int i, int j){
        ArrayList<HashSet> aList = DList.get(i);
        HashSet<Integer> aSet = aList.get(j);
        if (aSet.add(key)){
            aList.set(j,aSet);
            DList.set(i, aList);
            return true;
        }
        return false;
    }
    
    public boolean removePencilMark(int key,int i, int j){
        ArrayList<HashSet> aList = DList.get(i);
        HashSet<Integer> aSet = aList.get(j);
        if (aSet.remove(key)){
            aList.set(j, aSet);
            DList.set(i,aList);
            return true;
        }
        return false;
    }
    
    public void printPencilMark(int i,int j){
        ArrayList<HashSet> aList = DList.get(i);
        HashSet<Integer> aSet = aList.get(j);
        for (Integer key:aSet){
            System.out.printf("\n %d",key);
        }
    }
}
