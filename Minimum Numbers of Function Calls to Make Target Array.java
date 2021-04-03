class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        while(true){
            int zeroCount = 0 ;
            int i = 0;
            for(i=0 ; i<nums.length; i++){
                if( (nums[i]&1) == 1) {
                    break;
                } else if(nums[i]==0){
                     zeroCount+=1;
                }
            }
            if(zeroCount  == nums.length){
                 return count;
            }
            
            if(i == nums.length){ 
                count+=1; 
                for(i=0 ; i<nums.length; i++) 
                    nums[i]/=2;
            }
            for(i=0 ; i<nums.length; i++){
                if((nums[i]&1) == 1){
                    count+=1;
                    nums[i]-=1;
                }
            }
            
        }
    }
}
