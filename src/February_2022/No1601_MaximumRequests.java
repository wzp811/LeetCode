package February_2022;

import java.util.*;

public class No1601_MaximumRequests {
    public int maximumRequests(int n,int [][]requests){
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> from = new HashSet<>();
        HashSet<Integer> to = new HashSet<>();
        List<int[]> req = new ArrayList<>();
        int eqCnt = 0;
        for(int i=0;i<requests.length;i++){
            from.add(requests[i][0]);
            to.add(requests[i][1]);
        }
        for(int i=0;i<requests.length;i++){
            if(requests[i][0]==requests[i][1]) eqCnt++;
            else if(to.contains(requests[i][0])&&from.contains(requests[i][1])) req.add(requests[i]);
        }
        System.out.println(eqCnt);
        for(int i=0;i<req.size();i++) System.out.print(Arrays.toString(req.get(i))+" ");
        System.out.println();
        int len = req.size();
        while(len>0) {
            map.clear();
            System.out.println("------"+len+"------");
            if (process(len, req, 0, map)) return len+eqCnt;
            len--;
        }
        return 0;
    }
    public boolean process(int rest,List<int[]> requests,int index,HashMap<Integer,Integer> map){
        System.out.println(rest+" "+index+" "+map);
        if(index==requests.size()) return rest==0&&map.isEmpty();
        else if(rest>requests.size()-index) return false;
        boolean ans = false;
        ans |= process(rest,requests,index+1,map);
        if(rest==0||ans) return ans;
        int fromCnt = map.getOrDefault(requests.get(index)[0],new Integer(0));
        int toCnt = map.getOrDefault(requests.get(index)[1],new Integer(0));
        fromCnt--;
        toCnt++;
        if(fromCnt==0) map.remove(requests.get(index)[0]);
        else map.put(requests.get(index)[0],fromCnt);
        if(toCnt==0) map.remove(requests.get(index)[1]);
        else map.put(requests.get(index)[1],toCnt);
        ans |= process(rest-1,requests,index+1,map);
        if(fromCnt!=-1) map.put(requests.get(index)[0],fromCnt+1);
        else if(fromCnt==-1&&map.containsKey(requests.get(index)[0])) map.remove(requests.get(index)[0]);
        if(toCnt!=1) map.put(requests.get(index)[1],toCnt-1);
        else if(toCnt==1&&map.containsKey(requests.get(index)[1])) map.remove(requests.get(index)[1]);
        return ans;
    }

    public static void main(String[] args) {
        No1601_MaximumRequests obj = new No1601_MaximumRequests();
//        int[][] requests = new int[][]{{1, 2}, {1, 2}, {2, 2}, {0, 2}, {2, 1}, {1, 1}, {1, 2}};
//        int[][] requests = new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}};
        int[][] requests = new int[][]{{1, 0}, {0, 0}, {1, 0}, {0, 1}, {0, 1}, {1, 1}, {0, 1}, {0, 0}, {0, 0}, {0, 1}, {1, 0}, {0, 0}, {0, 1}, {1, 1}, {1, 1}};
        System.out.println(obj.maximumRequests(2,requests));
    }
}

