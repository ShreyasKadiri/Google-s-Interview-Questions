/*
Approach1: BruteForce:
Genrate all possible subsets and chek for the sum with given condition

Approach2:
DP

*/

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int dp[] =  new int[nums.length];
        int result =-1;
        for(int i=0; i<nums.length; i++){
            dp[i] = nums[i];
            for(int j=i-1; j>=0 && j>=i-k; j--){
                dp[i] =  Math.max(dp[i], nums[i]+dp[j]);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
