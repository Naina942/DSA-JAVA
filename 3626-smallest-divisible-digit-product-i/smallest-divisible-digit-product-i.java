class Solution {
    public int smallestNumber(int n, int te) {
        while(true){ 
        int p=1;
        int t=n;
        while(t>0){
            p*=t%10;
            t/=10;
        }
        if(p%te==0)
            return n;
            n++;
        }
    }
}