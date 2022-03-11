package January_2022;

import java.util.*;

class TComparator implements Comparator<List<String>>{
    public int compare(List<String> s1,List<String> s2){
        if(s1.get(0).equals(s2.get(0))) {
            return s1.get(1).charAt(0) == s2.get(1).charAt(0) ?
                    (s1.get(1).charAt(1) == s2.get(1).charAt(1) ?
                            s1.get(1).charAt(2) - s2.get(1).charAt(2) : s1.get(1).charAt(1) - s2.get(1).charAt(1)) :
                    s1.get(1).charAt(0) - s2.get(1).charAt(0);
        }
        return s1.get(0).charAt(0)==s2.get(0).charAt(0)?
                (s1.get(0).charAt(1)==s2.get(0).charAt(1)?
                        s1.get(0).charAt(2)-s2.get(0).charAt(2):s1.get(0).charAt(1)-s2.get(0).charAt(1)):
                s1.get(0).charAt(0)-s2.get(0).charAt(0);
    }
}

public class No332_FindItinerary {
    public List<String> findItinerary(List<List<String>> tickets){
        Collections.sort(tickets,new TComparator());
        List<String> res = new LinkedList<>();
        boolean[] used = new boolean[tickets.size()];
        Arrays.fill(used,false);
        res.add("JFK");
        process(tickets,0,res,"JFK",used);
        return res;
    }
    public boolean process(List<List<String>> tickets,int count,List<String> res,String cur,boolean[] used){
        if(count==tickets.size()) return true;
        int size = res.size();
        String curcpy = new String(cur);
        for(int i=0;i<tickets.size();i++){
//            System.out.println(count+"\ttickets: "+tickets.get(i).get(0)+"\t"+tickets.get(i).get(1)+"\tcur: "+cur);
            if(!used[i]&&tickets.get(i).get(0).equals(cur)){
                cur = tickets.get(i).get(1);
                res.add(cur);
                used[i] = true;
                if(process(tickets,count+1,res,cur,used)) return true;
                used[i] = false;
                res.remove(size);
                cur = curcpy;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        No332_FindItinerary obj = new No332_FindItinerary();
        /*
        List<List<String>> tickets = new LinkedList<List<String>>(){{
            add(new LinkedList<String>(){{
                add("JFK");
                add("SFO");
            }});
            add(new LinkedList<String>(){{
                add("JFK");
                add("ATL");
            }});
            add(new LinkedList<String>(){{
                add("SFO");
                add("ATL");
            }});
            add(new LinkedList<String>(){{
                add("ATL");
                add("JFK");
            }});
            add(new LinkedList<String>(){{
                add("ATL");
                add("SFO");
            }});
        }};
         */
        List<List<String>> tickets = new LinkedList<List<String>>(){{
            add(new LinkedList<String>(){{
                add("JFK");
                add("KUL");
            }});
            add(new LinkedList<String>(){{
                add("JFK");
                add("NRT");
            }});
            add(new LinkedList<String>(){{
                add("NRT");
                add("JFK");
            }});
        }};
        System.out.println(obj.findItinerary(tickets));
    }
}
