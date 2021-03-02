class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        int result = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(check(mid, nums, maxOperations)){
                result = mid;
                high = mid - 1;
            }else {
                low = mid +1 ;
            }
        }
        return result;
    }
    
    public boolean check(int mid, int nums[], int maxOperations){
        for(int i=0; i<nums.length; i++){
            maxOperations = maxOperations - (nums[i]/mid);
            if(nums[i]%mid == 0){
                maxOperations+=1;
            }
        }
        return maxOperations>=0;
    }
}
