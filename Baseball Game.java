class Solution {
    public int calPoints(String[] ops) {
        int result = 0;
		Stack<Integer> stack = new Stack<>();
		for (String word : ops) {
			if (word.equals("C")) {
				result = result - stack.pop();
			} else if (word.equals("D")) {
				result += 2 * stack.peek();
				stack.push(2 * stack.peek());

			} else if (word.equals("+")) {
				int poppedElement = stack.pop();
				int total= stack.peek() + poppedElement;
				stack.push(poppedElement);
				stack.push(total);
				result += total;
			} else {
				int currentValue = Integer.parseInt(word);
				stack.push(currentValue); 
				result += currentValue;
			}
		}
		return result;
    }
}
