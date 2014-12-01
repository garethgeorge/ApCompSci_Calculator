package expression;

public class TokenFactoryOperatorAssign extends TokenFactory implements TokenFactoryOperator {
	public TokenFactoryOperatorAssign() {
		
	}
	
	public Token construct(String group) {
		return new TokenOperatorAssign();
	}
	
	public String getPatternString() {
		return "=";
	}
}
