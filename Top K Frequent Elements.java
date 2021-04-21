class Solution {
   public int[] topKFrequent(int[] nums, int k) {
       if(nums==null || nums.length==0 || k<1) 
           return new int[1];
       HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int num: nums){
           map.put(num,map.getOrDefault(num,0)+1);}
       PriorityQueue<Integer> heap= new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        heap.addAll(map.keySet());
       int[] result=new int[k];
       int i=0;
       while(!heap.isEmpty()){
           result[i++]=heap.poll();
           if(i==k) 
               break;
       }
       return result;
   }
}