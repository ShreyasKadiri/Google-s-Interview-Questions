class Solution {
    public boolean isNStraightHand(int[] hand, int w) {
        if(hand.length % w !=0){
            return false;
        }
        
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for(int i=0; i<hand.length; i++){
            treeMap.put(hand[i], treeMap.getOrDefault(hand[i],0)+1);
        }
        
        while(treeMap.size() > 0){
         int minimumValue = treeMap.firstKey();
            for(int i=minimumValue; i<minimumValue+w; i++){
                if(!treeMap.containsKey(i)){
                    return false;
                }
                int frequency = treeMap.get(i);
                if(frequency == 1){
                    treeMap.remove(i);
                }
                else{
                    treeMap.replace(i, frequency-1);
                }
            }
        }
        return true;
    }
}
