class Solution {
    public int minimumLength(String s) {
        int low  = 0;
        int high = s.length() - 1;
        if(s.length() == 1){
            return 1;
        }
        char currentCharacter = ' ';
         while(low<high && s.charAt(low) == s.charAt(high))
             currentCharacter = s.charAt(low);
             while(low < s.length() && s.charAt(low) == currentCharacter)
                 low+=1;
              while(-1<high && s.charAt(high) == currentCharacter)
                  high-=1;
         return Math.max(0, high - low + 1);
    }
}
