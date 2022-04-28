package QuestOfTheDay;

public class No905_SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        int tail = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[index++] = num;
            } else {
                res[tail--] = num;
            }
        }
        return res;

    }
}
