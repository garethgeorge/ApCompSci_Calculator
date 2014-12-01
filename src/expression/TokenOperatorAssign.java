package expression;

public class TokenOperatorAssign extends TokenOperator {
	public TokenOperatorAssign(){
		
	}
	
	public TokenValue eval(ExpressionEvaluator evaluator) {
		TokenValue arg2 = evaluator.popValue();
		TokenVariable arg1 = evaluator.popVariable();
		
		System.out.println("updated " + arg1.getName() + " to " + arg2);
		evaluator.getVariables().put(arg1.getName(), arg2);
		
		return arg2;
	}
	
	public String toString() {
		return "=";
	}
	
	public int getPriority() {
		return -1;
	}
	
	public void parse(Parser parser) {
		parser.parse();
		parser.pushToken(this);
	}
}
