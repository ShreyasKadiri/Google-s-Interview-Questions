class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <=4){
            return 0;
        }
        Arrays.sort(nums);
        int choice1 = nums[nums.length-4] - nums[0];
        int choice2 = nums[nums.length-3] - nums[1];
        int choice3 = nums[nums.length-2] - nums[2];        
        int choice4 = nums[nums.length-1] - nums[3];
        return Math.min(Math.min(choice1, Math.min(choice2, choice3)), choice4);
    }
}
