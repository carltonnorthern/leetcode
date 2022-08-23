class Solution {
    public int minCostClimbingStairs(int[] cost) {
        cost = Arrays.copyOf(cost, cost.length+1);
        cost[cost.length-1] = 0;
        //int[] minCost = new int[cost.length];
        //Arrays.fill(minCost, -1);
        int min2 = cost[0];
        int min1 = cost[1];
        int min = 0;
        
        //return minCost(cost, minCost, cost.length-1);
        //minCost[0] = cost[0];
        //minCost[1] = cost[1];
        for(int i=2; i<cost.length; i++) {
            min = cost[i] + Math.min(min1, min2);
            min2 = min1;
            min1 = min;
        }
        return min;
    }
    
    /*private int minCost(int[] cost, int[] minCost, int n){
        if(n<0) {
            return 0;
        } else if(n<2) {
            return cost[n];
        } else if(minCost[n]!=-1){
            return minCost[n];
        } else {
            minCost[n] = cost[n] + Math.min(minCost(cost, minCost, n-1), minCost(cost, minCost, n-2));
            return minCost[n];
        }
    }*/
    
}