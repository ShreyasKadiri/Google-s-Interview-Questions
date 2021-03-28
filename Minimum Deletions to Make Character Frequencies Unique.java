class Solution {
    public int minDeletions(String s) {
        char frequency[] = new char[26];
        int result = 0;
        for(char c : s.toCharArray()){
            frequency[c - 'a']++;
        }
        char temp = 0;
        for(int i=0; i <frequency.length/2; ++i ) { 
            temp = frequency[i]; 
            frequency[i] = frequency[frequency.length - i - 1]; 
            frequency[frequency.length - i - 1] = temp; 
        }
        int maxAllowedFrequency =  frequency[0];
        
        for(int i=0; i<frequency.length; i++){
            if(frequency[i] > maxAllowedFrequency){
                if(maxAllowedFrequency>0){
                    result+=frequency[i]-maxAllowedFrequency;
                }else {
                    result+=frequency[i];
                    maxAllowedFrequency = Math.min(maxAllowedFrequency-1, frequency[i]-1);
                }
            }
        }
        
        return result;
    }
}
