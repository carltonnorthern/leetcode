class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length==0) {
            return 0.0;
        }

        if(nums1.length == 0) {
            return getMedian(nums2);
        }

        if(nums2.length == 0) {
            return getMedian(nums1);
        }

        double nums1Median = getMedian(nums1);
        double nums2Median = getMedian(nums2);
        int totalN = nums1.length + nums2.length;

        int rightElementNums1 = getRightMedianElement(nums1);
        int leftElementNums1 = getLeftMedianElement(nums1);
        if(nums2Median >= nums1Median) {
            while(rightElementNums1 < nums1.length -1 && nums2Median >= nums1[rightElementNums1]){
                rightElementNums1++;
            }

        } else {
            while(leftElementNums1 > 0 && nums2Median <= nums1[leftElementNums1]){
                leftElementNums1--;
            }
        }
        
        int rightElementNums2 = getRightMedianElement(nums2);
        int leftElementNums2 = getLeftMedianElement(nums2);
        if(nums1Median >= nums2Median) {
            while(rightElementNums2 < nums2.length -1 && nums1Median >= nums2[rightElementNums2]){
                rightElementNums2++;
            }

        } else {
            while(leftElementNums2 > 0 && nums1Median <= nums2[leftElementNums2]){
                leftElementNums2--;
            }
        }

        int middleNums1 = rightElementNums1 - leftElementNums1 + 1;
        int middleNums2 = rightElementNums2 - leftElementNums2 + 1;
        int middleTotalN = middleNums1 + middleNums2;
        int[] middleArray = new int[middleTotalN];
        int count = 0;
        for(int i=leftElementNums1; i<=rightElementNums1; i++) {
            middleArray[count] = nums1[i];
            count++;
        }

        for(int i=leftElementNums2; i<=rightElementNums2; i++) {
            middleArray[count] = nums2[i];
            count++;
        }

        Arrays.sort(middleArray);

        int leftSideN = leftElementNums1 + leftElementNums2;
        int rightSideN = nums1.length - rightElementNums1 + nums2.length - rightElementNums2 -2;

        int half = totalN / 2;
        double median = 0.0;
        if(totalN % 2 == 1) {
            median = middleArray[half-leftSideN];
        } else {
            int left = half - 1 - leftSideN;
            int right = half - leftSideN;
            median = (double)(middleArray[left] + middleArray[right]) / 2;
        }


        return median;
    }

    private int getLeftMedianElement(int[] nums) {
        int medianElement = 0;
        int half = nums.length / 2;
        if(nums.length % 2 == 1) {
            medianElement = half;
        } else {
            medianElement = half -1;
        }

        return medianElement;
    }

    private int getRightMedianElement(int[] nums) {
        int medianElement = 0;
        int half = nums.length / 2;
        if(nums.length % 2 == 1) {
            medianElement = half;
        } else {
            medianElement = half;
        }

        return medianElement;
    }

    private double getMedian(int[] nums) {
        double median = 0.0;
        int half = nums.length / 2;
        if(nums.length % 2 == 1) {
            median = nums[half];
        } else {
            int left = half - 1;
            int right = half;
            median = (double)(nums[left] + nums[right]) / 2;
        }

        return median;
    }
}