package expression;

public class TokenOperatorParenOpen extends TokenOperator {
	public TokenOperatorParenOpen(){
		
	}
	
	public TokenValue eval(ExpressionEvaluator evaluator) {
		return null;
	}
	
	public String toString() {
		return "(";
	}
	
	public int getPriority() {
		return 6;
	}
	
	public void parse(Parser parser) {
		parser.parse();
	}
}
