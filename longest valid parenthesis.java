public class Solution {
    public int longestValidParentheses(String s) {
        if (s==null ||s.length()==0)
            return 0;
        
        int[] dp=new int[s.length()+1];
        int result=0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i)==')' && i-dp[i]>=1 && s.charAt(i-dp[i]-1)=='(') {
                dp[i+1]=dp[i-dp[i]-1]+dp[i]+2;
            }
        }
        for(int i=0;i<dp.length;i++) {
            if(dp[i]>result)
            result=dp[i];
        }
        return result;
    }
}
