class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        backTrack(S.toCharArray(), result, 0);
        return result;
    }
    
    public void backTrack(char[] s, List<String> result, int i){
        if(i == s.length){
            result.add(new String(s));
        }else{
            if(Character.isLetter(s[i])){ 
                s[i] = Character.toUpperCase(s[i]);
                backTrack(s,result, i+1); 
                s[i] = Character.toLowerCase(s[i]);
                backTrack(s,result, i+1); 
            }
            else
                backTrack(s,result, i+1); 
        }      
    }
}
