class Solution {
    public String arrangeWords(String text) {
        String words[] = text.split(" ");
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        StringBuilder rearrangedString = new StringBuilder("");
        
        rearrangedString.append(words[0].substring(0,1).toUpperCase() + words[0].substring(1));
        
        for(int i=1; i<words.length; i++){
            rearrangedString.append(" " + words[i].toLowerCase());
        }
        return rearrangedString.toString().trim();
    }
}
