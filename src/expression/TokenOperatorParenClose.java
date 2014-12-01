package expression;

public class TokenOperatorParenClose extends TokenOperator {
	public TokenOperatorParenClose(){
		
	}
	
	public TokenValue eval(ExpressionEvaluator evaluator) {
		return null;
	}
	
	public String toString() {
		return ")";
	}
	
	public int getPriority() {
		return -1;
	}
	
	public void parse() {
	}
}
