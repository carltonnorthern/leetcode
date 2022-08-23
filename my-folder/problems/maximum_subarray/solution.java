class Solution {
    public int maxSubArray(int[] nums) {
       
        
        int left = 0;
        int leftIdx = 0;
        int leftCount = 0;
        int right = nums.length-1;
        int rightIdx = right;
        int rightCount = 0;
        int max = 0;
        while(left<right) {
            if(leftCount + nums[left] < 0) {
                leftCount = 0;
                leftIdx = left + 1;
            } else {
                leftCount += nums[left];
                max = Math.max(max, leftCount);
            }
            if(rightCount + nums[right] < 0) {
                rightCount = 0;
                rightIdx = right - 1;
            } else {
                rightCount += nums[right];
                max = Math.max(max, rightCount);
            }
            
            left++;
            right--;
            
        }
        
        int count = 0;
        for(int i=leftIdx; i<= rightIdx; i++) {
            count += nums[i];
        }
        
        max = Math.max(max, count);
        
        //handle negative only numbers
        if(max == 0) {
            max = Integer.MIN_VALUE;
            for(int i=0; i<nums.length; i++){
                max = Math.max(max, nums[i]);
            }
        }
        
        return max;
    }
}