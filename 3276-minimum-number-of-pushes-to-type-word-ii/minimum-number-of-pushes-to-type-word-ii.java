class Solution {
    public int minimumPushes(String word) {
        int[] freq=new int[26];
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int ans = 0;
        int rank = 0;

        // Traverse from highest frequency to lowest
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0)
                break;
            int pushes = (rank / 8) + 1;
            ans += freq[i] * pushes;
            rank++;
        }
        return ans;
    }
}