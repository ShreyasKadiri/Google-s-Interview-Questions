/*
https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/discuss/574943/Java-Detailed-Explanation-with-Graph-Demo-DP-Easy-Understand
*/
class Solution {
    public int numOfWays(int n) {
        long color2= 6;
        long color3 = 6;
        int mod = (int)(1e9)+7;
        for(int i=2; i<=n; i++){
            long color3Temp =  color3;
            color3 = (2*color3 + 2*color2)%mod;
            color2 = (2*color3Temp + 3*color2)%mod;
        }
        return (int)(color3+color2)%mod;
    }
}
