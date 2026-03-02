package practice;

import java.util.Stack;

public class Prefix {
	public Prefix() {
		// TODO Auto-generated constructor stub
	}
    public static int evaluate(String st) {
        Stack<Integer> stack = new Stack<>();
        for (int i=st.length()-1;i>=0;i--) {
        	char ch=st.charAt(i);
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int a = stack.pop();
                int b = stack.pop();
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
        String s="-+9*234";
    	System.out.println(evaluate(s)); 
    }
}

