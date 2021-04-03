class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        while(true){
            int zeroCount = 0 ;
            int i = 0;
            
            //Keep track of zeroes
            for(i=0 ; i<nums.length; i++){
                if( (nums[i]&1) == 1) {
                    break;
                } else if(nums[i]==0){
                     zeroCount+=1;
                }
            }
            
            //Once all the array elements are made zeroes , then just return count
            if(zeroCount  == nums.length){
                 return count;
            }
            
            
            //If even, then divide by 2 and hence increment count
            if(i == nums.length){ 
                count+=1; 
                for(i=0 ; i<nums.length; i++) 
                    nums[i]/=2;
            }
            
            //If odd, then subtract 1 from number to make it even and hence increment count
            for(i=0 ; i<nums.length; i++){
                if((nums[i]&1) == 1){
                    count+=1;
                    nums[i]-=1;
                }
            }
        }
    }
}
