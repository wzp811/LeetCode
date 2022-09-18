package LeetCodeContest.Biweekly87;

import java.util.Arrays;

public class MatchPlayersAndTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int res = 0;
        int index = 0;
        for (int i = 0; i < players.length; i++) {
            while (index < trainers.length && trainers[index] < players[i])
                index++;
            if (index < trainers.length) res++;
            else break;
            index++;
        }
        return res;
    }
}
