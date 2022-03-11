package Coding_Interviews_2th;

public class No03_FindRepeatNumber {
    // 从左往右遍历，根据数组的值的范围直到 位置和值是一对多的关系。
    // 那么可以将遍历的每一个数和其值所对应的位置上的数进行交换
    // 如果那个位置上的数和其位置已经相等，说明已经有数去过了，那么这个数就是重复值
    public int findRepeatNumber(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                int tmp = nums[i];
                if(nums[tmp]==tmp) return tmp;
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
                // 位置改变后，换来当前位置的数也要进行一次判断和操作
                i--;
            }
        }
        return -1;
    }
}
