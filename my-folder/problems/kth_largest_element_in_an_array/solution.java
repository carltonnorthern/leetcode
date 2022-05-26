class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        return quickselect(nums, 0, nums.length-1, k);

        }

        private static void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

    public static int quickselect(int[] nums, int leftIndex, int rightIndex, int k) {
        //System.out.println("input = " + Arrays.toString(nums));
        //System.out.println("leftIndex = " + leftIndex);
        //System.out.println("rightIndex = " + rightIndex);

        int pivotIndex = rightIndex;
        int left = leftIndex;
        while(left<pivotIndex) {
            if(nums[left]>nums[pivotIndex]) {
                if(pivotIndex==left+1) {
                    swap(nums, left, pivotIndex);
                } else {
                    swap(nums, left, pivotIndex - 1);
                    swap(nums, pivotIndex - 1, pivotIndex);
                }
                pivotIndex--;
            } else {
                left++;
            }
        }

        if(pivotIndex < nums.length-k) {
            return quickselect(nums, pivotIndex+1, nums.length-1, k);
        } else if (pivotIndex > nums.length-k) {
            return quickselect(nums, 0, pivotIndex-1, k);
        } else {
            return nums[nums.length-k];
        }

        //System.out.println("output = " + Arrays.toString(nums));

    }
}
