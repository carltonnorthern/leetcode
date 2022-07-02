class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxHor = horizontalCuts[0];
        long maxVer = verticalCuts[0];
        
        for(int i=0; i<horizontalCuts.length-1; i++) {
            maxHor = Math.max(maxHor, horizontalCuts[i+1] - horizontalCuts[i]);
        }
        maxHor = Math.max(maxHor, h - horizontalCuts[horizontalCuts.length-1]);
        
        for(int i=0; i<verticalCuts.length-1; i++) {
            maxVer = Math.max(maxVer, verticalCuts[i+1] - verticalCuts[i]);
        }
        maxVer = Math.max(maxVer, w - verticalCuts[verticalCuts.length-1]);
        
        return (int) ((maxHor * maxVer) % (1000000007));
    }
}