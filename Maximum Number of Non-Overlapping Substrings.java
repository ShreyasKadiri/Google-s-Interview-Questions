/*
Approach:
1. Use a HashMap to keep a track of chracter and {starting and ending index}
2. We will try to find end point of the substring
3. We will pass the starting index of substring and find the last index of substring
4. We fix the last occurence of this character as the end index
5. If it is valid i.e there is no occurence of this character before starting index, then it checks if there is a character
after starting index
6. Take the maximum of both
*/

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
