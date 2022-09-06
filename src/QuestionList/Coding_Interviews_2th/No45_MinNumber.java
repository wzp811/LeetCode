package QuestionList.Coding_Interviews_2th;

import java.util.Arrays;

public class No45_MinNumber {
    public String minNumber(int[] nums){
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++) strs[i] = String.valueOf(nums[i]);
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));
        /*
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index1 = 0, index2 = 0;
                while((index1<o1.length()||index2<o2.length())&&o1.charAt(index1)==o2.charAt(index2)){
                    index1++;
                    index2++;
                    if(index1==o1.length()) index1 = 0;
                    else if(index2==o2.length()) index2 = 0;
                }
                if(index1==o1.length()&&index2==o2.length()) return 0;
                else if(index1==o1.length()) return o2.charAt(index2)-o1.charAt(0);
                else if(index2==o2.length()) return o1.charAt(index1)-o2.charAt(0);
                else return o2.charAt(index2)-o1.charAt(index1);
            }
        });

         */
        for(int i=0;i<strs.length;i++) ans.append(strs[i]);
        return new String(ans);
    }
}
