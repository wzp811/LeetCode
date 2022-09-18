package LeetCodeContest.Biweekly87;

import java.util.Arrays;

public class countDaysTogether {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aam = Integer.valueOf(arriveAlice.substring(0, 2));
        int aad = Integer.valueOf(arriveAlice.substring(2, 4));
        int alm = Integer.valueOf(leaveAlice.substring(0, 2));
        int ald = Integer.valueOf(leaveAlice.substring(2, 4));
        int bam = Integer.valueOf(arriveBob.substring(0, 2));
        int bad = Integer.valueOf(arriveBob.substring(2, 4));
        int blm = Integer.valueOf(leaveBob.substring(0, 2));
        int bld = Integer.valueOf(leaveBob.substring(2, 4));
        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int m1 = 0, d1 = 0;
        int m2 = 0, d2 = 0;
        if (aam == bam) {
            m1 = aam;
            d1 = Math.min(aad, bad);
        } else {
            if (aam < bam) {
                m1 = aam;
                d1 = aad;
            } else {
                m2 = bam;
                d2 = bad;
            }
        }
        if (alm == blm) {
            m2 = alm;
            d2 = Math.max(ald, bld);
        } else {
            if (alm > blm) {
                m2 = alm;
                d2 = ald;
            } else {
                m2 = blm;
                d2 = bld;
            }
        }
        int res = 0;
        for (int i = m1 + 1; i < m2; i++) {
            res += days[i];
        }
        if (m1 == m2) {
            return d2 - d1 + 1;
        }
        res += days[m1] - d1 + 1;
        res += d2;
        return res;
    }
    public int countDaysTogether1(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aam = Integer.valueOf(arriveAlice.substring(0, 2));
        int aad = Integer.valueOf(arriveAlice.substring(3, 5));
        int alm = Integer.valueOf(leaveAlice.substring(0, 2));
        int ald = Integer.valueOf(leaveAlice.substring(3, 5));
        int bam = Integer.valueOf(arriveBob.substring(0, 2));
        int bad = Integer.valueOf(arriveBob.substring(3, 5));
        int blm = Integer.valueOf(leaveBob.substring(0, 2));
        int bld = Integer.valueOf(leaveBob.substring(3, 5));
        System.out.println(aam);
        System.out.println(aad);
        System.out.println(alm);
        System.out.println(ald);
        System.out.println(bam);
        System.out.println(bad);
        System.out.println(blm);
        System.out.println(bld);
        int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] prev = new int[13];
        for (int i = 1; i < 13; i++) {
            prev[i] = prev[i - 1] + days[i];
        }
        System.out.println(Arrays.toString(prev));
        int beginA = prev[aam - 1] + aad;
        int endA = prev[alm - 1] + ald;
        int beginB = prev[bam - 1] + bad;
        int endB = prev[blm - 1] + bld;
        System.out.println(beginA);
        System.out.println(endA);
        System.out.println(beginB);
        System.out.println(endB);
        int begin = Math.max(beginA, beginB);
        int end = Math.min(endA, endB);
        if (begin > end) return 0;
        return end - begin + 1;
    }
}
