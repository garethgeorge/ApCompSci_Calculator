package expression;

public class TokenVariable extends Token implements TokenEvaluatable {
	private String name;
	public TokenVariable(String name) {
		this.name = name;
	}
	
	public String toString(){
		return name;
	}

	public TokenValue eval(ExpressionEvaluator eval) {
		TokenValue value = eval.getVariables().get(name);
		if(value == null)
			throw new Error("Variable " + name + " is not defined.");
		return value;
	}
	
	public String getName() {
		return name;
	}
}
