class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeft= 0 ;
        int minRight = Integer.MAX_VALUE;
        for(int i=0; i<left.length; i++){
            maxLeft = Math.max(maxLeft, left[i]);
        }
        
        for(int i=0; i<right.length; i++){
            minRight = Math.min(minRight, right[i]);
        }    
        return Math.max(n-minRight, maxLeft);
    }
}
