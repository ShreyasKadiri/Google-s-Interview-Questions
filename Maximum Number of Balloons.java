class Solution {
    public int maxNumberOfBalloons(String text) {
        int frequency[] = new int[26];
        int count = 0;
        for(char c : text.toCharArray()){
             frequency[c - 'a']++;           
        }
        
        while(true){
          if(frequency['b' -'a'] >=1 && frequency['a' -'a']>=1 && frequency['l' -'a']>=2 && frequency['o' -'a']>=2 && frequency['n' -'a']>=1){
            count+=1;
            frequency['b' -'a']--;
            frequency['a' -'a']--;
            frequency['l' -'a']-=2;
            frequency['o' -'a']-=2;
            frequency['n' -'a']--;
            }else{
                break;
            }
        }
        
        return count;
    }
}
