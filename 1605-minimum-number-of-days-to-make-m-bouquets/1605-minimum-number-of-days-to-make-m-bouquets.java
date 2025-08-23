class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        
        // Edge case: Not enough flowers to make m bouquets
        if ((long) m * k > n) return -1;

        int left = 1;
        int right = (int) 1e9;  // Upper bound for days

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid;  // Try for fewer days
            } else {
                left = mid + 1;  // Need more days
            }
        }

        return left;
    }

    // Helper function to check if we can make m bouquets on a given day
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;  // Count consecutive bloomed flowers
                if (flowers == k) {
                    bouquets++;  // Make a bouquet
                    flowers = 0;  // Reset flower count
                    if (bouquets == m) return true;  // Early exit if enough bouquets
                }
            } else {
                flowers = 0;  // Reset if flowers are not consecutive
            }
        }

        return false;
    }
}
