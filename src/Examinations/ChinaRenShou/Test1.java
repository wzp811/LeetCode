package Examinations.ChinaRenShou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] k = s.split(",");
        int[] nums = new int[k.length];
        int[] tmp = new int[k.length];
        for (int i = 0; i < k.length; i++) {
            nums[i] = Integer.parseInt(k[i]);
            tmp[i] = nums[i];
        }
        int[] res = new int[k.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(tmp);
        for (int i = k.length - 1; i >= 0; i--) {
            map.put(tmp[i], i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(nums[i]);
        }
        System.out.print(res[0]);
        for (int i = 1; i < nums.length; i++) {
            System.out.print("," + res[i]);
        }
    }
}
