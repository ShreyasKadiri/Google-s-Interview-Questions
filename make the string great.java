//Recursive
class Solution {
    public String makeGood(String s) {
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)+32 || s.charAt(i) == s.charAt(i+1)-32){
                return makeGood(s.substring(0,i) + s.substring(i+2));
            }
        }
        return s;
    }
}


//Stack Based Approach
class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(c - stack.peek())==32){
                stack.pop();
            }else{
              stack.push(c);   
            }
        }
        
        
        StringBuilder goodString = new StringBuilder("");
        while(!stack.isEmpty()){
            goodString.append(stack.pop());
        }
        return goodString.reverse().toString();
    }
}
