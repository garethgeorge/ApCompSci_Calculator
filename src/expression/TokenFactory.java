package expression;

public abstract class TokenFactory {
	public TokenFactory() {
		
	}
	
	public Token construct(String match) {
		return null;
	}
	
	public String getPatternString() {
		return null;
	}
}
