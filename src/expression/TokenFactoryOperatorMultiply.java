package expression;

public class TokenFactoryOperatorMultiply extends TokenFactory implements TokenFactoryOperator  {
	public TokenFactoryOperatorMultiply() {
		
	}
	
	public Token construct(String group) {
		return new TokenOperatorMultiply();
	}
	
	public String getPatternString() {
		return "\\*";
	}
}
