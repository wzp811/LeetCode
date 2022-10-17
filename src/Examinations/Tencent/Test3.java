package Examinations.Tencent;

import javax.sound.midi.Soundbank;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.addLast(input.nextInt());
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0){
                if (queue.peekFirst() < queue.peekLast()) {
                    System.out.print(queue.pollLast());
                } else {
                    System.out.print(queue.pollFirst());
                }
            } else {
                if (queue.peekFirst() > queue.peekLast()) {
                    System.out.print(queue.pollLast());
                } else {
                    System.out.print(queue.pollFirst());
                }
            }
            System.out.print(" ");
        }
    }
}
