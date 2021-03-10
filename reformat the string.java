class Solution {
    public String reformat(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        List<Character> digits = new ArrayList<>(s.length());
        List<Character> characters = new ArrayList<>(s.length());
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.add(ch);
            } else  {
                characters.add(ch);
            }
        }
        if(Math.abs(digits.size() - characters.size()) >= 2) return "";
        
        StringBuilder result = new StringBuilder();
        boolean digitOrChar = (digits.size() >= characters.size()) ? true : false; 

       for (int i=0; i<s.length(); i++) {
            if (digitOrChar) {
                if (digits.size() > 0) {
                    result.append(digits.remove(0));    
                }
            } else {
                if (characters.size() > 0) {
                    result.append(characters.remove(0));    
                }
            }
            digitOrChar = !digitOrChar;
        }
        return result.toString();
    }
}
