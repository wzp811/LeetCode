package Period.February_2022;

import java.util.Arrays;
import java.util.Stack;

public class No739_DailyTemperatures {
    public int[] dailyTemperatures1(int[] temperatures){
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{temperatures[0],0});
        for(int i=1;i<temperatures.length;i++){
            while(!(stack.isEmpty()||stack.peek()[0]>=temperatures[i])){
                int[] tmp = stack.pop();
                res[tmp[1]] = i-tmp[1];
            }
            stack.push(new int[]{temperatures[i],i});
        }
        while(!stack.isEmpty()){
            res[stack.pop()[1]] = 0;
        }
        return res;
    }
    public int[] dailyTemperatures(int[] temperatures){
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!(stack.isEmpty()||temperatures[stack.peek()]>=temperatures[i])){
                int tmp = stack.pop();
                res[tmp] = i-tmp;
            }
            stack.push(i);
        }
        //下面这个可以不用，因为已经默认0了
        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        No739_DailyTemperatures obj = new No739_DailyTemperatures();
//        int[] temperatures = new int[]{30,40,50,60};
        int[] temperatures = new int[]{30,60,90};
        System.out.println(Arrays.toString(obj.dailyTemperatures(temperatures)));
    }

}
