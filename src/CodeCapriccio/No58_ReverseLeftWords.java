package CodeCapriccio;

public class No58_ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
