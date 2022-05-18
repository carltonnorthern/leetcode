class Solution {
    public boolean backspaceCompare(String s, String t) {

        s = removeBackspaces(s);
        t = removeBackspaces(t);

        if(s.length() != t.length()){
            return false;
        } else {
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)!=t.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }

    private static String removeBackspaces(String s) {
        int i=0;
        while(i<s.length()) {
            if(i==0 && s.charAt(i)=='#') {
                s = s.substring(1);
                i--;
            } else if(s.charAt(i)=='#'){
                s = s.substring(0, i-1) + "" + s.substring(i + 1);
                i=i-2;
            }
            i++;
        }
        return s;
    }
}