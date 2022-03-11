package January_2022;

import java.util.Arrays;

public class No1996_NumberOfWeakCharacters {
    public int numberOfWeakCharacters(int[][] properties){
        int count = 0;
        int len = properties.length;
        if(len==0) return count;
        Arrays.sort(properties,(a,b)->{
            if(a[0]!=b[0]) return b[0]-a[0];
            return a[1]-b[1];
        });
        int maxDef = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            if(maxDef>properties[i][1]){
                count++;
            }else{
                maxDef = properties[i][1];
            }
        }
        return count;
    }
    public void mergeSort(int [][]arr){
        int len = arr.length;
        if(len<2||arr==null) return;
        int mergeSize = 1;
        while(mergeSize<len){
            int L = 0;
            while(L<len){
                int M = L+mergeSize-1;
                if(M>=len){
                    break;
                }
                int R = Math.min(M+mergeSize,len-1);
                merge(arr,L,M,R);
                L = R+1;
            }
            if(mergeSize>len/2) break;
            mergeSize<<=1;
        }
    }
    public void merge(int[][] arr,int L,int M,int R){
        int[][] help = new int [R-L+1][2];
        int index = 0;
        int p1 = L;
        int p2 = M+1;
        while(p1<=M&&p2<=R){
            if(arr[p1][0]<arr[p2][0]){
                help[index][0] = arr[p1][0];
                help[index][1] = arr[p1][1];
                p1++;
            }else if(arr[p1][0]==arr[p2][0]){
                help[index][0] = arr[p1][0];
                help[index][1] = arr[p1][1]<arr[p2][1]?arr[p1++][1]:arr[p2++][1];
            }else{
                help[index][0] = arr[p2][0];
                help[index][1] = arr[p2][1];
                p2++;
            }
            index++;
        }
        while(p1<=M){
            help[index][0] = arr[p1][0];
            help[index++][1] = arr[p1++][1];
        }
        while(p2<=R){
            help[index][0] = arr[p2][0];
            help[index++][1] = arr[p2++][1];
        }
        for(int i=0;i<help.length;i++){
            arr[L+i] = help[i];
        }
    }

    public static void main(String[] args) {
        No1996_NumberOfWeakCharacters obj = new No1996_NumberOfWeakCharacters();
        int[][] arr = new int[][]{{5, 7}, {8, 9}, {4, 1}, {2, 6}};
        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
}
