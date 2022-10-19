package Test;

public class Huawei2 {
    public boolean findInMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int left = 0, right = m - 1;
        int index = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                if (matrix[mid][0] == target) {
                    return true;
                }
                index = mid;
                left = mid + 1;
            }
        }
        if (matrix[index][n - 1] < target) return false;
//        System.out.println(index);
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[index][mid] > target) {
                right = mid - 1;
            } else {
                if (matrix[index][mid] == target) {
                    return true;
                }
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Huawei2 obj = new Huawei2();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(obj.findInMatrix(matrix, 13));
    }
}
