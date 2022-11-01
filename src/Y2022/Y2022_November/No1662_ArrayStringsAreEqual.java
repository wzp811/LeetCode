package Y2022.Y2022_November;

public class No1662_ArrayStringsAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int leftCnt = 0, leftIndex = 0;
        int rightCnt = 0, rightIndex = 0;
        while (leftCnt < word1.length && rightCnt < word2.length) {
            if (word1[leftCnt].charAt(leftIndex++) != word2[rightCnt].charAt(rightIndex++)) return false;
            if (leftIndex == word1[leftCnt].length()) {
                leftIndex = 0;
                leftCnt++;
            }
            if (rightIndex == word2[rightCnt].length()) {
                rightIndex = 0;
                rightCnt++;
            }
        }
        return leftCnt == word1.length && rightCnt == word2.length;
    }
}
