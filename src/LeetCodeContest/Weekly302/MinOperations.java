package LeetCodeContest.Weekly302;

import java.util.PriorityQueue;



public class MinOperations {
    public int minOperations1(int[] nums, int[] numsDivide) {
        int minNums = Integer.MAX_VALUE;
        for (int num : numsDivide) minNums = Math.min(minNums, num);
        for (int i = 2; i < minNums; i++) {
            for (int num : numsDivide) {
                if (num % i != 0) break;
            }
            minNums = i;
        }
        int factor = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == minNums) {
                factor = num;
                break;
            }
            if (num % minNums == 0 && num < factor) {
                boolean flag = true;
                for (int i = 0; i < numsDivide.length; i++) {
                    if (numsDivide[i] % num != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    factor = num;
                }
            }
        }
        if (factor == Integer.MAX_VALUE) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        for (int num : nums) queue.add(num);
        int count = 0;
        while (queue.peek() != factor) {
            queue.poll();
            count++;
        }
        return count;
    }


    public int minOperations(int[] nums, int[] numsDivide) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (num == 1) return 0;
            queue.add(num);
        }
        int maxDivisor = getMaxDivisorAll(numsDivide);
        int cnt = 0;
        while (!queue.isEmpty()) {
            if (maxDivisor % queue.poll() == 0) return cnt;
            cnt++;
        }
        return -1;
    }

    public int getMaxDivisorAll(int[] nums) {
        if (nums.length == 1) return nums[0];
        int divisor = getMaxDivisor(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            divisor = getMaxDivisor(Math.max(divisor, nums[i]), Math.min(divisor, nums[i]));
        }
        return divisor;
    }

    public int getMaxDivisor(int a, int b) {
        while (a % b != 0) {
            int tmp = a % b;
            a = Math.max(tmp, b);
            b = Math.min(tmp, b);
        }
        return b;
    }
}
