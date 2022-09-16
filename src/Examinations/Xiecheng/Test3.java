package Examinations.Xiecheng;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = input.nextInt();
            }
            input.nextLine();
            String colors = input.nextLine();
            int Rmax = 0, Rmin = Integer.MAX_VALUE;
            int Bmax = 0, Bmin = Integer.MAX_VALUE;
            for (int i = 0; i < colors.length(); i++) {
                if (colors.charAt(i) == 'R') {
                    Rmax = Math.max(Rmax, nums[i]);
                    Rmin = Math.min(Rmin, nums[i]);
                } else {
                    Bmax = Math.max(Bmax, nums[i]);
                    Bmin = Math.min(Bmin, nums[i]);
                }
            }
            System.out.println(Math.max(Math.max(Rmax - Rmin, Bmax - Bmin), Rmax - Bmin));
//            System.out.println(Math.max(Rmax, Bmax) - Math.min(Bmax, Bmin));
        }
    }
}
