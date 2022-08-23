class Solution {
    public int minPartitions(String n) {
        int maxNum = 0;
        for(int i=0; i<n.length(); i++) {
            maxNum = Math.max(maxNum, n.charAt(i) - '0');//.charInteger.valueOf(n.substring(i, i+1)));
            if(maxNum == 9) {
                break;
            }
                              
        }
        return maxNum;
    }
}