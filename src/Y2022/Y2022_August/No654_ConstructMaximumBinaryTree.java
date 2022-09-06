package Y2022.Y2022_August;

import QuestionList.Coding_Interviews.TreeNode;

public class No654_ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return func(nums, 0, nums.length - 1);
    }

    public TreeNode func(int[] nums, int left, int right) {
        if (left > right) return null;
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        TreeNode cur = new TreeNode(nums[maxIndex]);
        cur.left = func(nums, left, maxIndex - 1);
        cur.right = func(nums, maxIndex + 1, right);
        return cur;
    }
}
