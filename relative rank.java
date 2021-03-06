class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        //Store the elements with index
        for(int i=0; i<score.length; i++){
            map.put(scores[i], i);
        }
        
        Arrays.sort(score);
        
        for(int i=0; i<score.length/2; i++){
            int swapped = score[i];
            scores[i] = scores[score.length - i -1];
            scores[score.length - i -1] = swapped;
        }
        
        String result[] =  new String[score.length];
        
        for(int i=0; i<score.length; i++){
            if(i == 0){
                result[map.get(score[i])] = "Gold Medal"
            }
             else if(i == 1){
                result[map.get(score[i])] = "Silver Medal"
            }else if(i == 2){
                 result[map.get(nums[i])] = "Bronze Medal";
             }else {
                 result[map.get(nums[i])] = (i+1)+"";
             }
        }
        return result;
    }
}
