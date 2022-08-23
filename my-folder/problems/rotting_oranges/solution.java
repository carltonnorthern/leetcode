class Solution {
    public static int[][] directions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
            };
    
    public int orangesRotting(int[][] test) {
        if(test == null || test[0] == null){
            return 0;
        }

        List<List<Integer>> q = new ArrayList<List<Integer>>();
        int count = 0;

        for(int i=0; i<(test.length); i++) {
            for(int j=0; j<(test[0].length); j++) {
                if (test[i][j] == 2) {
                    //DFS(input, i, j);
                    List<Integer> index = new ArrayList<Integer>();
                    index.add(i);
                    index.add(j);
                    q.add(index);
                }
            }
        }

        if(q.size()>0) {
            count = BFS(test, q, count) - 1;
        }
        
        for(int i=0; i<(test.length); i++) {
            for (int j = 0; j < (test[0].length); j++) {
                if (test[i][j] > 0) {
                    return -1;
                }
            }
        }

        return count;
    }

    private int BFS(int[][] input, List<List<Integer>> q, int count) {

        if(q.size()==0) {
            return count;
        }

        List<List<Integer>> childQ = new ArrayList<List<Integer>>();

        while(q.size()>0) {
            List<Integer> poppedIndex = q.remove(0);
            int row = poppedIndex.get(0);
            int col = poppedIndex.get(1);
            input[row][col] = 0;

            for (int[] direction : directions) {
                List<Integer> temp = new ArrayList<Integer>();
                int tempRow = row + direction[0];
                int tempCol = col + direction[1];
                if (tempRow >= 0 && tempRow < input.length && tempCol >= 0 && tempCol < input[0].length && input[tempRow][tempCol] == 1) {
                    input[tempRow][tempCol] = 2;
                    temp.add(tempRow);
                    temp.add(tempCol);
                    childQ.add(temp);
                }
            }
        }
        count++;

        return BFS(input, childQ, count);

    }
}