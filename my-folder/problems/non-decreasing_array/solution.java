class Solution {
    public boolean checkPossibility(int[] nums) {
        return checkPossibility(nums, false, false);
    }
    
    public boolean checkPossibility(int[] nums, boolean once, boolean increase) {
        int prev = nums[0];
        for(int i=1; i< nums.length; i++) {
            if(nums[i] < prev && once){
                return false;
            }
            
            if(nums[i] < prev && !once){
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                boolean result1 = checkPossibility(nums, true, false);
                nums[i-1] = temp;
                nums[i] = nums[i-1];
                boolean result2 = checkPossibility(nums, true, true);
                if(result1 || result2) {
                    return true;
                } else {
                    return false;
                }
            }
            
            prev = nums[i];
        }
        return true;
    }
}