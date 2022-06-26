class Solution {
    
    static Map<String, Integer> values = new HashMap<>();
    static {
        values.put("M", 1000);
        values.put("CM", 900);
        values.put("D", 500);
        values.put("CD", 400);
        values.put("C", 100);
        values.put("XC", 90);
        values.put("L", 50);
        values.put("XL", 40);
        values.put("X", 10);
        values.put("IX", 9);
        values.put("V", 5);
        values.put("IV", 4);
        values.put("I", 1);
    }
    
    public int romanToInt(String s) {
        int index = 0;
        int count = 0;
        while(index<s.length()){
            String curr = s.substring(index, index+1);
            String currNext;
            if(curr.equals("I")) {
                if(index<s.length()-1) {
                    if(s.substring(index+1, index+2).equals("V")) {
                        count+=values.get("IV");
                        index++;
                    } else if(s.substring(index+1, index+2).equals("X")) {
                        count+=values.get("IX");
                        index++;
                    } else {
                        count+=values.get("I");
                    }
                } else {
                    count+=values.get("I");
                }
            } else if(curr.equals("X")) {
                if(index<s.length()-1) {
                    if(s.substring(index+1, index+2).equals("L")) {
                        count+=values.get("XL");
                        index++;
                    } else if(s.substring(index+1, index+2).equals("C")) {
                        count+=values.get("XC");
                        index++;
                    }else {
                        count+=values.get("X");
                    }
                } else {
                    count+=values.get("X");
                }
            } else if(curr.equals("C")){
                if(index<s.length()-1) {
                    if(s.substring(index+1, index+2).equals("D")) {
                        count+=values.get("CD");
                        index++;
                    } else if(s.substring(index+1, index+2).equals("M")) {
                        count+=values.get("CM");
                        index++;
                    } else {
                        count+=values.get("C");
                    }
                } else {
                    count+=values.get("C");
                }
            } else {
                count+=values.get(curr);
            }
            index++;
        }
        return count;
    }
}