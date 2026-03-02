package practice;

import java.util.Stack;

public class Postfix {
	public Postfix() {
		// TODO Auto-generated constructor stub
	}
    public static int evaluate(String st) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : st.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        System.out.println(evaluate("231*+9-")); 
    }
}

