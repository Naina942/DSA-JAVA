import java.util.*;
class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        // Find maximum value in nums
        int mx = Arrays.stream(nums).max().getAsInt();

        // Frequency array
        int[] cnt = new int[mx + 1];

        // cntG[i] = number of pairs whose GCD is exactly i
        long[] cntG = new long[mx + 1];

        // Count frequency of each number
        for (int x : nums) {
            cnt[x]++;
        }

        // Calculate number of pairs having GCD = i
        for (int i = mx; i > 0; --i) {

            int v = 0;

            // Count numbers divisible by i
            for (int j = i; j <= mx; j += i) {
                v += cnt[j];

                // Remove pairs already counted for multiples of i
                cntG[i] -= cntG[j];
            }

            // Total pairs formed by v numbers
            cntG[i] += 1L * v * (v - 1) / 2;
        }

        // Prefix sum
        // cntG[i] = number of pairs with GCD <= i
        for (int i = 2; i <= mx; ++i) {
            cntG[i] += cntG[i - 1];
        }

        int m = queries.length;
        int[] ans = new int[m];

        // Answer each query using binary search
        for (int i = 0; i < m; ++i) {
            ans[i] = search(cntG, queries[i]);
        }

        return ans;
    }

    // Find first index where cntG[index] > x
    private int search(long[] nums, long x) {

        int l = 0;
        int r = nums.length;

        while (l < r) {

            int mid = (l + r) >> 1;

            if (nums[mid] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}