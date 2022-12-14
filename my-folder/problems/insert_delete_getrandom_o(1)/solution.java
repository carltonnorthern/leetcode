class RandomizedSet {

    Set<Integer> set;
    
    public RandomizedSet() {
        set = new HashSet<Integer>();
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {
        
        int rando = ThreadLocalRandom
            .current()
            .nextInt(0, set.size());
        
        return (int)set.toArray()[rando];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */