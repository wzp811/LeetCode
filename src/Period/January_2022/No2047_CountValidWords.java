package Period.January_2022;

public class No2047_CountValidWords {
    public int countValidWords(String sentence){
        char[] str = sentence.toCharArray();
        int count = 0;
        boolean hasHypen = false;
        boolean isWords = true;
        int n = str.length;
        for(int i=0;i<n;i++){
            if(str[i]==' '&&i!=0&&str[i-1]!=' '){
                count += isWords?1:0;
                isWords = true;
            }else if(str[i]<='9'&&str[i]>='0'){
                isWords = false;
            }else if(str[i]=='-'){
                if(hasHypen){
                    isWords = false;
                }else if(i-1<0||i+1>=n){
                    isWords = false;
                }else if(!(str[i-1]<='z'&&str[i-1]>='a'&&str[i+1]<='z'&&str[i+1]>='a')){
                    isWords = false;
                }else{
                    hasHypen = true;
                }
            }else if(str[i]=='!'||str[i]=='.'||str[i]==','){
                if(i+1<n&&str[i+1]!=' '){
                    isWords = false;
                }else if(i-1>0&&(str[i-1]>'z'||str[i-1]<'a')){
                    isWords = false;
                }else if(i-1==0){
                    isWords = false;
                }
            }
        }
        count += (str[n-1]!=' '&&isWords)?1:0;
        return count;
    }

    public static void main(String[] args) {
        String str = "aslsdgh  alsdhjg asldgh  sdf     sdg ";
        String[] res = str.split(" ");
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
