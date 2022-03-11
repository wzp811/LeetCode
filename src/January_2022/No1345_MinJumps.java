package January_2022;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class No1345_MinJumps {
    public int minJumps1(int[] arr){
        if(arr.length<=2)
            return arr.length-1;
        HashSet<Integer> touchedIndex = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int []floor = new int [arr.length];
        Arrays.fill(arr,0);
        int index = 0;
        q.add(index);
        touchedIndex.add(index);
        while(!q.isEmpty()){
            for(int i=0;i<arr.length;i++){
                System.out.print(floor[i]+"\t");
            }
            System.out.println();
            index = q.poll();
            if(index==arr.length-1)
                return floor[arr.length-1];
            if(index+1<arr.length&&!touchedIndex.contains(index+1)){
                floor[index+1] = floor[index]+1;
                q.add(index+1);
                touchedIndex.add(index+1);
            }
            if(index-1>=0&&!touchedIndex.contains(index-1)){
                floor[index-1] = floor[index]+1;
                q.add(index-1);
                touchedIndex.add(index-1);
            }
            for(int i=0;i<arr.length;i++){
                if(arr[i]==arr[index]&&i!=index&&!touchedIndex.contains(i)){
                    floor[i] = floor[index]+1;
                    q.add(i);
                    touchedIndex.add(i);
                }
            }
        }
        return floor[arr.length-1];
    }
    public int minJumps2(int[] arr){
        if(arr.length<=2)
            return arr.length-1;
        HashSet<Integer> touchIndex = new HashSet<>();
        int []floor = new int[arr.length];
        Arrays.fill(floor,0);
        Queue<Integer> q = new LinkedList<>();
        int index = 0;
        q.add(index);
        while (!q.isEmpty()){
            index = q.poll();
            if(index==arr.length-1)
                return floor[index];
            if(index+1<arr.length&&!touchIndex.contains(index+1)){
                q.add(index+1);
                touchIndex.add(index+1);
                floor[index+1] = floor[index]+1;
            }
            if(index-1>=0&&!touchIndex.contains(index-1)){
                q.add(index-1);
                touchIndex.add(index-1);
                floor[index-1] = floor[index]+1;
            }
            for(int i=0;i<arr.length;i++){
                if(arr[i]==arr[index]&&i!=index&&!touchIndex.contains(i)){
                    q.add(i);
                    touchIndex.add(i);
                    floor[i] = floor[index]+1;
                }
            }
        }
        return arr[index];
    }
    public int minJumpsWithDebugDisplay(int[] arr){
        if(arr.length<=2){
            return arr.length-1;
        }
        HashMap<Integer,List<Integer>> valMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            List<Integer> tmp = valMap.getOrDefault(arr[i],new LinkedList<>());
            tmp.add(i);
            valMap.put(arr[i],tmp);
        }
        int []floor = new int[arr.length];
        Arrays.fill(floor,-1);
        Queue<Integer> q = new LinkedList<>();
        int index = 0;
        q.add(index);
        floor[index] = 0;
        while(!q.isEmpty()){
            System.out.println(index+"\t"+arr[index]);
            for(int i=0;i<arr.length;i++){
                System.out.print(floor[i]+"\t");
            }
            System.out.println();
            index = q.poll();
            if(index+1<arr.length&&floor[index+1]==-1){
                q.add(index+1);
                floor[index+1] = floor[index]+1;
            }
            if(index-1>=0&&floor[index-1]==-1){
                q.add(index-1);
                floor[index-1] = floor[index]+1;
            }
            List<Integer> tmp = valMap.getOrDefault(arr[index],new LinkedList<>());
            System.out.println("list:"+tmp);
            System.out.println("map:"+valMap);
            for(int i=0;i<tmp.size();i++){
                if(tmp.get(i)!=index&&floor[tmp.get(i)]==-1){
                    q.add(tmp.get(i));
                    floor[tmp.get(i)] = floor[index]+1;
                }
            }
            valMap.remove(arr[index]);
        }
        return floor[arr.length-1];
    }
    public int minJumps(int[] arr){
        if(arr.length<=2){
            return arr.length-1;
        }
        HashMap<Integer,List<Integer>> valMap = new HashMap<>();
        for(int i=arr.length-1;i>=0;i--){
            List<Integer> tmp = valMap.getOrDefault(arr[i],new LinkedList<>());
            tmp.add(i);
            valMap.put(arr[i],tmp);
        }
        int []floor = new int[arr.length];
        Arrays.fill(floor,-1);
        Queue<Integer> q = new LinkedList<>();
        int index = 0;
        q.add(index);
        floor[index] = 0;
        while(!q.isEmpty()){
            index = q.poll();
            if(arr[index]==arr[arr.length-1])
                return index==arr.length-1?floor[index]:(floor[arr.length-1]==-1?floor[index]+1:floor[arr.length-1]);
            if(index+1<arr.length&&floor[index+1]==-1){
                q.add(index+1);
                floor[index+1] = floor[index]+1;
            }
            if(index-1>=0&&floor[index-1]==-1){
                q.add(index-1);
                floor[index-1] = floor[index]+1;
            }
            List<Integer> tmp = valMap.getOrDefault(arr[index],new LinkedList<>());
            for(int i=0;i<tmp.size();i++){
                if(tmp.get(i)!=index&&floor[tmp.get(i)]==-1){
                    q.add(tmp.get(i));
                    floor[tmp.get(i)] = floor[index]+1;
                }
            }
            valMap.remove(arr[index]);
        }
        return floor[arr.length-1];
    }
    public void display(int[] arr,HashMap<Integer,Integer> m){
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(i+"\t");
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        for(int i=0;i<arr.length;i++){
            System.out.print((m.get(i)>10000?"MAX":m.get(i))+"\t");
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
    }



    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>();
//        l.add(100);
//        l.add(-23);
//        l.add(-23);
//        l.add(404);
//        l.add(100);
//        l.add(23);
//        l.add(23);
//        l.add(23);
//        l.add(3);
//        l.add(404);

//        l.add(7);
//        l.add(6);
//        l.add(9);
//        l.add(6);
//        l.add(9);
//        l.add(6);
//        l.add(9);
//        l.add(7);

        l.add(6);
        l.add(1);
        l.add(9);

        int []arr = l.stream().mapToInt(Integer::valueOf).toArray();
        No1345_MinJumps obj = new No1345_MinJumps();
        System.out.println(obj.minJumps(arr));
    }
}
//100   -23 -23 404 100 23  23  23  3   404