package expression;

import java.util.regex.*;
import java.math.BigInteger;

import util.Fraction;

public class TokenValue extends Token implements TokenEvaluatable {
	private static final Pattern numberGroups = Pattern.compile("(-?)(\\d+)_?(\\d*)/?(\\d*)");
	
	protected Fraction frac;
	
	public TokenValue(Fraction frac) {
		this.frac = frac; // well that was easy.
	}
	
	public TokenValue(String value){
		Matcher m = numberGroups.matcher(value);
		m.find();
		
		String sign = m.group(1);
		String n1 = m.group(2);
		String n2 = m.group(3);
		String n3 = m.group(4);
		
		if(n2.length() == 0 && n3.length() == 0){
			frac = new Fraction(n1, "1");
		} else {
			if(n2.length() == 0) {
				frac = new Fraction(n1, n3);
			} else {
				frac = new Fraction(n1, "1").add(new Fraction(n2, n3));
			}
		}
		
		if(sign.length() > 0)
			frac = frac.multiply(new Fraction("-1", "1"));
	}
	
	public String toString(){
		return frac.toString();
	}
	
	public TokenValue eval(ExpressionEvaluator eval) {
		return this;
	}
	
	public void parse(Parser parser) {
		parser.pushToken(this);
	}
}
