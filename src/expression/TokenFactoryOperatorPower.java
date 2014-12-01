package expression;

public class TokenFactoryOperatorPower extends TokenFactory implements TokenFactoryOperator  {
	public TokenFactoryOperatorPower() {
		
	}
	
	public Token construct(String group) {
		return new TokenOperatorPower();
	}
	
	public String getPatternString() {
		return "\\^";
	}
}
