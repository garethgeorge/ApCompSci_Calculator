package expression;

public class TokenFactoryValue extends TokenFactory {
	
	public TokenFactoryValue() {
		super();
	}
	
	public Token construct(String match) {
		return new TokenValue(match);
	}
	
	public String getPatternString() {
		return "-?\\d+_?\\d*/?\\d*";
	}
}
    