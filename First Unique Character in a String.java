class Solution {
    public int firstUniqChar(String s) {
        int frequencyCount[] = new int[26];
        
        for(int i=0; i<s.length(); i++){
            frequencyCount[s.charAt(i)- 'a']++;
        }
        
        
        for(int i=0; i<s.length(); i++){
            if(frequencyCount[s.charAt(i)- 'a'] ==1 ){
                return i;
            }
        }
        return -1;
    }
}
