package January_2022;

public class No376_WiggleMaxLength {
    public int wiggleMaxLength1(int[] nums){
        int len = 1;
        boolean raise = false;
        int pre = nums[0];
        for(int i=1;i<nums.length;i++){
            System.out.println("cur: "+nums[i]+"\tpre: "+pre+"\tlen: "+len);
            if(nums[i]==pre) continue;
            if(len==1){
                raise = nums[i]-nums[i-1]>0?true:false;
                pre = nums[i];
                len++;
            }else{
                if(raise^(nums[i]-pre>0)){
                    pre = nums[i];
                    len++;
                    raise = !raise;
                }
            }
        }
        return len;
    }
    public int wiggleMaxLength(int[] nums){
        if(nums.length==1) return 1;
        int len = 0;
        boolean raise = false;
        len++;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) continue;
            if(len==1){
                raise = nums[i]-nums[i-1]>0?true:false;
                len++;
            }else{
                if(raise^(nums[i]-nums[i-1]>0)){
                    raise = !raise;
                    len++;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        No376_WiggleMaxLength obj = new No376_WiggleMaxLength();
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
//        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
//        int[] nums = new int[]{3,3,3,2,5};
//        int[] nums = new int[]{33,53,12,64,50,41,45,21,97,35,47,92,
//                39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,84,34,64,
//                6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,
//                96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,
//                32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,
//                41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15};
//        System.out.println(nums.length);
        System.out.println(obj.wiggleMaxLength(nums));

    }
}
