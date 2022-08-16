class Solution {

    int[] weights;
    double[] probs;
    public Solution(int[] w) {
        this.weights = w;
        probs = new double[w.length];
        int sum = 0;
        for(int i=0; i<w.length; i++) {
            sum += w[i];
        }
        
        probs[0] = (double)w[0] / (double)sum;
        for(int i=1; i<w.length; i++) {
            probs[i] = ((double)w[i] / (double)sum) + probs[i-1];
            System.out.print(w[i] + "/" + sum + " = " + probs[i] + " ");
        }
    }
    
    public int pickIndex() {
        double rando = Math.random();
        
        
        int low = 0;
        int high = probs.length;
        while(low < high) {
            int middle = low + (high - low) / 2;
            if(rando < probs[middle]) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */