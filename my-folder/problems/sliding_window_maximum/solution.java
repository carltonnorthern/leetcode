class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        List<Integer> maxList = new ArrayList<Integer>();

        for(int i=0; i<k-1; i++) {
            clean(dq, nums, i, k);
            dq.addLast(i);
        }
        
        for(int i=k-1; i<nums.length; i++){
            clean(dq, nums, i, k);
            dq.addLast(i);
            maxList.add(nums[dq.getFirst()]);
        }

        return maxList.stream().mapToInt(i -> i).toArray();
    }
    
    private void clean(Deque<Integer> dq, int[] nums, int i, int k){
        if(!dq.isEmpty() && dq.getFirst() <= i - k) {
            dq.removeFirst();
        }
        
        while(!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
            dq.removeLast();
        }
    }
}