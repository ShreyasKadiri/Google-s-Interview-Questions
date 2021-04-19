class Solution { 
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i=0;  i<coins.length; i++) {
            for (int j=1; j<=amount; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];    
                }
            }
        }
        return dp[amount];
    }
}


//Combinations Sum IV
class Solution { 
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=1; i<=target; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i>=nums[j]) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
