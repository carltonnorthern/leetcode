class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] r1, int[] r2) {
                int value = Double.compare(r1[0], r2[0]);
                return value;
            }
        });
        
        int[] prev = null;
        for(int i=0; i< intervals.length; i++) {
            int[] curr = intervals[i];
            if(prev != null) {
                if(curr[0] < prev[1]) {
                    return false;
                }
            }
            prev = curr;
        }
        
        return true;
    }
}