package expression;

public class TokenFactoryParenOpen extends TokenFactory implements TokenFactoryOperator {
	public TokenFactoryParenOpen() {
		
	}
	
	public Token construct(String group) {
		return new TokenOperatorParenOpen();
	}
	
	public String getPatternString() {
		return "\\(";
	}
}
