class Solution {
    public int[] box;
    public List<Integer> aList;
    
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        box = new int[4];
        aList = new ArrayList<Integer>();
        for(int i=0; i<matchsticks.length; i++){
            aList.add(matchsticks[i]);
            total += matchsticks[i];
        }
        
        //if not divisible by 4 then can't make equal sides
        if(total % 4 != 0) {
            return false;
        }
        
        int div = total / 4;
        
        Collections.sort(aList, Collections.reverseOrder());
        
        return DFS(0, div);
    }
    
    private boolean DFS(int idx, int div) {
        if(idx == aList.size() && box[0] == div && box[1] == div && box[2] == div && box[3] == div) {
            return true;
        }
        
        for(int i=0; i<4; i++) {
            if(box[i] + aList.get(idx) <= div) {
                box[i] += aList.get(idx);
                if(DFS(idx+1, div)) {
                    return true;
                } 
                box[i] -= aList.get(idx);
            }
        }
        
        return false;
    }
}