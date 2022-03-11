package Hot100;

public class No11_MaxArea {
    public int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right){
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]) left++;
            else right--;
        }
        return max;
    }

    public static void main(String[] args) {
        No11_MaxArea obj = new No11_MaxArea();
//        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int[] height = new int[]{1,1};
        System.out.println(obj.maxArea(height));
    }
}
