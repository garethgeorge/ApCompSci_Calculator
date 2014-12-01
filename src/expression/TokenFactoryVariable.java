package expression;

public class TokenFactoryVariable extends TokenFactory {
	
	public TokenFactoryVariable() {
		super();
	}
	
	public Token construct(String match) {
		return new TokenVariable(match);
	}
	
	public String getPatternString() {
		return "[a-zA-Z][a-zA-Z0-9]*";
	}
}
    