class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<List<Integer>> set = new HashSet();
        
        for(int i : nums) {
            if(map.get(i)==null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        
        if(map.containsKey(0) && map.get(0)>=3) {
            List<Integer> list = Arrays.asList(0,0,0);
            Collections.sort(list);
            set.add(list);
        }
        
        for(int i : map.keySet()) {
            int target = -i -i;
            if(map.containsKey(target) && map.get(i)>=2 && target != i) {
                List<Integer> list = Arrays.asList(target,i,i);
                Collections.sort(list);
                set.add(list);
            }
    
            for(int j : map.keySet()) {
                if(i!=j) {
                    target = -i - j;
                    if(target != i && target != j) {
                        if(map.containsKey(target)) {
                            List<Integer> list = Arrays.asList(target,i,j);
                            Collections.sort(list);
                            set.add(list);
                            
                        }
                    }
                }
            } 
        }
        
        return new ArrayList(set);
        
    }
}