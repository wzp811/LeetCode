package Y2022.Y2022_August;

public class No1450_BusyStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) res++;
        }
        return res;
    }
}
