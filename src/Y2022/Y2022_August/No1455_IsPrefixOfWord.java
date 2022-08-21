package Y2022.Y2022_August;

public class No1455_IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] k = sentence.split(" ");
        for (int i = 0; i < k.length; i++) {
            if (k[i].indexOf(searchWord) == 0) return i + 1;
        }
        return -1;
    }
}
