class Solution {
    public int reverse(int x) {
        String xString = String.valueOf(x);
        
        //handle negative case
        boolean negative = false;
        if(xString.charAt(0) == '-') {
            negative = true;
            xString = xString.substring(1);
        }
        
        StringBuilder xStringRev = new StringBuilder();
        if(negative)
            xStringRev.append("-");
        for(int i=xString.length() - 1; i>=0; i--) {
            xStringRev.append(xString.charAt(i));
        }
        
        long value = Long.parseLong(xStringRev.toString());
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) 
            return 0;
        else
            return Integer.parseInt(xStringRev.toString());
            
    }
}