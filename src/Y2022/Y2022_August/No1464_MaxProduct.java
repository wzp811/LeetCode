package Y2022.Y2022_August;

public class No1464_MaxProduct {
    public int maxProduct(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            if (a < num) {
                b = a;
                a = num;
            } else if (b < num)
                b = num;
        }
        return (a - 1) * (b - 1);
    }
}
