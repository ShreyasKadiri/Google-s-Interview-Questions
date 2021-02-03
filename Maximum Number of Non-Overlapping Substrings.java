
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String> result = new ArrayList<>();
        HashMap<Character,int[]> map = new HashMap<Character, int[]>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.get(s.charAt(i))[1]=i;
            }
            else
                map.put(s.charAt(i),new int[]{i,i});
        }
        
        int substringStart = -1;
        for(int i=0; i<s.length(); i++){
            int startIndex = map.get(s.charAt(i))[0];
            if(startIndex==i){
                int substringEnd = getEnd(s,map,i);
                if(substringEnd!=-1){
                    if(substringEnd>substringStart){
                        result.add("");
                    }
                    substringStart = substringEnd;
                    result.set(result.size()-1,s.substring(i,substringStart+1));
                }
            }
        }
            return result;
        }
        
    
    public int getEnd(String s, Map<Character,int[]> map, int start){
        int endIndex = map.get(s.charAt(start))[1];
        for(int i=start; i<endIndex; i++){
             if(map.get(s.charAt(i))[0]<start) return -1;
            endIndex = Math.max(endIndex,map.get(s.charAt(i))[1]);
        }
        return endIndex;
    }
}
