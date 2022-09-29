package Y2022.Y2022_September;

public class No17_19_MissingTwo {
    public int[] missingTwo(int[] nums) {
        int nump1 = -1;
        int nump2 = -1;
        int i = 0;
        int[] res = new int[2];
        int c = 0;
        while (i < nums.length) {
            int tmp = nums[i];
            if (tmp == i + 1 || tmp == -1) {
                i++;
                if (tmp == -1) res[c++] = i;
                continue;
            }
            if (tmp <= nums.length) {
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            } else if (tmp - nums.length == 1) {
                nums[i] = nump1;
                nump1 = tmp;
            } else if (tmp - nums.length == 2) {
                nums[i] = nump2;
                nump2 = tmp;
            }
        }
        if (nump1 == -1) res[c++] = nums.length + 1;
        if (nump2 == -1) res[c++] = nums.length + 2;
        return res;
    }
}
