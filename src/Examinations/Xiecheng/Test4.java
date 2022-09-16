package Examinations.Xiecheng;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long mod = (long) (10E9 + 7);
        int n = input.nextInt();
        long res = 0;
        long sum2 = 20;
        long sum3 = 4 * n + 1 % mod;
        sum3 *= n - 2;
        sum3 %= mod;
        sum3 *= 6;
        sum3 %= mod;
        long sum4 = n - 2;
        sum4 *= n - 2;
        sum4 %= mod;
        long tmp = n * n % mod;
        tmp += 4 * n % mod;
        tmp %= mod;
        tmp -= 3;
        sum4 *= tmp;
        sum4 %= mod;
        sum4 *= 2;
        sum4 %= mod;
        res = sum2 + sum3;
        res %= mod;
        res += sum4;
        res %= mod;
        System.out.println(res);
    }
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        long mod = (long) (10E9 + 7);
        int n = input.nextInt();
        BigInteger res = BigInteger.valueOf(20);
        long sum3 = 4 * n + 1 % mod;
        sum3 *= n - 2;
        sum3 %= mod;
        sum3 *= 6;
        sum3 %= mod;
        BigInteger sum4 = BigInteger.valueOf(n - 2);
        sum4 = sum4.multiply(sum4);
        sum4 = sum4.divideAndRemainder(BigInteger.valueOf(mod))[1];
        BigInteger tmp = BigInteger.valueOf(n * n % mod);
        tmp = tmp.add(BigInteger.valueOf(4 * n % mod));
        tmp = tmp.divideAndRemainder(BigInteger.valueOf(mod))[1];
        tmp = tmp.add(BigInteger.valueOf(-3));
        sum4 = sum4.multiply(tmp);
        sum4 = sum4.divideAndRemainder(BigInteger.valueOf(mod))[1];
        sum4 = sum4.multiply(BigInteger.valueOf(2));
        sum4 = sum4.divideAndRemainder(BigInteger.valueOf(mod))[1];
        res = res.add(BigInteger.valueOf(sum3));
        res = res.divideAndRemainder(BigInteger.valueOf(mod))[1];
        res = res.divideAndRemainder(BigInteger.valueOf(mod))[1];
        res = res.add(sum4);
        res = res.divideAndRemainder(BigInteger.valueOf(mod))[1];
        System.out.println(res.longValue());
    }
    public static void main2(String[] args) {
        Scanner input = new Scanner(System.in);
        long mod = (long) (10E9 + 7);
        int n = input.nextInt();
        BigInteger res = BigInteger.valueOf(20);
        long sum3 = 4 * n + 1 % mod;
        sum3 *= n - 2;
        sum3 %= mod;
        sum3 *= 6;
        sum3 %= mod;
        BigInteger sum4 = BigInteger.valueOf(n - 2);
        sum4 = sum4.multiply(sum4);
        sum4 = sum4.divideAndRemainder(BigInteger.valueOf(mod))[1];
        BigInteger tmp = BigInteger.valueOf(n * n % mod);
        tmp = tmp.add(BigInteger.valueOf(4 * n % mod));
        tmp = tmp.divideAndRemainder(BigInteger.valueOf(mod))[1];
        tmp = tmp.add(BigInteger.valueOf(-3));
        sum4 = sum4.multiply(tmp);
        sum4 = sum4.divideAndRemainder(BigInteger.valueOf(mod))[1];
        sum4 = sum4.multiply(BigInteger.valueOf(2));
        sum4 = sum4.divideAndRemainder(BigInteger.valueOf(mod))[1];
        res = res.add(BigInteger.valueOf(sum3));
        res = res.divideAndRemainder(BigInteger.valueOf(mod))[1];
        res = res.divideAndRemainder(BigInteger.valueOf(mod))[1];
        res = res.add(sum4);
        res = res.divideAndRemainder(BigInteger.valueOf(mod))[1];
        System.out.println(res.longValue());
    }
}
