class Solution {
    public void nextPermutation(int[] nums) {
        nextPermutation(nums, 0);
    }
    
    public void nextPermutation(int[] nums, int pivot) {
        if(pivot == nums.length - 1) {
            for(int i=pivot; i>0; i--) {
                if(nums[i-1] < nums[i]) {
                    Arrays.sort(nums, i, nums.length);
                    for(int j=i; j<nums.length; j++) {
                        if(nums[j] > nums[i-1]) {
                            swap(nums, i-1, j);
                            return; 
                        }
                    }
                }
            }
            Arrays.sort(nums);
            return;
        }
        int i = pivot;
        while(i < nums.length - 1) {
            if(nums[i] >= nums[i+1]) {
                nextPermutation(nums, i + 1);
                return;
            }
            i++;
        }
        swap(nums, nums.length - 2, nums.length - 1);
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}