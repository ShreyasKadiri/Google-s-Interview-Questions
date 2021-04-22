class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<wall.size(); i++){
            int position = 0;
            for(int j=0; j<wall.get(i).size(); j++){
                position+= wall.get(i).get(j);
                map.put(position, map.getOrDefault(position,0)+1);
                if(i == 0){
                    sum+= wall.get(i).get(j);
                }
            }
        }
        for(Integer key : map.keySet()){
            if(sum == key){
                continue;
            }
            result = Math.min(result, wall.size() - map.get(key));
        }
        return  result == Integer.MAX_VALUE ? wall.size(): result;
    }
}
