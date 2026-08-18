import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Store indices of every number
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int ans = -1;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

            int num = entry.getKey();
            List<Integer> positions = entry.getValue();

            // Find how many k-sized subarrays contain this number
            Set<Integer> windows = new HashSet<>();

            for (int pos : positions) {

                int left = Math.max(0, pos - k + 1);
                int right = Math.min(pos, n - k);

                for (int start = left; start <= right; start++) {
                    windows.add(start);
                }
            }

            if (windows.size() == 1) {
                ans = Math.max(ans, num);
            }
        }

        return ans;
    }
}