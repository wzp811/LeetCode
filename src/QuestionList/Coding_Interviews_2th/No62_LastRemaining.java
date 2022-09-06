package QuestionList.Coding_Interviews_2th;

public class No62_LastRemaining {
    public int lastRemainint(int n,int m){
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = (ans + m) % i;
        }
        return  ans;
    }
}
