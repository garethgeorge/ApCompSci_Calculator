package expression;

public class TokenOperatorSubtract extends TokenOperator {
	public TokenOperatorSubtract(){
		
	}
	
	public TokenValue eval(ExpressionEvaluator evaluator) {
		TokenValue arg2 = evaluator.popValue();
		TokenValue arg1 = evaluator.popValue();
		return new TokenValue(arg1.frac.subtract(arg2.frac));
	}
	
	public String toString() {
		return "-";
	}
	
	public int getPriority() {
		return 1;
	}
}
