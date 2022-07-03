class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else if(s.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    s = s.substring(0, i) + s.substring(i+1, s.length());
                    i--;
                } else {
                    stack.pop();
                }
            }
            i++;
        }
        
        for(int j=s.length()-1; j>=0 && stack.size() > 0; j--)
            if(s.charAt(j) == '(') {
                s = s.substring(0, j) + s.substring(j+1, s.length());
                stack.pop();
            }
        
        return s;
    }
    
    
}