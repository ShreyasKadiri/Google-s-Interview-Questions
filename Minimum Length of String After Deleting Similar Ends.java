class Solution {
    public int minimumLength(String s) {
        int low  = 0;
        int high = s.length() - 1;
        int length = s.length();
        
        while(low < high){
            if(s.charAt(low) == s.charAt(high)){
                char currentCharacter = s.charAt(low);
                
                //Find the same characters to form similar end on left thats needs to be deleted
                while(low<high && currentCharacter == s.charAt(low)){
                    low++;
                    length--;
                }
                
                //Find the same characters to form similar end on right that needs to be deleted
                while(high>=low && currentCharacter == s.charAt(high)){
                    high--;
                    length--;
                }
            }else {
                break;
            }
        }
     return length;   
    }
}
