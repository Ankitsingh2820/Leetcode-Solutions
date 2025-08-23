class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int maxRow = 0;

            // Find the row with the maximum element in the current column
            for (int i = 0; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            // Check if the maximum element is a peak
            int leftVal = (mid > 0) ? mat[maxRow][mid - 1] : -1;
            int rightVal = (mid < n - 1) ? mat[maxRow][mid + 1] : -1;

            if (mat[maxRow][mid] > leftVal && mat[maxRow][mid] > rightVal) {
                return new int[] { maxRow, mid };
            } else if (leftVal > mat[maxRow][mid]) {
                right = mid - 1; // Move left
            } else {
                left = mid + 1; // Move right
            }
        }
        return new int[] { -1, -1 }; // Should never reach here
    }
}
