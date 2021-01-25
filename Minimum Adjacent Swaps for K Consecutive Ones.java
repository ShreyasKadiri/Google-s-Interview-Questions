class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> onesStore  = new ArrayList<Integer>(nums.length);
        
        for(int i=0; i<nums.length ;i++){
            if(nums[i]==1){
            onesStore.add(i);                    
            }
        }
        
        
        int median=(k)/2;
        int sum=0;
        int minimumSwaps=0;
        int currentMedian = median;
        int leftCount=0;
        int  rightCount=0; 
    
        //calculate first time
        for(int i=0; i<k; i++){
            if(i<=median){
            leftCount+=Math.abs(onesStore.get(currentMedian) - onesStore.get(i)) - Math.abs(currentMedian-i);
            }
            else{
rightCount+=Math.abs(onesStore.get(currentMedian) - onesStore.get(i)) - Math.abs(currentMedian-i);   
            }
        }
        
        minimumSwaps = rightCount + leftCount;
        int rightValue = k%2 == 1? median : median -1;
        
        //use sliding window and move current mid
        for(int i=k; i<onesStore.size() ; i++){
         int nextDifference =  Math.abs(onesStore.get(currentMedian)-onesStore.get(currentMedian+1));
         leftCount -=  Math.abs(onesStore.get(currentMedian) - onesStore.get(i-k));
         leftCount += nextDifference * (median);
         rightCount -= nextDifference* rightValue;
         rightCount +=  Math.abs(onesStore.get(i)-onesStore.get(currentMedian+1));
         currentMedian++;
         minimumSwaps = Math.min(minimumSwaps, leftCount+rightCount);
        }
        
        return minimumSwaps;
    }
}
