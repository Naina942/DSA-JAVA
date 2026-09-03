class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean hasEven = false;
        for (int num : nums1) {
            if (num < minVal) {
                minVal = num;
            }
            if (num % 2 == 0) {
                hasEven = true;
            }
        }
        if (minVal % 2 != 0) {
            return true;
        }
        return !hasOdd(nums1);
    }
    private boolean hasOdd(int[] nums) {
        for (int num : nums) {
            if (num % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}