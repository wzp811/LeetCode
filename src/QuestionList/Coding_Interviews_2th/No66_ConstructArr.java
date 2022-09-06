package QuestionList.Coding_Interviews_2th;

public class No66_ConstructArr {
    public int[] constructArr(int[] a){
        int[] ans = new int[a.length];
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = 1;
        right[a.length-1] = 1;
        for(int i=1;i<a.length;i++){
            left[i] = a[i-1]*left[i-1];
            right[a.length-1-i] = a[a.length-i]*right[a.length-i];
        }
        for(int i=0;i<a.length;i++){
            ans[i] = left[i]*right[i];
        }
        return ans;
    }
}
