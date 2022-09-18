package Examinations.Meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        long res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long cur = 0;
            int left = 0;
            int right = nums.length - 1;
            int index = i;
            for (int j = nums[i]; j < nums[i] + nums.length; j++) {
                if (j == nums[index]) {
                    index++;
                } else if (j > nums[index]) {
                    if (left < i) {
                        cur += j - nums[left++];
                    } else {
                        cur += nums[right--] - j;
                    }
                }
            }
            res = Math.min(res, cur);
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Arrays.sort(nums);
        long res = Integer.MAX_VALUE;
        for (int i = nums[0]; i < nums[nums.length - 1] - n; i++) {
            int max = i + n - 1;
            long cur = 0;
            int left = 0;
            int index = 0;
            while (index < nums.length && nums[index] < i) index++;
            int right = nums.length - 1;
            for (int j = i; j <= max; j++) {
                if (nums[index] == j) {
                    index++;
                } else {
                    if (nums[left] < i) {
                        cur += j - nums[left++];
                    } else {
                        cur += nums[right--] - j;
                    }
                }
                if (nums[index] >= i && nums[index] <= max) {
                    index++;
                } else {
                    if (left < index) {
                        cur += j - nums[left++];
                    } else {
                        cur += nums[right--] - j;
                    }
                }
            }
            res = Math.min(res, cur);
        }
        System.out.println(res);
    }
}
