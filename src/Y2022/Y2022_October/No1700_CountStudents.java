package Y2022.Y2022_October;

import java.util.ArrayDeque;
import java.util.Deque;

public class No1700_CountStudents {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> studentsDeque = new ArrayDeque<>();
        Deque<Integer> sandwichesDeque = new ArrayDeque<>();
        for (int i = 0; i < students.length; i++) {
            studentsDeque.addLast(students[i]);
        }
        for (int i = 0; i < sandwiches.length; i++) {
            sandwichesDeque.addLast(sandwiches[i]);
        }
        int cnt = 0;
        while (cnt < students.length) {
            if (studentsDeque.peekFirst() != sandwichesDeque.peekFirst()) {
                cnt++;
                studentsDeque.addLast(studentsDeque.pollFirst());
            } else {
                studentsDeque.pollFirst();
                sandwichesDeque.pollFirst();
                cnt = 0;
            }
        }
        return studentsDeque.size();
    }
}
