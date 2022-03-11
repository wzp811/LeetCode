package January_2022;

public class No134_CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas,int[] cost){
        int cur = 0;
        int begin = 0;
        int sum = 0;
        for(int i=0;i<gas.length;i++){
            cur += gas[i]-cost[i];
            sum += gas[i]-cost[i];
            if(cur<0){
                cur = 0;
                begin = i+1;
            }
        }
        if(sum<0||begin==gas.length) begin = -1;
        return begin;
    }

    public static void main(String[] args) {
        No134_CanCompleteCircuit obj = new No134_CanCompleteCircuit();
//        int[] gas = new int[]{5,8,2,8};
//        int[] cost = new int[]{6,5,6,6};
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(obj.canCompleteCircuit(gas,cost));
    }
}
