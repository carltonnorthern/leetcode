class Solution {
    int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    int M = 1000000007;
    int[][][] memo;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(m == 0 || n == 0 || maxMove == 0) {
            return 0;
        }
        
        int total = 0;
        memo = new int[maxMove+1][m][n];
        for (int[][] l : memo) {
            for (int[] sl : l) {
                Arrays.fill(sl, -1);
            }
        }
        
        
        return DFS(m, n, maxMove, startRow, startColumn);
        
    }

    
    private int DFS(int m, int n, int currMove, int row, int col) {
        if(row >= m || row<0 || col >= n || col < 0) {
            return 1;
        }
        
        if(currMove == 0) {
            return 0;
        }
        
        if(memo[currMove][row][col] != -1) {
            return memo[currMove][row][col];
        }
        
        
            
        memo[currMove][row][col] = (
            (DFS(m, n, currMove - 1, row - 1, col) + DFS(m, n, currMove - 1, row + 1, col)) % M +
            (DFS(m, n, currMove - 1, row, col - 1) + DFS(m, n, currMove - 1, row, col + 1)) % M
            ) % M;
        
        
        return memo[currMove][row][col];
    }
}