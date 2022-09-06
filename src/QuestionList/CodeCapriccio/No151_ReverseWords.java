package QuestionList.CodeCapriccio;

public class No151_ReverseWords {
    public String reverseWords(String s) {
        String[] k = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k.length; i++) sb.append(k[k.length - 1 - i] + " ");
        return new String(sb).trim();
    }

    public static void main(String[] args) {
        String s = "  1 2   ";
        No151_ReverseWords obj = new No151_ReverseWords();
        obj.reverseWords(s);
    }
}
