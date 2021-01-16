class Solution{
public int minOperations(int[] nums, int x) {
Map<Integer,Integer> map = new HashMap<Integer,Integer>();
map.put(0 ,-1);
int result=-x;
int longest=-1;
int currentSum=0;
for(int i=0; i<nums.length; i++){
    result+=nums[i];
} 
    if(result==0){
        return nums.length;
    }

for(int i=0 ; i<nums.length; i++) {
    currentSum+=nums[i];
     if(map.containsKey(currentSum-result)) {
         longest = Math.max(longest, i-map.get(currentSum-result));
         }
    map.put(currentSum,i);
    }
    return longest==-1 ? -1 : nums.length-longest;
    }
}
