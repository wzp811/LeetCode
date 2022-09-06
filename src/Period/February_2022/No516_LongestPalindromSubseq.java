package Period.February_2022;

public class No516_LongestPalindromSubseq {
    public int longestPalindromSubseq(String s){
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i=1;i<=s.length();i++) dp[i][i] = 1;
        for(int i=s.length();i>=1;i--){
            for(int j=i+1;j<=s.length();j++){
//                dp[i][j] = s.charAt(i-1)==s.charAt(j-1)?(j==i+1?2:dp[i+1][j-1]+2):dp[i][j-1];
                dp[i][j] = s.charAt(i-1)==s.charAt(j-1)?(j==i+1?2:dp[i+1][j-1]+2):Math.max(Math.max(dp[i+1][j-1],dp[i][j-1]),dp[i+1][j]);
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        No516_LongestPalindromSubseq obj = new No516_LongestPalindromSubseq();
        System.out.println(obj.longestPalindromSubseq("bbbab"));
        System.out.println(obj.longestPalindromSubseq("cbbd"));
        System.out.println(obj.longestPalindromSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"));
    }
}
