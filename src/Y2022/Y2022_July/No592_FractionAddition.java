package Y2022.Y2022_July;

public class No592_FractionAddition {
    public String fractionAddition(String expression) {
        int[] ups = new int[10];
        int[] downs = new int[10];
        int cnt = -1;
        int cur = 0;
        int flag = 1;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                if (cur != 0) downs[cnt] = cur;
                cnt++;
                flag = expression.charAt(i) == '-' ? -1 : 1;
                cur = 0;
            } else if (i == 0) {
                cnt++;
                cur = expression.charAt(i) - '0';
            } else if (expression.charAt(i) == '/') {
                ups[cnt] = cur * flag;
                cur = 0;
            } else {
                cur *= 10;
                cur += expression.charAt(i) - '0';
            }
        }
        downs[cnt] = cur;
        int product = 1;
        for (int i = 0; i <= cnt; i++) product *= downs[i];
        int sum = 0;
        for (int i = 0; i <= cnt; i++) {
            ups[i] *= (product / downs[i]);
            sum += ups[i];
        }
        if (sum == 0) return "0/1";
        flag = (sum >= 0) ? 1 : -1;
        sum = (sum >= 0) ? sum : -sum;
        int a = Math.max(sum, product);
        int b = Math.min(sum, product);
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return new StringBuffer(flag == 1 ? "" : "-")
                .append(String.valueOf(sum / a))
                .append("/")
                .append(String.valueOf(product / a))
                .toString();
    }
}
