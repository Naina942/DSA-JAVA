class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int pro=1;
        int temp=n;
        while(temp>0){
           int a=temp%10;
           sum +=a;
           pro*= a;
           temp=temp/10;
        }
        if(n%(sum+pro)==0){
            return true;
        }
        return false;
    }
}