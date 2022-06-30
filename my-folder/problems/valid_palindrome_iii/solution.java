class Solution {
    int memo[][];
    public boolean isValidPalindrome(String s, int k) {
    memo = new int[s.length()][s.length()];

        int min = s.length();
        memo[0][0] = 0;

        for(int j=1; j<s.length(); j++) {
            for(int i=j-1; i>=0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    memo[i][j] = memo[i+1][j - 1];
                } else {
                    memo[i][j] = 1 + Math.min(memo[i+1][j], memo[i][j-1]);
                }
            }
        }
        
        return memo[0][s.length()-1] <= k;
    }
}