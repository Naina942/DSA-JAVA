class Solution {
    public int reverse(int n) {
        Scanner sc=new Scanner(System.in);
        int a=0;
        while(n!=0){
            int r=n%10;
            if(a>Integer.MAX_VALUE/10||a<Integer.MIN_VALUE/10){
                return 0;
            }
            a=a*10+r;
            n=n/10;
        }
        return a;

    }
}