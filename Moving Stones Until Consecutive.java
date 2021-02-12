class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        //Already side by side then return {0.0} as no need to move
        int stones[] = new int[3];
        int [] movesResult = new int[2];

        stones[0] =a;
        stones[1] =b;
        stones[2] =c;

        Arrays.sort(stones);
        if(stones[2] - stones[0] == 2){
            return new int[]{0,0};
        }
        
        int xyDistance = stones[1] -  stones[0] -1;
        int yzDistance = stones[2] -  stones[1] -1;
        
        if(xyDistance>1 && yzDistance>1){
            movesResult[0]=2;
        }
            
            
        else if(xyDistance>=1 || yzDistance>=1){
            movesResult[0]=1; 
        }
        
        movesResult[1]=xyDistance+yzDistance;        
        
        return movesResult;        
    }
}
