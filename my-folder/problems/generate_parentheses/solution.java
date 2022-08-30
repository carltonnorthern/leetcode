class Solution {
    List<String> result;
    int length;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList();
        length = 2 * n;
        backtrack("(", 0, 1);
        return result;
    }
    
    public boolean backtrack(String s, int pos, int balance) {
        if(balance > length - pos || balance < 0 || s.length() > length) {
            return false;
        }
        
        if(s.length() == length && balance == 0) {
            result.add(s);
            return true;
        }
        
        backtrack(s + "(", pos + 1, balance + 1);
        backtrack(s + ")", pos + 1, balance - 1);
        
        return true;
        
    }
}