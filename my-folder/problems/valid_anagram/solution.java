class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            Character cS = s.charAt(i);
            Character cT = t.charAt(i);
            if(mapS.containsKey(cS)) {
                mapS.put(cS, mapS.get(cS)+1);
            } else {
                mapS.put(cS, 1);
            }
            
            if(mapT.containsKey(cT)) {
                mapT.put(cT, mapT.get(cT)+1);
            } else {
                mapT.put(cT, 1);
            }
        }
        
        if(mapS.keySet().size() != mapT.keySet().size()) {
            return false;
        }
        
        for(Character c : mapS.keySet()) {
            int sInt = mapS.get(c);
            int tInt = mapT.getOrDefault(c, 0);
            if(sInt != tInt) {
                return false;
            }
        }
        
        
        
        return true;
    }
}