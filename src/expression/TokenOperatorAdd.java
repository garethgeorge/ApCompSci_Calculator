package expression;

public class TokenOperatorAdd extends TokenOperator {
	public TokenOperatorAdd(){
		
	}
	
	public TokenValue eval(ExpressionEvaluator evaluator) {
		TokenValue arg1 = evaluator.popValue();
		TokenValue arg2 = evaluator.popValue();
		return new TokenValue(arg1.frac.add(arg2.frac));
	}
	
	public String toString() {
		return "+";
	}
	
	public int getPriority() {
		return 1;
	}
}
