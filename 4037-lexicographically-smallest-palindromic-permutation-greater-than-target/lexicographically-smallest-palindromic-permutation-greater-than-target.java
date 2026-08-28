class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        int len = n / 2;
        StringBuilder left = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int t = target.charAt(i) - 'a';

            if (half[t] > 0) {
                left.append((char) ('a' + t));
                half[t]--;
            } else {
                int bigger = -1;

                for (int c = t + 1; c < 26; c++) {
                    if (half[c] > 0) {
                        bigger = c;
                        break;
                    }
                }

                if (bigger != -1) {
                    left.append((char) ('a' + bigger));
                    half[bigger]--;

                    for (int c = 0; c < 26; c++) {
                        while (half[c] > 0) {
                            left.append((char) ('a' + c));
                            half[c]--;
                        }
                    }

                    return makePalindrome(left.toString(), middle, n);
                }

                return backtrack(left, half, target, i, middle, n);
            }
        }

        String candidate = makePalindrome(left.toString(), middle, n);

        if (candidate.compareTo(target) > 0) {
            return candidate;
        }

        return backtrack(left, half, target, len, middle, n);
    }

    private String backtrack(
        StringBuilder left,
        int[] half,
        String target,
        int pos,
        char middle,
        int n
    ) {
        for (int i = pos - 1; i >= 0; i--) {
            int current = left.charAt(i) - 'a';
            half[current]++;

            int targetChar = target.charAt(i) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {
                if (half[c] > 0) {
                    StringBuilder newLeft =
                        new StringBuilder(left.substring(0, i));

                    newLeft.append((char) ('a' + c));
                    half[c]--;

                    for (int x = 0; x < 26; x++) {
                        while (half[x] > 0) {
                            newLeft.append((char) ('a' + x));
                            half[x]--;
                        }
                    }

                    return makePalindrome(
                        newLeft.toString(),
                        middle,
                        n
                    );
                }
            }
        }

        return "";
    }

    private String makePalindrome(String left, char middle, int n) {
        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (n % 2 == 1) {
            ans.append(middle);
        }

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}