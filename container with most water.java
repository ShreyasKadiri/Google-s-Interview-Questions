class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int max=Integer.MIN_VALUE;
        int currArea=0;
        int l=0;
        int h=n-1;
        while(l<=h){
            currArea=(h-l) * Math.min(height[l],height[h]);
            if(height[l] > height[h]){
                h-=1;
            }
            else{
                l+=1;
            }
            max= max>currArea? max : currArea;
        }
        return max;
    }
}
