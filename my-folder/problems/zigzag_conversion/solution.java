class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) {
            return s;
        }
        
        List<StringBuilder> lists = new ArrayList<StringBuilder>();
        for(int i=0; i<numRows; i++) {
            lists.add(new StringBuilder());
        }
        
        boolean ascending = true;
        int row = 0;
        
        for(int i=0; i<s.length(); i++){
            
            lists.get(row).append(s.charAt(i));
            
            if(ascending) {
                row++;
            } else {
                row--;
            }
            
            if(row == 0) {
                ascending = true;
            }
            
            if(row == numRows - 1) {
                ascending = false;
            }
        }
        
        StringBuilder str = new StringBuilder();
        for(int i=0; i<numRows; i++){
            str.append(lists.get(i));
        }
        
        return str.toString();
    }
}