class Solution {
    public int maxCoins(int[] piles) {
       Arrays.sort(piles);
        int maxCoins = 0;
        int i=piles.length -2;
        int t = piles.length/3 ;
        int j=0;
        while(j++ < t){
            maxCoins+=piles[i];
            i-=2;
        }
        
        return maxCoins;
    }
}
