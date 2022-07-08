class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> output = new ArrayList<int[]>();
        output.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            output = merge(intervals[i], output);
        }
        
        return output.toArray(new int[output.size()][]);
    }
    
    private List<int[]> merge(int[] interval, List<int[]> output) {
        int[] currInterval = output.get(output.size()-1);
        if(currInterval[1] < interval[0]) {
            output.add(interval);
        } else {
            if(currInterval[1] < interval[1]) {
                currInterval[1] = interval[1];
            }
        }
        
        return output;
    }
}