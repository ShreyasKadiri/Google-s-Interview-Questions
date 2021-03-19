class Solution {
    public int videoStitching(int[][] clips, int T) {
        int total = 0;
        int minimum = 0;
        int maximum = 0;
        
        while(maximum < T){
            for(int i=0; i<clips.length; i++){
                int low = clips[i][0];
                int high = clips[i][1];
                if(low<=minimum && high>maximum){
                   maximum =   high;
                }
            }
            if(minimum == maximum){
                return -1;
            
            minimum = maximum;
            total++;
        }
        return total;
    }
}
