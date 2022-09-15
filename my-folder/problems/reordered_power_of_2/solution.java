class Solution {
    public boolean reorderedPowerOf2(int n) {
        
        Map<Integer, List<String>> powMap = new HashMap();
        for(int i=0; i<31; i++) {
            String temp = String.valueOf((int)Math.pow(2, i));
            if(powMap.containsKey(temp.length())) {
               powMap.get(temp.length()).add(temp); 
            } else {
                List<String> list = new ArrayList();
                list.add(temp);
                powMap.put(temp.length(), list);
            }
        }
        
        
        String s = Integer.toString(n);
        List<String> powList = powMap.get(s.length());
        for(String strPow : powList) {
            s = Integer.toString(n);
            for(int i=0; i<strPow.length(); i++) {
                char c = strPow.charAt(i);
                int index = s.indexOf(c, i);
                if(index > -1 && i != s.length()-1) {
                    s = swap(s, i, index);
                } else if(index > -1 && i == s.length()-1) {
                    return true;
                } else {
                    break;
                }
            }
        }
        
        return false;
        
    }
                   
    public static String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.copyValueOf(ch);
    }
}