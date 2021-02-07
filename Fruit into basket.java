class Solution {
    //Longest substring with atmost 2 characters
    public int totalFruit(int[] tree) {
        int maximum = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int i=0;
        int j=0;
        
        while(j< tree.length){
            if(map.size() <=2){
                map.put(tree[j], j++);
            }
            
            if(map.size() > 2){
                int minimum = tree.length-1;
                for(int value : map.values()){
                    minimum = Math.min(minimum, value);
                }
                i = 1 + minimum;
                map.remove(tree[minimum]);
            }
            maximum = Math.max(maximum, j-i);
        }
        return maximum;
    }
}
