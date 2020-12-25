class Solution {
    public int singleNumber(int[] nums) {
      HashMap<Integer,Integer> map = new  HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
Time Complexity : O(n)
Space Complexity: O(n)

//Sorting 
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i+=3){
            if(nums[i]!=nums[i+2]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
Time Complexity : O(nlogn)
Space Complexity: O(1)
    
    
//Bitwise  (Left shifting << means multiplying by 2)
class Solution {
    public int singleNumber(int[] nums) {
        int shift = 1;
        int result=0;
        for(int i=0; i<32; i++){
            int count=0;
            for(int j=0; j<nums.length; j++){
                if((nums[j] & shift)==1){
                    count+=1;
                }
            }
                if(count%3!=0)
                    result+=shift;
                    shift*=2;
        }
        return result;
    }
}    
    
    
    
    
    
