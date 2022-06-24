class Solution {
    char[] chars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void solveSudoku(char[][] board) {
        //for(int i=0; i<9; i++){
          //  rows.add(new HashSet<Character>());
        //}

        recurse(board, 0, 0 );
    }

    private boolean recurse(char[][] board, int row, int col) {

        if(row>8) {
            return true;
        }

        if(board[row][col]=='.') {
            for(char c : chars) {
                if(isValid(board, c, row, col)) {

                    board[row][col] = c;

                    if(advance(board, row, col)){
                        return true;
                    }

                    board[row][col] = '.';
                }
            }
        } else {
            if(advance(board, row, col)){
                return true;
            }
        }

        return false;

    }

    private boolean advance(char[][] board, int row, int col) {
        if(col == board[0].length- 1) {
            if (recurse(board, row+1, 0)) {
                return true;
            }
        } else {
            if (recurse(board, row, col+1)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, char value, int row, int col) {
        char[] currRow = board[row];
        char[] currCol = getColumn(board, col);
        char[] currSquare = getSquare(board, row, col);

        Set<Character> chars = new HashSet<Character>();
        for(char c : currRow) {
            chars.add(c);
        }
        for(char c : currCol) {
            chars.add(c);
        }
        for(char c : currSquare) {
            chars.add(c);
        }

        if(chars.contains(value)) {
            return false;
        }
        return true;
    }

    private char[] getSquare(char[][] board, int row, int col) {
        char[] result = new char[9];
        int rowRange = 0, colRange = 0;
        if(row > 2) {
            rowRange = 3;
            if(row > 5) {
                rowRange = 6;
            }
        }
        if(col > 2) {
            colRange = 3;
            if(col > 5) {
                colRange = 6;
            }
        }

        int count = 0;
        for(int i=rowRange; i<rowRange+3; i++) {
            for(int j=colRange; j<colRange+3; j++) {
                result[count] = board[i][j];
                count++;
            }
        }

        return result;

    }

    private void printMatrix(char[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for( int j=0; j<matrix.length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private char[] getColumn(char[][] board, int col) {
        char[] result = new char[9];
        for(int i=0; i<board.length; i++) {
            result[i] = board[i][col];
        }
        return result;
    }
}