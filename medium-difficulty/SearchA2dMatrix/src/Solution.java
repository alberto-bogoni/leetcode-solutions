public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int columns = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][columns-1] && search(matrix[i], 0, columns-1, target)) {
                return true;
            }
        }

        return false;
    }

    public boolean search(int[] nums, int start, int end, int target) {
        if (start > end) return false;

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] > target) {
            return search(nums, start, mid - 1, target);
        } else {
            return search(nums, mid + 1, end, target);
        }
    }

    public boolean searchMatrixSecond(int[][] matrix, int target) {
        int columns = matrix[0].length;
        int row = searchRowSecond(matrix, 0, matrix.length-1,target);

        return search(matrix[row], 0, matrix[0].length-1,target);
    }

    public int searchRowSecond(int[][] matrix, int start, int end, int target) {
        if (start >= end) return start;

        int mid = start + (end - start) / 2;
        if (matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length-1]) {
            return mid;
        } else if (matrix[mid][0] > target) {
            return searchRowSecond(matrix, start, mid - 1, target);
        } else {
            return searchRowSecond(matrix, mid + 1, end, target);
        }
    }
}