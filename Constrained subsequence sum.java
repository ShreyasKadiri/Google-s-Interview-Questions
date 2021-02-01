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


/*
Approach 3:
1.  We need to find max of maxSum's k elements 

2. We take a queue called kqueue that stores last k maxSum elements and update the queue with new elements
removing the last one 

3. To keep track of current maximum in kqueue we use another queue called maxQueue 

4. When we remove the element from the front of kqueue, we check if it is same as the front of maxQueue
a. If it is, then pop the front of maxQueue as well 
b. If not, then dont pop 

5. When we push the element at the back of kqueue, we check if the element is greater than the back of maxQueue
a. If it is then we remove the element from the back of maxQueue
b. Go back until the new element is greater than back of maxQueue

6. Now when either maxQueue is empty or the new element is less than or equal to back of maxQueue, we insert
this new element at the back of maxQueue

7. Also push the new element at the back of kqueue
8. We update the result when the max of these localmax obtained during ith iteration


*/



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
