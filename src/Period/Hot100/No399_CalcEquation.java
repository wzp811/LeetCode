package Period.Hot100;

import java.util.*;

public class No399_CalcEquation {
    public double[] calcEquation(List<List<String>> equations,double[] values,List<List<String>> queries){
        HashMap<String,HashMap<String,Double>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<equations.size();i++){
            HashMap<String,Double> tmp1 = map.getOrDefault(equations.get(i).get(0),new HashMap<>());
            HashMap<String,Double> tmp2 = map.getOrDefault(equations.get(i).get(1),new HashMap<>());
            tmp1.put(equations.get(i).get(1),values[i]);
            tmp2.put(equations.get(i).get(0),1.0/values[i]);
            map.put(equations.get(i).get(0),tmp1);
            map.put(equations.get(i).get(1),tmp2);
            set.add(equations.get(i).get(0));
            set.add(equations.get(i).get(1));
        }
        System.out.println(map);
        double[] ans = new double[queries.size()];
        Arrays.fill(ans,-1);
        for(int i=0;i<ans.length;i++){
            HashSet<String> curSet = new HashSet<>();
            String str1 = queries.get(i).get(0);
            String str2 = queries.get(i).get(1);
            if(!(set.contains(str1)&&set.contains(str2))) continue;
            else if(str1.equals(str2)){
                ans[i] = 1;
                continue;
            }
            String cur = str1;
            Stack<String> StringStack = new Stack<>();
            Stack<Double> DoubleStack = new Stack<>();
            StringStack.push(cur);
            double curDouble = 1;
            DoubleStack.push(curDouble);
            while(!StringStack.isEmpty()){
                cur = StringStack.pop();
                curDouble = DoubleStack.pop();
                curSet.add(cur);
                if(map.containsKey(cur)){
                    HashMap<String,Double> tmp = map.get(cur);
                    if(tmp.containsKey(str2)) {
                        ans[i] = curDouble * tmp.get(str2);
                        break;
                    }
                    for(String next:tmp.keySet()){
                        if(map.containsKey(next)&&!curSet.contains(next)) {
                            StringStack.push(next);
                            DoubleStack.push(curDouble*tmp.get(next));
                        }
                    }
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}
