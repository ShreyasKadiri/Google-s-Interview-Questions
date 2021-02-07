class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
     List<List<Integer>> result  = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for(int i=0; i<groupSizes.length; i++){
            List<Integer> currentList = map.getOrDefault(groupSizes[i], new ArrayList<>());
            currentList.add(i);
            map.put(groupSizes[i], currentList);
        }
        
        for(int key : map.keySet()){
            int i=0;
            List<Integer> currentList  = map.get(key);
            do{
                result.add(currentList.subList(i, i+key));
                i+=key;
            }
            while(i+key <= currentList.size());
        }
        return result;
    }
}
