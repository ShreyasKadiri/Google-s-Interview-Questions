class Solution {
    public int minDeletionSize(String[] A) {
        
        if(A.length == 0)
            return 0;
        
        int n = A[0].length();
        
        int[] dp = new int[n];
        for(int i=1;i<n;i++){
            dp[i] = i;
            for(int j=i-1;j>=0;j--){
                if(check(A, i, j))
                    dp[i] = Math.min(dp[i],i-j-1 + dp[j]);
            }
        }
        
        int ans = dp.length;
        for(int i=0;i<dp.length;i++)
            ans = Math.min(ans, dp[i]+dp.length-i-1);
        
        return ans;
    }
    
    private boolean check(String[] A, int i, int j){
        for(String str: A)
            if(str.charAt(i)<str.charAt(j))
                return false;
        
        return true;
    }
}
