class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        for(int i=0; i<strs[0].length(); i++) {
            for(int j=0; j<strs.length; j++) {
                String word = strs[j];
                if(i >= word.length() || word.charAt(i)!=strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        return strs[0];
    }
}