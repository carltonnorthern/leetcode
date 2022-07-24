class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int count = 0;
        int maxCount = 0;
        int left = 0;
        for(int i=0; i<s.length(); i++) {
            if(set.add(s.charAt(i))) {
                count++;
            } else {
                while(s.charAt(left) != s.charAt(i)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
                count = set.size();
            }
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
               
               
}