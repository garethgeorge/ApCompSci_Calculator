package expression;

public abstract class TokenOperator extends Token implements TokenEvaluatable {
	public String toString() {
		return null;
	}
	
	public int getPriority(){
		return 0;
	}
	
	public void parse(Parser parser) {
		parser.popValue(this.getPriority());
		parser.pushToken(this);
	}
}
