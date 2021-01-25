class Solution {
    public int minMoves(int[] nums, int k) {
        int onesStore[] =  new int[nums.length];
        for(int i=0; i<nums.length; i++){
            onesStore[i] = i;
        }
        
        for(int i=0; i<onesStore.length; i++){
            onesStore[i]-=i;
        }
        
        int median = (k-1)/2;
        int leftSum = 0;
        int rightSum = 0;
        int minimumSwaps = Integer.MAX_VALUE;
        int leftCount=0;
        int rightCount=0;
        
        if(k%2==1){
            leftCount=rightCount=k/2;
        }
        else {
            leftCount= (k/2 - 1);
            rightCount = (k/2);
        }
        
        for(int i=0; i<median; i++){
            leftSum+=onesStore[median] - onesStore[i];
        }
        
        for(int i=median+1; i<k; i++){
            rightSum+=onesStore[i] - onesStore[median];
        }
        minimumSwaps=leftSum+rightSum;
        
        for(int i=k; i<nums.length; i++){
            leftSum-=onesStore[median] - onesStore[i-k];
            leftSum+=leftCount*(onesStore[median+1] - onesStore[median]);
            rightSum+=onesStore[i] - onesStore[median+1];
            rightSum-=rightCount*(onesStore[median+1] - onesStore[median]);
            minimumSwaps = Math.min(minimumSwaps,leftSum+ rightSum);
            median++;
        }
        
       return minimumSwaps;
    }
}
