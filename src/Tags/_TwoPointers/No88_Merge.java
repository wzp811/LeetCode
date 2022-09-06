package Tags._TwoPointers;

public class No88_Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1, j = n - 1;
        int loc = nums1.length - 1;
        for (; loc >= 0; loc--) {
            if (i == -1) nums1[loc] = nums2[j--];
            else if (j == -1) nums1[loc] = nums1[i--];
            else if (nums1[i] > nums2[j]) nums1[loc] = nums1[i--];
            else if (nums1[i] <= nums2[j]) nums1[loc] = nums2[j--];
        }
    }
}
