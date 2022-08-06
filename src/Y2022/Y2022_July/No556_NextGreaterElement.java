package Y2022.Y2022_July;

import java.util.ArrayList;
import java.util.List;

public class No556_NextGreaterElement {
    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) nums[i] = list.get(nums.length - 1 - i);
        int index = nums.length - 1;
        while (nums[index - 1] > nums[index]) {
            index--;
            if (index < 1) return -1;
        }
        index--;
        int rindex = nums.length - 1;
        while (nums[rindex] <= nums[index]) rindex--;
        swap(nums, index, rindex);
        index++;
        rindex = nums.length - 1;
        for (; index < rindex; index++, rindex--) {
            swap(nums, index, rindex);
        }
        long res = 0;
        for (int num : nums) {
            res *= 10;
            res += num;
        }
        return res <= Integer.MAX_VALUE ? (int)res : -1;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
