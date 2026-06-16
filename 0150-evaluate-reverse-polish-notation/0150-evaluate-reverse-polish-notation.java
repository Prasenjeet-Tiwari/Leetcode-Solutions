import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            
            // Check if the current token is an operator
            if (curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")) {
                // The second operand is popped first
                int b = st.pop();
                // The first operand is popped second
                int a = st.pop();
                
                // Perform the operation and push the result
                if (curr.equals("+")) st.push(a + b);
                else if (curr.equals("-")) st.push(a - b);
                else if (curr.equals("*")) st.push(a * b);
                else if (curr.equals("/")) st.push(a / b);
            } else {
                // If it's a number string, convert it to an integer and push it
                st.push(Integer.parseInt(curr));
            }
        }
        return st.pop();
    }
}
