package Test;

public class T {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.print(getItem(i));
        }
    }
    public static String getItem(int i) {
        StringBuilder res = new StringBuilder();
        if (!(i % 3 == 0 || i % 5 == 0)) {
            res.append(String.valueOf(i));
        }
        if (i % 3 == 0) {
            res.append("Fizz");
        }
        if (i % 5 == 0) {
            res.append("Buzz");
        }
        res.append(" ");
        return new String(res);
    }
}
