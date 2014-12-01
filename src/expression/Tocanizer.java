package expression;

import java.util.Vector;
import java.util.regex.*;

public class Tocanizer {
	private Vector<TokenFactory> factories;
	private Pattern pattern;
	
	public Tocanizer() {
		factories = new Vector<TokenFactory>();
		pattern = null;
	}
	
	public Expression parse(String line) {
		if(pattern == null) {
			String regex = "";
			for(int i = 0; i < factories.size(); ++i) {
				regex += (i == 0 ? "" : "|") + "("+factories.get(i).getPatternString()+")";
			}
			
			pattern = Pattern.compile(regex);
		}
		
		Matcher m = pattern.matcher(line);
		Vector<Token> expr = new Vector<Token>();
		while(m.find()) {
			Token token = null;
			for(int i = m.groupCount(); i > 0; --i){
				String group = m.group(i);
				if(group != null) {
					token = factories.get(i-1).construct(group);
					break;
				}
			}
			if(token != null) {
				expr.add(token);
			}
		}
		
		return new Expression(expr);
	}
	
	public void addTokenFactory(TokenFactory f) {
		factories.add(f);
		pattern = null;
	}
}
