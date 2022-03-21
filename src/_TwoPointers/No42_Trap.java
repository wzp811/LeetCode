package _TwoPointers;

public class No42_Trap {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (height[left] <= height[right]) {
                ans += rightMax - height[right--];
            } else {
                ans += leftMax - height[left++];
            }
        }
        return ans;
    }
}
