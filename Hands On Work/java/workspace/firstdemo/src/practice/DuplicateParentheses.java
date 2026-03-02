package practice;

import java.util.Stack;
public class DuplicateParentheses {
	public DuplicateParentheses() {
		// TODO Auto-generated constructor stub
	}
    public static boolean hasDuplicate(String st) {
        Stack<Character> stack = new Stack<>();
        for (char ch : st.toCharArray()) {
            if (ch == ')') {
                if (stack.peek() == '(') {
                    return true;
                }
                while (stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(hasDuplicate("((a+b))")); 
    }
}

