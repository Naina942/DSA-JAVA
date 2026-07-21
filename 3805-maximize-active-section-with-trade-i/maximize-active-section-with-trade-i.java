class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        int prevZero = -1;
        int best = 0;

        int i = 0;
        while (i < s.length()) {
            int j = i;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (s.charAt(i) == '1') {
                ones += len;
            } else {
                if (prevZero != -1) {
                    best = Math.max(best, prevZero + len);
                }
                prevZero = len;
            }

            i = j;
        }

        return ones + best;
    }
}