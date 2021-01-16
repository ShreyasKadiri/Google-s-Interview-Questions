class Solution {
    public int getMaximumGenerated(int n) {
        if(n<2){
            return n;
        }
        int nums[] = new int[n+1];
        nums[0]=0;
        nums[1]=1;
        int max=0;
        for(int i=2; i<=n; i++){
            nums[i]=nums[i/2];
            if(i%2==1)
                nums[i]+=nums[i / 2 + 1];
                max=Math.max(max,nums[i]);
        }
        return max;
    }
}
