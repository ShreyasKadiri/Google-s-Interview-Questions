class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : S.toCharArray()){
            if(!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        
        StringBuilder nonDupliate = new StringBuilder("");
        while(!stack.isEmpty()){
            nonDupliate.append(stack.pop());
        }
        return nonDupliate.reverse().toString();
    }
}
