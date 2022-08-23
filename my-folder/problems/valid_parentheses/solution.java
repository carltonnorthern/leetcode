class Solution {
    public boolean isValid(String s) {
        if(s.length()==0) {
            return true;
        } else if (s.length()%2==1) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for(int i=0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || map.get(stack.pop())!=s.charAt(i)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
    
}