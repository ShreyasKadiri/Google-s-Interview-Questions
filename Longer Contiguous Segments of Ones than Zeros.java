class Solution{
    public boolean checkZeroOnes(String s) {
        int longestZerosLength = 0;
        int longestOnesLength = 0;
        int currentZerosLength = 0;
        int currentOnesLength = 0;
        for(int i=0; i<s.length(); i++) 
            if(s.charAt(i) == '0') {
                longestZerosLength = Math.max(longestZerosLength, ++currentZerosLength);
                currentOnesLength = 0;
            }else {
                longestOnesLength = Math.max(longestOnesLength, ++currentOnesLength);
                currentZerosLength = 0;
            }
        return longestOnesLength > longestZerosLength;
    }
}
