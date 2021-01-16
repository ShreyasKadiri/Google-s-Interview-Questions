/*
Approach:
Summary: similar to checking valid parentheses with a stack, linear scan left to right, 'a', 'b' get pushed to the stack. 'c' will try to pop 'b', 'a' from the stack,
early return false if popping failed. Make sure stack is empty at the end. Linear space and time.
*/

class Solution {
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for(char curr: S.toCharArray()) {
            if(curr == 'a'){
                stack.push('c');
                stack.push('b');
            }else if(stack.isEmpty() || stack.pop() != curr) return false;
        }
        return stack.isEmpty();
    }
}
