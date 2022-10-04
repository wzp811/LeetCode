package Y2022.Y2022_September;

public class No1694_ReformatNumber {

    public String reformatNumber(String number) {
        int cnt = 0;
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) cnt++;
        }
        StringBuilder res = new StringBuilder();
        int cur = 0;
        boolean restFour = cnt == 4;
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) continue;
            res.append(number.charAt(i));
            cur++;
            cnt--;
            if (cur == 3 && cnt != 0) {
                res.append("-");
                cur = 0;
                if (cnt == 4) restFour = true;
            } else if (restFour && cur == 2 && cnt != 0) {
                res.append("-");
                cur = 0;
                restFour = false;
            }
        }
        return new String(res);
    }
}
