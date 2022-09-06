package QuestionList.QuestOfTheDay;

public class No824_ToGoatLatin {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != 0) res.append(" ");
            if (words[i].charAt(0) == 'a' || words[i].charAt(0) == 'e' ||
                    words[i].charAt(0) == 'i' || words[i].charAt(0) == 'o' ||
                    words[i].charAt(0) == 'u' || words[i].charAt(0) == 'A' ||
                    words[i].charAt(0) == 'E' || words[i].charAt(0) == 'I' ||
                    words[i].charAt(0) == 'O' || words[i].charAt(0) == 'U') {
                res.append(words[i]);
                res.append("ma");
                for (int j = 0; j <= i; j++) res.append("a");
            } else {
                res.append(words[i].substring(1));
                res.append(words[i].charAt(0));
                res.append("ma");
                for (int j = 0; j <= i; j++) res.append("a");
            }
        }
        return new String(res);
    }
}
