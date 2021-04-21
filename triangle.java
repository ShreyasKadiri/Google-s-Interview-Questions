class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<Integer>(triangle.get(triangle.size()-1));
        for(int i=triangle.size()-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp.set(j, Math.min(dp.get(j), dp.get(j+1)) + triangle.get(i).get(j));
            }
        }
        return dp.get(0);
    }
}
