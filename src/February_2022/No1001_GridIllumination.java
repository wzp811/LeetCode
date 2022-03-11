package February_2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class No1001_GridIllumination {
    public int[] gridIllumination(int n,int[][] lamps,int[][] queries){
        HashMap<Integer, HashSet<Integer>> lampRow = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> lampCol = new HashMap<>();
        HashMap<Integer,Integer> lu2rl = new HashMap<>();   //left upper to right low
        HashMap<Integer,Integer> ll2ru = new HashMap<>();   //left low to right upper
        int[] res = new int[queries.length];
        for(int i=0;i<lamps.length;i++){
            HashSet<Integer> set = lampRow.getOrDefault(lamps[i][0],new HashSet<>());
            if(!set.contains(lamps[i][1])) {
                set.add(lamps[i][1]);
                lampRow.put(lamps[i][0], set);
                set = lampCol.getOrDefault(lamps[i][1], new HashSet<>());
                set.add(lamps[i][0]);
                lampCol.put(lamps[i][1], set);
                lu2rl.put(lamps[i][1] - lamps[i][0] + n, lu2rl.getOrDefault(lamps[i][1] - lamps[i][0] + n, new Integer(0)) + 1);
                ll2ru.put(lamps[i][1] + lamps[i][0] + 1, ll2ru.getOrDefault(lamps[i][1] + lamps[i][0] + 1, new Integer(0)) + 1);
            }
        }
        System.out.println(lampRow);
        System.out.println(lampCol);
        System.out.println(lu2rl);
        System.out.println(ll2ru);
        System.out.println();
        for(int i=0;i<queries.length;i++){
            int qRow = queries[i][0];
            int qCol = queries[i][1];
            res[i] = lampRow.containsKey(qRow)||lampCol.containsKey(qCol)||lu2rl.containsKey(qCol-qRow+n)||ll2ru.containsKey(qRow+qCol+1)?1:0;
            for(int j=-1;j<=1;j++){
                if(lampRow.containsKey(j+qRow)){
                    HashSet<Integer> set = lampRow.get(j+qRow);
                    if(set.contains(qCol-1)){
                        set.remove(qCol-1);
                        lampCol.get(qCol-1).remove(j+qRow);
                        if(lampCol.get(qCol-1).size()==0) lampCol.remove(qCol-1);
                        if(lu2rl.get(qCol-1-qRow-j+n)>1) lu2rl.put(qCol-1-qRow-j+n,lu2rl.get(qCol-1-qRow-j+n)-1);
                        else lu2rl.remove(qCol-1-qRow-j+n);
                        if(ll2ru.get(qCol-1+qRow+j+1)>1) ll2ru.put(qCol-1+qRow+j+1,ll2ru.get(qCol-1+qRow+j+1)-1);
                        else ll2ru.remove(qCol-1+qRow+j+1);
                    }
                    if(set.contains(qCol)){
                        set.remove(qCol);
                        lampCol.get(qCol).remove(j+qRow);
                        if(lampCol.get(qCol).size()==0) lampCol.remove(qCol);
                        if(lu2rl.get(qCol-qRow-j+n)>1) lu2rl.put(qCol-qRow-j+n,lu2rl.get(qCol-qRow-j+n)-1);
                        else lu2rl.remove(qCol-qRow-j+n);
                        if(ll2ru.get(qCol+qRow+j+1)>1) ll2ru.put(qCol+qRow+j+1,ll2ru.get(qCol+qRow+j+1)-1);
                        else ll2ru.remove(qCol+qRow+j+1);
                    }
                    if(set.contains(qCol+1)){
                        set.remove(qCol+1);
                        lampCol.get(qCol+1).remove(j+qRow);
                        if(lampCol.get(qCol+1).size()==0) lampCol.remove(qCol+1);
                        if(lu2rl.get(qCol+1-qRow-j+n)>1) lu2rl.put(qCol+1-qRow-j+n,lu2rl.get(qCol+1-qRow-j+n)-1);
                        else lu2rl.remove(qCol+1-qRow-j+n);
                        if(ll2ru.get(qCol+1+qRow+j+1)>1) ll2ru.put(qCol+1+qRow+j+1,ll2ru.get(qCol+1+qRow+j+1)-1);
                        else ll2ru.remove(qCol+1+qRow+j+1);
                    }
                    if(set.size()==0) lampRow.remove(j+qRow);
                }
            }
            System.out.println(lampRow);
            System.out.println(lampCol);
            System.out.println(lu2rl);
            System.out.println(ll2ru);
            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        No1001_GridIllumination obj = new No1001_GridIllumination();
//        int[][]lamps = new int[][]{{0,0},{4,4}};
//        int[][]queries = new int[][]{{1,1},{1,1}};
        int[][]lamps = new int[][]{{2, 5}, {4, 2}, {0, 3}, {0, 5}, {1, 4}, {4, 2}, {3, 3}, {1, 0}};
        int[][]queries = new int[][]{{4, 3}, {3, 1}, {5, 3}, {0, 5}, {4, 4}, {3, 3}};
//        int[][]lamps = new int[][]{{0,0},{0,4}};
//        int[][]queries = new int[][]{{0,4},{0,1},{1,4}};
        int[] res = obj.gridIllumination(6,lamps,queries);
        for(int i=0;i<res.length;i++) System.out.print(res[i]+" ");
    }
}