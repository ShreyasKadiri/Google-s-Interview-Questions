class Solution {
    public String findLongestWord(String s, List<String> d) {
    String longestWord= "";
    for (String currentWord : d) {
        int i=0;
        for (char c : s.toCharArray()) 
            if (i<currentWord.length() && c==currentWord.charAt(i)){
              i+=1;  
            } 

        if (i==currentWord.length() && currentWord.length()>=longestWord.length()) 
            if (currentWord.length() > longestWord.length() || currentWord.compareTo(longestWord) < 0)
                longestWord=currentWord;
    }
    return longestWord;
    }
}
