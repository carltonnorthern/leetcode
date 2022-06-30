class Solution {
    public boolean validPalindrome(String s) {
        boolean once = false;
        return isValid(s, once);
    }

    private boolean isValid(String s, boolean once) {
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            } else if(!once && isValid(s.substring(left, right), true)){
                return true;
            } else if(!once && isValid(s.substring(left+1, right+1), true)){
                return true;
            } else {
                return false;
            }
        }

        return true;
    }
}