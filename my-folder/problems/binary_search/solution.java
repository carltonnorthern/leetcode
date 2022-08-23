class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        return binarySearch(nums, left, right, target);
        
            
        
    }
    //[-5, -4, -2, 0, 1, 4, 6, 7] target is -4
    public int binarySearch(int[] nums, int left, int right, int target) { //left = 0, right = 1
        
        if(left>=right) {
            if(nums[left]==target) {
                return left;
            } else
            return -1;
        }
        
        int middle = (int)Math.floor((right + left)/2); //middle = 1
        
        
        if(nums[middle]==target){
            return middle;
        } else if(nums[middle]<target) {
            return binarySearch(nums, middle+1, right, target);
        } else if(nums[middle]>target) {
            return binarySearch(nums, left, middle-1, target);
        } else {
            return -1;
        }
    }
    
}