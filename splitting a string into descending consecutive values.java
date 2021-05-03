class Solution {
    public boolean splitString(String s) {
        if (s == null || s.length()<=1){
            return false;
        }
        return backtrack(0, s, new ArrayList<Long>());
    }
    
    public boolean backtrack(int position, String s, ArrayList<Long> result) {
        if (position >= s.length()) {
            return result.size() >= 2;
        }

        long value = 0;
        for (int i=position; i<s.length(); i++) {
            value = value*10 + (s.charAt(i)-'0'); 
            if (result.size()==0 || result.get(result.size()-1) - value == 1) {
                result.add(value); 
                if (backtrack(i+1, s, result)) {
                    return true;
                }
                result.remove(result.size()-1); 
            }
        }
        return false;
    }
}
