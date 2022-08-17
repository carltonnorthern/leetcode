class WordDistance {

    String[] words;
    Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        words = wordsDict;
        map = new HashMap<String, List<Integer>>();
        
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            if(map.get(word)==null) {
                map.put(word, new ArrayList<Integer>());
            } 
            map.get(word).add(i);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        
        List w1List = map.get(word1);
        List w2List = map.get(word2);
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<w1List.size(); i++) {
            int w1 = (int)w1List.get(i);
            for(int j=0; j<w2List.size(); j++) {
                int w2 = (int)w2List.get(j);
                min = Math.min(min, Math.abs(w1 - w2));
            }
        }
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */