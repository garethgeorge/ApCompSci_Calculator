package expression;

public class TokenFactoryOperatorAdd extends TokenFactory implements TokenFactoryOperator {
	public TokenFactoryOperatorAdd() {
		
	}
	
	public Token construct(String group) {
		return new TokenOperatorAdd();
	}
	
	public String getPatternString() {
		return "\\+";
	}
}
