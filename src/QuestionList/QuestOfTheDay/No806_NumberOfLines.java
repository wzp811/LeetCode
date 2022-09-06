package QuestionList.QuestOfTheDay;

public class No806_NumberOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 0;
        int width = 0;
        for(int i = 0; i < s.length(); i++) {
            if (width + widths[s.charAt(i) - 'a'] > 100) {
                lines++;
                width = widths[s.charAt(i) - 'a'];
            } else {
                width += widths[s.charAt(i) - 'a'];
            }
        }
        return new int[]{lines, width};
    }
}
