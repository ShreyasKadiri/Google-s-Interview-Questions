class Solution {
    public int findLHS(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
         int maxLengthSubsequence = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        int currentLength = 0;
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }else {
                currentLength = 0;
                if(map.containsKey(nums[i]) && map.containsKey(nums[i]+1)){
                currentLength+= map.get(nums[i]) + map.get(nums[i]+1);
                }
            }
         maxLengthSubsequence = Math.max(maxLengthSubsequence, currentLength);   
        }
        return maxLengthSubsequence;
    }
}
