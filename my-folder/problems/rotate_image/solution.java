class Solution {
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        int offset = 0;
        
        while(start < end) {
            transform(matrix, start, end, offset);
            offset++;
            start++;
            end--;
        }
    }
    
    public void transform(int[][] matrix, int start, int end, int offset) {
        for(int i=start; i<end; i++) {
            int temp = matrix[start][i];
            matrix[start][i] = matrix[end - i + offset][start];
            matrix[end - i + offset][start] = matrix[end][end - i + offset];
            matrix[end][end - i + offset] = matrix[i][end];
            matrix[i][end] = temp;
        }
    }
}