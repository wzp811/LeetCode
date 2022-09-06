package QuestionList.QuestOfTheDay;

public class No2038_WinnerOfGame {

    public boolean winnerOfGame(String colors) {
        int cntA = 0, cntB = 0;
        for(int i=1;i<colors.length()-1;i++){
            if(colors.charAt(i-1)=='A'&&colors.charAt(i)=='A'&&colors.charAt(i+1)=='A'){
                cntA++;
            }else if(colors.charAt(i-1)=='B'&&colors.charAt(i)=='B'&&colors.charAt(i+1)=='B'){
                cntB++;
            }
        }
        return cntA>cntB;
    }

}
