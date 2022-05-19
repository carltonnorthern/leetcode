class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> usedCharacters = new HashSet<Character>();
        String longestSubstring = "";
        int pl = 0;
        int pr = 0;
        while(pr < s.length()){

            if(usedCharacters.add(s.charAt(pr))) {
                if(longestSubstring.length()<s.substring(pl, pr+1).length()){
                    longestSubstring = s.substring(pl, pr+1);
                }
                pr++;
            } else {
                for(int i=pl; i<pr; i++) {
                    if(s.charAt(i)==s.charAt(pr)) {
                        pl = i+1;
                        break;
                    }
                }
                usedCharacters.clear();
                for(int i=pl; i<pr; i++){
                    usedCharacters.add(s.charAt(i));
                }
            }
        }
        return longestSubstring.length();
    }
}