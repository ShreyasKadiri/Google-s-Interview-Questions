class Solution{
    public int countSubarraysWithEqualZeroesAndOnes(int a[]){
        if(a.length==0){
            return 0;
        }
        int count=0;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        int sum=0;
        for(int val : a){
            if(val==0){
            sum+=-1;    
            }
            else{
                sum+=1;
            } 
            if(map.containsKey(val)){
            count+=map.getValue(val);
            map.put(val, map.getValue(val)+1);    
            }
            else {
            map.put(sum,1);    
            }
        }
        return count;
    }
}
