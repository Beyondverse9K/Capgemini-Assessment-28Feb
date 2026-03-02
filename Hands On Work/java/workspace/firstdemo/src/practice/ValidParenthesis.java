package practice;

import java.util.Stack;

public class ValidParenthesis {

	public ValidParenthesis() {
		// TODO Auto-generated constructor stub
	}
	public static boolean isValid(String s) {
		Stack<Character> stack=new Stack<>();
		for (char c: s.toCharArray()) {
			if(c=='('||c=='{'||c=='[') {
				stack.push(c);
			}
			else {
				if(stack.isEmpty())
					return false;
				char top=stack.pop();
				if(c==')'&&top!='(')
					return false;
				if(c=='}'&&top!='{')
					return false;
				if(c==']'&&top!='[')
					return false;
			}
		}
		return stack.isEmpty();
	}
	public static void main(String args[]) {
		if(isValid("(()())")) {
			System.out.println("Balanced Parenthesis");
		}
		else
		{
			System.out.println("Not Balanced");
		}
	}

}
