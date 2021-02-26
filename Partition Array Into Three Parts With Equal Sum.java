class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int totalSum = 0;
        for(int i=0; i<A.length; i++){
           totalSum+=A[i];
        }
        if(totalSum%3!=0){
            return false;
        }
        
        //Calculating for each segment
        int segmentSum=totalSum/3;
        int totalSegments=0;
        int currentSegmentSum=0;
        
        for(int i=0; i<A.length; i++){
            currentSegmentSum+=A[i];
            //Lets see if we can form segment
            if(currentSegmentSum==segmentSum){
              totalSegments+=1;
              currentSegmentSum=0;
             }
        }
        return totalSegments>=3;
    }
}
