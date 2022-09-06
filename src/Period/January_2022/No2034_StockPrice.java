package Period.January_2022;

import java.util.*;

public class No2034_StockPrice {
    class StockPrice {
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int latelyTime = -1;
        public StockPrice() {
        }
        public void update(int timestamp, int price) {
            if(timestamp>latelyTime)
                latelyTime = timestamp;
            if(hm.containsKey(timestamp)){
                int oldprice = hm.get(timestamp);
                tm.put(hm.get(timestamp),tm.get(hm.get(timestamp))-1);
                if(tm.get(oldprice)==0)
                    tm.remove(oldprice);
                hm.put(timestamp,price);
                tm.put(price,tm.containsKey(price)?tm.get(price)+1:1);
            }else{
                hm.put(timestamp,price);
                tm.put(price,tm.containsKey(price)?tm.get(price)+1:1);
            }
        }
        public int current() {
            return hm.get(latelyTime);
        }
        public int maximum() {
            return tm.lastKey();
        }
        public int minimum() {
            return tm.firstKey();
        }
    }
}
