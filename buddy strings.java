class Solution {
    public boolean buddyStrings(String A, String B) {
     if(A.length()!=B.length()){
         return false;
     }
        
        if(A.equals(B)){
            HashSet<Character> set = new HashSet<Character>();
            for(char c : A.toCharArray()){
                set.add(c);
            }
            if(set.size() < A.length()){
                return true;
            }else {
                return false;
            }
        }
        
        List<Integer> differentIndices = new ArrayList<Integer>();
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)!=B.charAt(i)){
                differentIndices.add(i);
            }
        }
        
        if(differentIndices.size()==2 && A.charAt(differentIndices.get(0))==
           B.charAt(differentIndices.get(1))  &&
           A.charAt(differentIndices.get(1))==
           B.charAt(differentIndices.get(0))){
            return true; 
        }else {
        return false;    
        }
        
    }
}
