class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freq = new HashMap<>();
            for (int j = i; j < n; j++) {
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;
                for (int val : freq.values()) {
                    mini = Math.min(mini, val);
                    maxi = Math.max(maxi, val);
                }
                sum += (maxi - mini);
            }
        }
        return sum;
    }
}