class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = n + 1;
        int[] best = new int[n];
        int left = 0;
        int sum = 0;
        int ans = INF;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                int len = right - left + 1;
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, best[left - 1] + len);
                }
            }
            if (right == 0) {
                best[right] = INF;
            } else {
                best[right] = best[right - 1];
            }

            if (sum == target) {
                int len = right - left + 1;
                best[right] = Math.min(best[right], len);
            }
        }
        return ans == INF ? -1 : ans;
    }
}

