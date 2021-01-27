/*
https://leetcode.com/problems/allocate-mailboxes/discuss/685620/JavaC%2B%2BPython-Top-down-DP-Prove-median-mailbox-O(n3)
*/
class Solution {
    public int minDistance(int[] houses, int k) {
        int[][] cost = new int[houses.length][houses.length];
        int[][] dp = new int[k+1][houses.length];
        Arrays.sort(houses);
        for (int i=0; i<houses.length; i++) {
            for (int j=i; j<houses.length; j++) {
                for (int K=i; K<=j; K++) {
                    cost[i][j]+= Math.abs(houses[(i+j)/2] - houses[K]);
                }
            }
        }
        return solve(cost, k, 0, houses.length, dp);
    }
    
    private int solve(int[][] cost, int k, int index, int n, int[][] dp) {
        if (k==0 && index==n) {
            return 0;
        }
        if (k==0 || index==n) {
            return Integer.MAX_VALUE;
        }
        if (dp[k][index]>0) {
            return dp[k][index];
        }
        
        int min=Integer.MAX_VALUE;
        for (int i=index; i<n; i++) {
            int next = solve(cost, k-1, i+1, n, dp);
            if (next!= Integer.MAX_VALUE) {
                min=Math.min(min, cost[index][i] + next);
            }
        }
        return dp[k][index]=min;
    }
}
