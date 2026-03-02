package practice;
import java.util.Stack;

public class InfixPostfix {
        // Method to return precedence of operators
        static int precedence(char ch) {
            switch (ch) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
            }
            return -1;
        }
        // Method to convert infix to postfix
        static String infixToPostfix(String exp) {
            StringBuilder postfix = new StringBuilder();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < exp.length(); i++) {
                char ch = exp.charAt(i);

                // If operand, add to postfix
                if (Character.isLetterOrDigit(ch)) {
                    postfix.append(ch);
                }

                // If '(', push to stack
                else if (ch == '(') {
                    stack.push(ch);
                }

                // If ')', pop until '('
                else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix.append(stack.pop());
                    }
                    stack.pop(); // remove '('
                }

                // If operator
                else {
                    while (!stack.isEmpty() &&
                            precedence(ch) <= precedence(stack.peek())) {
                        postfix.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }

            // Pop remaining operators
            while (!stack.isEmpty()) {
                postfix.append(stack.pop());
            }

            return postfix.toString();
        }

        public static void main(String[] args) {
            String infix = "A+B*(C-D)";
            System.out.println("Postfix: " + infixToPostfix(infix));
        }
}
//Scan A → postfix: A
//Scan + → stack: +
//Scan B → postfix: AB
//Scan * → stack: + *
//Scan ( → stack: + * (
//        Scan C → postfix: ABC
//        Scan - → stack: + * ( -
//        Scan D → postfix: ABCD
//        Scan ) → pop - → postfix: ABCD-
//Pop (
//        End → pop * → postfix: ABCD-*
//                Pop + → postfix: ABCD-*+
 