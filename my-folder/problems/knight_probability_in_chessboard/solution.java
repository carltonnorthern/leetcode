class Solution {
    
    Pair[] DIRECTIONS = new Pair[]{
            new Pair(-2, 1),
            new Pair(-2, -1),
            new Pair(1, 2),
            new Pair(-1, 2),
            new Pair(2, 1),
            new Pair(2, -1),
            new Pair(1, -2),
            new Pair(-1, -2)
    };

    public class Pair {
        private int first;
        private int second;
        public Pair(int a, int b) {
            first = a;
            second = b;
        }
    }

    public double knightProbability(int n, int k, int row, int col) {
        /*double[][][] dp = new double[k+1][n][n];
        for(double[][] d : dp) {
            for(double[] p : d) {
                Arrays.fill(p, 0.0);
            }
        }*/

        double[][] prevdp = new double[n][n];
        double[][] currdp = new double[n][n];
        for(double[] p : prevdp) {
            Arrays.fill(p, 0.0);
        }

        for(double[] c : currdp) {
            Arrays.fill(c, 0.0);
        }


        //double result = recurse(n, k, row, col, dp);

        prevdp[row][col] = 1;

        double result = 0.0;
        for(int step=1; step<k+1; step++) {
            for(int r=0; r<n; r++){
                for(int c=0; c<n; c++) {
                    for (int i = 0; i < DIRECTIONS.length; i++) {
                        Pair dir = DIRECTIONS[i];
                        int prevRow = r + dir.first;
                        int prevCol = c + dir.second;
                        if (prevRow >= 0 && prevRow < n && prevCol >= 0 && prevCol < n) {
                            //dp[step][r][c] += dp[step - 1][prevRow][prevCol] / 8;
                            currdp[r][c] += prevdp[prevRow][prevCol] / 8;
                        }
                    }
                }
            }
            prevdp = currdp;
            currdp = new double[n][n];
            for(double[] p : currdp) {
                Arrays.fill(p, 0.0);
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                result = result + prevdp[i][j];
            }
        }

        return result;
    }

    private void printMatrix(double[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for( int j=0; j<matrix.length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private double recurse(int n, int k, int row, int col, double dp[][][]){
        if(row < 0 || row >= n || col < 0 || col >= n) {
            return 0;
        }

        if(k==0) {
            return 1;
        }

        if(dp[k][row][col]!=-1) {
            return dp[k][row][col];
        }

        double result = 0.0;

        for(int i=0; i<DIRECTIONS.length; i++) {
            Pair direction = DIRECTIONS[i];
            result += recurse(n, k-1, row+direction.first, col+direction.second, dp)/8;
        }
        dp[k][row][col] = result;

        return result;
    }
}