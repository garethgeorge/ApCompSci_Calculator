package expression;

public class TokenFactoryOperatorSubtract extends TokenFactory implements TokenFactoryOperator  {
	public TokenFactoryOperatorSubtract() {
		
	}
	
	public Token construct(String group) {
		return new TokenOperatorSubtract();
	}
	
	public String getPatternString() {
		return "\\-";
	}
}
