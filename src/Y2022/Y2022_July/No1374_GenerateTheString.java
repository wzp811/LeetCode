package Y2022.Y2022_July;

public class No1374_GenerateTheString {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) sb.append("a");
            sb.append("ab");
        } else {
            for (int i = 0; i < n; i++) sb.append("a");
//            for (int i = 0; i < Math.max(n - 2, 0); i++) sb.append("a");
//            sb.append("bc");
        }
        return sb.toString();
    }
}
