class Solution {
    public int subarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int output = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            count = nums[i];
            if(count == k) {
                output++;
            }
            for(int j=i+1; j<nums.length; j++) {
                count += nums[j];
                if(count==k) {
                    output++;
                }
            }
        }
        
        return output;
    }
}