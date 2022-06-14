class Solution {
    
    public static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public void wallsAndGates(int[][] input) {
        
        if(input == null || input[0] == null){
            return;
        }

        List<int[]> gates = new ArrayList<int[]>();

        //add gates to a list
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++) {
                if(input[i][j] == 0) {
                    int[] node = new int[]{i,j};
                    gates.add(node);
                }
            }
        }

        for(int[] gate : gates) {
            for(int[] direction : directions) {
                DFS(input, gate[0] + direction[0], gate[1] + direction[1], 1);
            }
        }
    }

    private void DFS(int[][] input, int row, int col, int count) {

        if(row<0 || row>=input.length || col<0 || col>=input[0].length || input[row][col]==0 || input[row][col] == -1 || input[row][col] <= count) {
            return;
        }

        input[row][col] = count;
        count++;

        for(int[] direction : directions) {
            DFS(input, row + direction[0], col + direction[1], count);
        }
    }
}