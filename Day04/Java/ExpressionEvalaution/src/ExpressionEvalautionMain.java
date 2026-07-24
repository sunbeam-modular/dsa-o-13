import java.util.Stack;

public class ExpressionEvalautionMain {
	
	public static int calculate(int op1, char opr, int op2) {
		switch(opr) {
		case '+': return op1 + op2;
		case '-': return op1 - op2;
		case '*': return op1 * op2;
		case '/': return op1 / op2;
		case '%': return op1 % op2;
		case '$': return (int)Math.pow(op1, op2);
		}
		return 0;
	}
	
	public static int postfixEvaluation(String postfix) {
		//0. create stack to push operands
		Stack<Integer> st = new Stack<Integer>();
		//1. process postfix expression from left to right
		for(int i = 0 ; i < postfix.length() ; i++) {
			//2. extract charcter from ith index
			char element = postfix.charAt(i);
			//3. if element is operand, push it on  stack
			if(Character.isDigit(element))
				st.push(element - '0');		// to convert into number from character
			//4. if element is operator, pop two elements from stack
			else {
				int op2 = st.pop();
				int op1 = st.pop();
				//5. find result of op1, op2 and operator
				int res = calculate(op1, element, op2);
				//6. push result back to stack
				st.push(res);
			}
		}
		//7. pop result from stack and return
		return st.pop();
	}
	
	public static int prefixEvaluation(String prefix) {
		//0. create stack to push operands
		Stack<Integer> st = new Stack<Integer>();
		//1. process prefix expression from right to left
		for(int i = prefix.length()-1 ; i >= 0 ; i--) {
			//2. extract charcter from ith index
			char element = prefix.charAt(i);
			//3. if element is operand, push it on  stack
			if(Character.isDigit(element))
				st.push(element - '0');		// to convert into number from character
			//4. if element is operator, pop two elements from stack
			else {
				int op1 = st.pop();
				int op2 = st.pop();
				//5. find result of op1, op2 and operator
				int res = calculate(op1, element, op2);
				//6. push result back to stack
				st.push(res);
			}
		}
		//7. pop result from stack and return
		return st.pop();
	}

	public static void main(String[] args) {
		String postfix = "59+4862/-*-173-$+";
		
		System.out.println("Postfix = " + postfix);
		int result = postfixEvaluation(postfix);
		System.out.println("Result = " + result);
		
		String prefix = "+-+59*4-8/62$1-73";
		
		System.out.println("Prefix = " + prefix);
		result = prefixEvaluation(prefix);
		System.out.println("Result = " + result);

	}

}
