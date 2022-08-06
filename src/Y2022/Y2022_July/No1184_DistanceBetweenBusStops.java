package Y2022.Y2022_July;

public class No1184_DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        int tmp = 0;
        int min = Math.min(start, destination);
        int max = Math.max(start, destination);
        for (int i = 0; i < distance.length; i++) {
            if (i >= min && i < max) tmp += distance[i];
            sum += distance[i];
        }
        return Math.min(tmp, sum - tmp);
    }
}
