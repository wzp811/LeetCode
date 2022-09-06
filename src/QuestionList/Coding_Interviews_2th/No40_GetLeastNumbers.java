package QuestionList.Coding_Interviews_2th;

public class No40_GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr,int k){
        int[] ans = new int[k];
        for(int i=0;i<arr.length;i++) heapInsert(arr,i);
        for(int i=0;i<k;i++){
            ans[i] = arr[0];
            swap(arr,0,arr.length-1-i);
            heapify(arr,0,arr.length-i-2);
        }
        return ans;
    }
    public void heapify(int[]arr,int index,int size){
        int left = index*2+1;
        while(left<=size){
            int maxIndex = left+1<size&&arr[left]<arr[left+1]?left:left+1;
            if(arr[index]>arr[maxIndex]){
                swap(arr,index,maxIndex);
                index = maxIndex;
                left = index*2+1;
            }else{
                return;
            }
        }
    }
    public void heapInsert(int[]arr,int index){
        while(index>=0&&arr[(index-1)/2]>arr[index]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    public void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
