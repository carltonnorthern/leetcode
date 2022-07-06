class Solution {
    public int fib(int n) {
        if(n==0) {
            return 0;
        }
        
        if(n==1) {
            return 1;
        }
        
        if(n==2) {
            return 1;
        }
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        
        for(int i=3; i<=n; i++){
            n2 = n1;
            n1 = n0;
            n0 = n1 + n2;
        }
        
        return n0;
    }
}