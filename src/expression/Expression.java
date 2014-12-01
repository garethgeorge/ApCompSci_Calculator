package expression;

import java.util.Vector;

public class Expression {
	private Token[] expression;
	private int index;
	
	public Expression(Vector<Token> tokens) {
		Parser p = new Parser(tokens);
		expression = p.getProgram();
	}
	
	public Token[] getTokens() {
		return expression;
	}
	
	
	// use it like a stack
	public void seekTop() {
		index = expression.length-1;
	}
	
	public Token pop() {
		if(index < 0)
			return null;
		else
			return expression[index--];
	}
	
	public int size() {
		return expression.length;
	}
	
	private String popStringValue() {
		Token value = pop();
		if(value == null){
			return "NULL";
		} else if(value instanceof TokenValue) {
			return String.valueOf(value);
		} else if(value instanceof TokenVariable) {
			return String.valueOf(value);
		} else if(value instanceof TokenOperator) {
			String arg2 = popStringValue();
			String arg1 = popStringValue();
			return String.format("(%s %s %s)", arg1, value, arg2);
		}
		return "NULL";
	}
	
	public String toString() {
		
		String expr = "";
		for(int i = 0; i < expression.length; ++i) 
			expr += (i == 0 ? "" : ", ") + expression[i];
		
		seekTop();
		String str = popStringValue();
		return expr + "  -->  " + str;
	}
}
