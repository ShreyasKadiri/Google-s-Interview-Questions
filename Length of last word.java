class Solution {
    public int lengthOfLastWord(String s) {
        if (s==null || s.length()==0)
            return 0;
        
        int maxLastWordSize = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i)!= ' '){
                maxLastWordSize+=1;
            }
            else if (maxLastWordSize==0){
                continue;
            } 
            else {
                break;
        }
    }
    return maxLastWordSize;
  }
}
