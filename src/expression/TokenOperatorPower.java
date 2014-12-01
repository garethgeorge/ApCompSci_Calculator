package expression;

public class TokenOperatorPower extends TokenOperator {
	public TokenOperatorPower(){
		
	}
	
	public TokenValue eval(ExpressionEvaluator evaluator) {
		TokenValue arg2 = evaluator.popValue();
		TokenValue arg1 = evaluator.popValue();
		return new TokenValue(arg1.frac.pow(arg2.frac));
	}
	
	public String toString() {
		return "^";
	}
	
	public int getPriority() {
		return 3;
	}
}
