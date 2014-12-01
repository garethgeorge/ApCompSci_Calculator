package expression;

public class TokenOperatorMultiply extends TokenOperator {
	public TokenOperatorMultiply(){
		
	}
	
	public TokenValue eval(ExpressionEvaluator evaluator) {
		TokenValue arg1 = evaluator.popValue();
		TokenValue arg2 = evaluator.popValue();
		return new TokenValue(arg1.frac.multiply(arg2.frac));
	}
	
	public String toString() {
		return "*";
	}
	
	public int getPriority() {
		return 2;
	}
}
