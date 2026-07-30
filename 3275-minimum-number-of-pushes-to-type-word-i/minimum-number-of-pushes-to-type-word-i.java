class Solution {
    public int minimumPushes(String word) {
        int p=0;
        for(int i=0;i<word.length();i++){
            p+=(i/8)+1;
        }
        return p;
    }
}