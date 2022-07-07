class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int s1Idx = 0;
        int s2Idx = 0;
        int s3Idx = 0;
        int[][] memo = new int[s1.length()+1][s2.length()+1];
        
        return recurse(memo, s1, s2, s3, s1Idx, s2Idx);
    }
    
    private boolean recurse(int[][] memo, String s1, String s2, String s3, int s1Idx, int s2Idx){
        int s3Idx = s1Idx + s2Idx;
        if (s1Idx == s1.length()) {
            return s2.substring(s2Idx).equals(s3.substring(s3Idx));
        }
        if (s2Idx == s2.length()) {
            return s1.substring(s1Idx).equals(s3.substring(s3Idx));
        }
        
        if(s1Idx > s1.length() || s2Idx > s2.length() || s3Idx > s3.length()) {
            memo[s1Idx][s2Idx] = -1;
            return false;
        }
        
        if(memo[s1Idx][s2Idx]!=0) {
            if(memo[s1Idx][s2Idx]==1) {
                return true;
            } else if(memo[s1Idx][s2Idx]==-1) {
                return false;
            }
        }
        
        if(s1Idx < s1.length() && s3Idx < s3.length() && s1.charAt(s1Idx) == s3.charAt(s3Idx)) {
            if(recurse(memo, s1, s2, s3, s1Idx+1, s2Idx)) {
                memo[s1Idx+1][s2Idx] = 1;
                return true;
            } else {
                memo[s1Idx+1][s2Idx] = -1;
            }
        }
        
        if(s2Idx < s2.length() && s3Idx < s3.length() && s2.charAt(s2Idx) == s3.charAt(s3Idx)) {
            if(recurse(memo, s1, s2, s3, s1Idx, s2Idx+1)){
                memo[s1Idx][s2Idx+1] = 1;
                return true;
            } else {
                memo[s1Idx][s2Idx+1] = -1;
            }
        }
        
        return false;
    }
}