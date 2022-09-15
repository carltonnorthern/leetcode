class Solution {
    enum State {
        STATE1,
        STATE2,
        STATE3,
        STATE4;
    }
    
    
    public int myAtoi(String s) {
        State state = State.STATE1;
        boolean positive = true;
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            if(state == State.STATE1) {
                if(s.charAt(i) == ' ') {
                    
                } else if(s.charAt(i) == '-') {
                    positive = false;
                    state = State.STATE3;
                } else if(s.charAt(i) == '+') {
                    positive = true;
                    state = State.STATE3;
                } else if(Character.isDigit(s.charAt(i))) {
                    return processDigits(i, s, positive);
                } else {
                    return result;
                }
            } else if (state == State.STATE3) {
                if(Character.isDigit(s.charAt(i))) {
                    return processDigits(i, s, positive);
                } else {
                    return result;
                }
            }
        }
        return result;
    }
                          
    public int processDigits(int i, String s, boolean positive) {
        int result = 0;
        StringBuilder pars = new StringBuilder();
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                pars.append(s.charAt(i));
            } else {
                return convert(pars, positive);
            }
            i++;
        }
        
        return convert(pars, positive);         
    }
    
    public int convert(StringBuilder s, boolean positive) {
        long result = 0;
        for(int i=0; i<s.length(); i++) {
            int place = s.length() - i - 1;
            result += Character.getNumericValue(s.charAt(i)) * Math.pow(10, place);
        }
        
        if(!positive) {
            result = result * -1;
        }
        
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) result;
    }
}