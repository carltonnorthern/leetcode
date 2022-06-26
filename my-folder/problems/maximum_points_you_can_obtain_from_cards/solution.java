class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int max = 0;
        if(n==0) {
            return 0;
        }

        if(k>=n) {
            for(int i=0; i<n; i++) {
                max+=cardPoints[i];
            }
            return max;
        }
        /*
        int[][] memo = new int[n+1][n+1];
        for(int i=0; i<k; i++) {
            Arrays.fill(memo[i], 0);
        }
        return recurse(cardPoints, k, 0, 0, cardPoints.length-1, memo);

         */

        int windowCount = 0;
        int left = 0;
        int w = n - k;
        int right = w;

        for(int i=0; i<w; i++) {
            windowCount+=cardPoints[i];
        }

        int minWindowCount = windowCount;
        for(int i=1; i<= n - w; i++) {
            windowCount-=cardPoints[i-1];
            windowCount+=cardPoints[i+w-1];
            if(windowCount < minWindowCount){
                minWindowCount = windowCount;
                left = i;
                right = i+w;
            }
        }


        for(int i=0; i<left; i++) {
            max+=cardPoints[i];
        }

        for(int i=right; i<n; i++) {
            max+=cardPoints[i];
        }

        return max;

    }
}