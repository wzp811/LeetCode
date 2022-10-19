package Y2022.Y2022_October;

import java.util.HashMap;

public class No12_IntToRoman {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        int[] digit = new int[]{1000, 500, 100, 50, 10, 5, 1};
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < digit.length; i++) {
                if (num < digit[i]) continue;
                num -= digit[i];
                res.append(map.get(digit[i]));
            }
        }
        return new String(res);
    }
}
