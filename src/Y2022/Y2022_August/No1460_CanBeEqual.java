package Y2022.Y2022_August;

import java.util.Arrays;

public class No1460_CanBeEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) return false;
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) if (target[i] != arr[i]) return false;
        return true;
    }
}
