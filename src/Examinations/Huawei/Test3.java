package Examinations.Huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String root = input.nextLine();
        String child = input.nextLine();
        String newRoot = input.nextLine();
        root = root.substring(1, root.length() - 1);
        String[] k1 = root.split(",");
        int[] nodes1 = new int[k1.length];
        for (int i = 0; i < k1.length; i++) {
            nodes1[i] = Integer.valueOf(k1[i]);
        }
        newRoot = newRoot.substring(1, newRoot.length() - 1);
        String[] k2 = newRoot.split(",");
        int[] nodes2 = new int[k2.length];
        for (int i = 0; i < k2.length; i++) {
            nodes2[i] = Integer.valueOf(k2[i]);
        }
        child = child.substring(1);
        String[] k3 = child.split("/");
        int index = 0;
        int layers = 1;
        for (int i = 1; i < k3.length; i++) {
            int next = Integer.valueOf(k3[i]);
            layers++;
            if (nodes1[index * 2 + 1] == next) {
                index = index * 2 + 1;
            } else {
                index = index * 2 + 2;
            }
        }
        layers += (int) (Math.log(k2.length) / Math.log(2) + 1);
        int[] res = new int[(int) Math.max(nodes1.length, Math.pow(2, layers - 1) - 1)];
        for (int i = 0; i < nodes1.length; i++) {
            res[i] = nodes1[i];
        }
        func(res, nodes1, nodes2, index, 0);
        System.out.print("[" + res[0]);
        for (int i = 1; i < res.length; i++) if (res[i] != 0) System.out.print("," + res[i]);
        System.out.println("]");

    }

    public static void func(int[] res, int[] nodes1, int[] nodes2, int index1, int index2) {
        if (index1 >= res.length || index2 >= nodes2.length) return;
        if (nodes2[index2] == 0) res[index1] = nodes1[index1];
        else res[index1] = nodes2[index2];
        func(res, nodes1, nodes2, index1 * 2 + 1, index2 * 2 + 1);
        func(res, nodes1, nodes2, index1 * 2 + 2, index2 * 2 + 2);
    }
}

/*
[1,1,2,0,0,4,5]
/1/2
[5,3,0]
 */