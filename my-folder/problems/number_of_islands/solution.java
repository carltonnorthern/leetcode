class Solution {
    
    public static int[][] directions = {
        {-1, 0}, 
        {0, 1}, 
        {1, 0}, 
        {0, -1}
    };
    
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid[0] == null){
            return 0;
        }

        List<Integer> q = new ArrayList<Integer>();
        int count = 0;

        for(int i=0; i<(grid.length); i++) {
            for(int j=0; j<(grid[0].length); j++) {
                if (grid[i][j] == '1') {
                    count++;
                    //DFS(input, i, j);
                    DFS(grid, i, j);
                }
            }
        }

        return count;
    }

    private void DFS(char[][] input, int row, int col) {

        if(row<0 || row>=input.length || col<0 || col>=input[0].length || input[row][col]=='0') {

            return;
        }

        input[row][col] = '0' ;

        for(int[] direction : directions) {
            DFS(input, row + direction[0], col + direction[1]);
        }
    }

    private void BFS(char[][] input, int row, int col, List<Integer> q) {

        if(row<0 || row>=input.length || col<0 || col>=input[0].length || input[row][col]=='0') {
            return;
        }

        input[row][col] = '0' ;

        for(int[] direction : directions) {
            q.add(getSequentialIndex(input, row + direction[0], col + direction[1]));
        }

        while(q.size()>0) {
            int[] poppedIndex = get2DIndex(input, q.remove(0));
            BFS(input, poppedIndex[0], poppedIndex[1], q);
        }
    }

    private int getSequentialIndex(char[][] input, int row, int col) {
        return ((row * input[0].length) + col);
    }

    private int[] get2DIndex(char[][] input, int index) {
        int[] output = new int[2];
        output[0] = (int) Math.floor(index / input[0].length);
        output[1] = index % input[0].length;
        return output;
    }
    
}