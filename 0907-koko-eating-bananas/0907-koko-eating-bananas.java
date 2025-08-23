class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile); // maximum pile
        }

        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEat(piles, h, mid)) {
                ans = mid;       // possible answer
                right = mid - 1; // try smaller speed
            } else {
                left = mid + 1;  // need bigger speed
            }
        }
        return ans;
    }

    // Check if Koko can finish in h hours with speed k
    private boolean canEat(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;  // ceil(pile/k)
            if (hours > h) return false; // no need to continue
        }
        return hours <= h;
    }
}
