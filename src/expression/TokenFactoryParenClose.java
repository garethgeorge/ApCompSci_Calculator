package expression;

public class TokenFactoryParenClose extends TokenFactory implements TokenFactoryOperator {
	public TokenFactoryParenClose() {
		
	}
	
	public Token construct(String group) {
		return new TokenOperatorParenClose();
	}
	
	public String getPatternString() {
		return "\\)";
	}
}
