package expression;

import java.util.Stack;
import util.ArrayStack;
import java.util.HashMap;

public class ExpressionEvaluator {
	private ArrayStack<Token> expression;
	private HashMap<String,TokenValue> variables;
	
	public ExpressionEvaluator(Expression parent, HashMap<String, TokenValue> variables) {
		expression = new ArrayStack<Token>(parent.getTokens());
		this.variables = variables;
	}
	
	public TokenVariable popVariable() {
		Token next = expression.pop();
		if(!(next instanceof TokenVariable)) {
			throw new Error("expected token variable. Did not get one.");
		}
		
		return (TokenVariable) next;
	}
	
	public TokenValue popValue() {
		Token next = expression.pop();
		if(next instanceof TokenEvaluatable) {
			return ((TokenEvaluatable) next).eval(this);
		} else {
			throw new Error("could not evaluate next token to a value!");
		}
	}
	
	public Token eval() {
		Token next = expression.pop();
		if(next instanceof TokenOperator)
			return ((TokenOperator) next).eval(this);
		else if(next instanceof TokenOperator) {
			variables.put("ans", (TokenValue) next);
			return next;
		}
		return null;
	}
	
	public HashMap<String,TokenValue> getVariables() {
		return variables;
	}
}
