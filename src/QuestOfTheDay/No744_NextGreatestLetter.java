package QuestOfTheDay;

public class No744_NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) return letters[0];
        for (int i = letters.length - 2; i >= 0; i--) {
            if (letters[i] <= target) return letters[i + 1];
        }
        return letters[0];
    }
}
