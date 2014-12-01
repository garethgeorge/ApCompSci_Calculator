package expression;

public class TokenFactoryOperatorDivide extends TokenFactory implements TokenFactoryOperator {
	public TokenFactoryOperatorDivide() {
		
	}
	
	public Token construct(String group) {
		return new TokenOperatorDivide();
	}
	
	public String getPatternString() {
		return "\\/";
	}
}
