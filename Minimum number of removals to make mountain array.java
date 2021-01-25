/*
https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/discuss/952016/JAVA-LIS-with-detailed-explanation-and-comments.-O(N2)-time-and-O(N)-Space.-Revised.

*/

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        
        //Calculate longest increasing subsequence on left side of an index
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j] && left[i]<left[j]+1){
                    left[i] = left[j]+1;
                }
            }
        }
        
         //Calculate longest increasing subsequence on right side of an index
        for(int i=nums.length-2; i>=0; i--){
            for(int j=nums.length-1; j>i; j--){
                if(nums[i]>nums[j] && right[i]<right[j]+1){
                    right[i] = right[j]+1;
                }
            }
        }
        
        int maximum= 0 ;
        for(int i=1; i<nums.length-1; i++){
            if(right[i]>1 && left[i]>1){
                maximum = Math.max(maximum, left[i]+right[i]-1);
            }
        }
        return nums.length-maximum;
    }
}
