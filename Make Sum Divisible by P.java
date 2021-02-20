 class Solution{
 public int minSubarray(int[] nums, int p) {
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, -1);
        long sum=0, cur=0;
        for(int i : nums) sum+=i; 
        int target=(int)(sum%p), res=nums.length;
        for(int i=0;i<nums.length;i++) {
            cur+=nums[i];
            map.put((int)(cur%p), i);
            int curTarget=((int)(cur%p)+p-target)%p;
            if(map.containsKey(curTarget)) res=Math.min(res, i-map.get(curTarget));
        }
        return res==nums.length?-1:res;
    }
 }   
