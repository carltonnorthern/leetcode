class Solution {
    int[][] directions = new int[][]{{-1,0}, {0,1}, {1, 0}, {0, -1}};
    boolean[][] seen;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        seen = new boolean[m][n];
        List<int[]> q = new ArrayList<int[]>();
        
        int max = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) {
                    max = Math.max(DFS(grid, i, j), max);
                }
            }
        }
        
        return max;
        
    }
    
    private int DFS(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        
        if(i<0 || i >= m || j < 0 || j >= n || seen[i][j] == true) {
            return 0;
        }
        
        if(grid[i][j] == 0) {
            seen[i][j] = true;
            return 0;
        }
        
        int count = 0;
        if(grid[i][j] == 1) {
            seen[i][j] = true;
            count++;
            for(int[] dir : directions) {
                int row = dir[0];
                int col = dir[1];
                count += DFS(grid, i+row, j+col);
            }
        }
        
        return count;
    }
}