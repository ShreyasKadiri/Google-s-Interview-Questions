/*
Approach1: BruteForce:
Genrate all possible subsets and chek for the sum with given condition

Approach2:
DP

Approach 3:
Deque
*/


//DP Approach
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



//Deque Approach
class Solution{
    public int constrainedSubsetSum(int[] nums, int k) {
        int dp[] = new int[nums.length];
        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        max = Math.max(dp[0], max);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.offer(nums[0]);
        
        for(int i=1; i<nums.length; i++){
            dp[i] = nums[i];
            
            //If the element goes out of range
            if(i>k && deque.peekFirst() == dp[i-k-1]){
                deque.removeFirst();
            }
            dp[i] =  Math.max(dp[i], nums[i]+deque.peek());
            
            while(!deque.isEmpty() && deque.peekLast()<dp[i]){
                deque.pollLast();
            }
            deque.offerLast(dp[i]);
            max =  Math.max(dp[i],max);
        }
        return max;
    }    
}
