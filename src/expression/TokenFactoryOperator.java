package expression;

public interface TokenFactoryOperator {
	public Token construct(String match);
	
	public String getPatternString();
}
