package QuestionList.QuestOfTheDay;

public class NumArray {
    int[] nums;
    int size;
    int[] sum;

    public NumArray(int[] nums) {
        this.nums = nums;
        size = (int) Math.sqrt(nums.length);
        this.sum = new int[(nums.length + size - 1) / size];
        for (int i = 0; i < nums.length; i++) {
            sum[i / size] += nums[i];
        }
    }

    public void update(int index, int val) {
        sum[index / size] += val - nums[index];
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int block1 = left / size, block2 = right / size;
        int at1 = left % size, at2 = right % size;
        int res = 0;
        if (block1 == block2) {
            for (int i = left; i <= right; i++) res += nums[i];
            return res;
        }
        for (int i = at1; i < size; i++) res += nums[block1 * size + i];
        for (int i = 0; i <= at2; i++) res += nums[block2 * size + i];
        for (int i = block1 + 1; i < block2; i++) res += sum[i];
        return res;
    }
}
