class Solution {
    public int countBinarySubstrings(String s) {
        int currentLength = 1;
        int previousLength = 0;
        int count = 0;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)){
                currentLength++;
            }else {
            previousLength = currentLength;
            currentLength = 1;
        }
        if (previousLength >= currentLength){
            count++;
        }
    }
    return count;    
    }
}
