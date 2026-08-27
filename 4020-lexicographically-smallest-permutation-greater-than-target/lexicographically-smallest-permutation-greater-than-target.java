class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            int x = target.charAt(i) - 'a';
            if (freq[x] > 0) {
                freq[x]--;
                ans.append(target.charAt(i));
            } 
            else {
                int greater = -1;
                for (int j = x + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        greater = j;
                        break;
                    }
                }
                if (greater != -1) {
                    ans.append((char) ('a' + greater));
                    freq[greater]--;
                    for (int j = 0; j < 26; j++) {
                        while (freq[j] > 0) {
                            ans.append((char) ('a' + j));
                            freq[j]--;
                        }
                    }
                    return ans.toString();
                }
                break;
            }
        }
        for (int i = ans.length() - 1; i >= 0; i--) {
            int x = ans.charAt(i) - 'a';
            freq[x]++;
            for (int j = x + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    StringBuilder result = new StringBuilder();
                    result.append(ans.substring(0, i));
                    result.append((char) ('a' + j));
                    freq[j]--;
                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            result.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }
                    return result.toString();
                }
            }
        }
        return "";
    }
}