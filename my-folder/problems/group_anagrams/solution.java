class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap();
        int[] count = new int[26];
        
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            List<Integer> list = IntStream.of(count)    // returns IntStream
                            .boxed()
                            .collect(Collectors.toList());
            
            if(map.containsKey(list)){
                map.get(list).add(s);
            } else {
                List<String> sList = new ArrayList();
                sList.add(s);
                map.put(list, sList);
            }
        }
        
        List<List<String>> results = new ArrayList<>(map.values());
        return results;
    }
}