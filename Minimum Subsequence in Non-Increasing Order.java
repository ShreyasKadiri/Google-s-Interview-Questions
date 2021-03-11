class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int currentSum = 0;
        int totalSum = 0;
        
        for(int i=0; i<nums.length; i++){
            maxHeap.offer(nums[i]);
            totalSum+=nums[i];
        }
        
        while(currentSum <= totalSum/2){
            result.add(maxHeap.peek());
            currentSum+=maxHeap.poll();
        }        
        
        return result;
    }
}
