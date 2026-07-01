class Solution {

    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = nums[0];

        for (int n : nums) {
            high = Math.max(high, n);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (sumby(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    int sumby(int[] nums, int div) {

        int s = 0;

        for (int x : nums) {
            s += Math.ceil((double) x / div);
        }

        return s;
    }
}