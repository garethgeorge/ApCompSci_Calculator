package expression;

public class TokenOperatorDivide extends TokenOperator {
	public TokenOperatorDivide(){
		
	}
	
	public TokenValue eval(ExpressionEvaluator evaluator) {
		TokenValue arg2 = evaluator.popValue();
		TokenValue arg1 = evaluator.popValue();
		return new TokenValue(arg1.frac.divide(arg2.frac));
	}
	
	public String toString() {
		return "/";
	}
	
	public int getPriority() {
		return 2;
	}
}
