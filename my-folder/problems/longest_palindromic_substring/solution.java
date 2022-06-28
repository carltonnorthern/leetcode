class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();
        /*int[][] truth = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(truth[i], -1);
        }

        String max = "";

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                String curr = findPalindromeLength(s, truth, i, j);
                if(max.length() < curr.length()) {
                    max = curr;
                }
            }
        }*/
        String max = "";

        for(int i=0; i<s.length(); i++) {
            int left = i;
            int right = i ;

            while(isPalindrome(s, left, right)) {
                left--;
                right++;
            }

            if((right-1) - (left+1) >= max.length()) {
                max = s.substring(left+1, right);
            }

            left = i;
            right = i+1;
            while(isPalindrome(s, left, right)) {
                left--;
                right++;
            }

            if((right-1) - (left+1) >= max.length()) {
                max = s.substring(left+1, right);
            }

            /*left = i;
            right = i;
            while(bool) {
                if(left>=0 && right<s.length()) {
                    bool = s.substring(left, left + 1).equals(s.substring(right, right + 1));
                } else {
                    bool = false;
                }
                left--;
                right++;
            }

            if((right -1) - (left+1) > max.length()) {
                max = s.substring(left+1, right -1);
            }*/

        }




        return max;
    }

    private boolean isPalindrome(String s, int left, int right) {
        if(left>=0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            return true;
        }
        return false;
    }

    private String findPalindromeLength(String s, int[][] truth, int i, int j) {
        if(truth[i][j]==1) {
            return s.substring(i, j+1);
        } else if(truth[i][j]==0) {
            return "";
        }
        if(recurse(s, truth, i, j)){
            return s.substring(i, j+1);
        }
        return "";
    }

    private boolean recurse(String s, int[][] truth, int i, int j) {
        if(i==j) {
            truth[i][j]=1;
            return true;
        }
        if(truth[i][j]!=-1) {
            if(truth[i][j]==1) {
                return true;
            } else {
                return false;
            }
        }
        if(j==i+1) {
            if(s.substring(i,i+1).equals(s.substring(j,j+1))) {
                truth[i][j]=1;
                return true;
            } else {
                truth[i][j]=0;
                return false;
            }
        }
        if(s.substring(i,i+1).equals(s.substring(j,j+1))) {
            boolean bool = recurse(s, truth, i+1, j-1);
            if(bool) {
                truth[i+1][j-1] = 1;
                return true;
            } else {
                truth[i+1][j-1] = 0;
                return false;
            }
        } else {
            truth[i][j] = 0;
            return false;
        }

    }
}