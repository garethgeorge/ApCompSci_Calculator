package util;

import expression.*;
import java.util.HashMap;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Calculator {
	private HashMap<String,TokenValue> variables;
	private Tocanizer tocanizer;
	
	public Calculator(HashMap<String,TokenValue> variables) {
		this.variables = variables;
		tocanizer = new Tocanizer();
		
		tocanizer.addTokenFactory(new TokenFactoryValue());
		tocanizer.addTokenFactory(new TokenFactoryOperatorAdd());
		tocanizer.addTokenFactory(new TokenFactoryOperatorMultiply());
		tocanizer.addTokenFactory(new TokenFactoryOperatorDivide());
		tocanizer.addTokenFactory(new TokenFactoryOperatorSubtract());
		tocanizer.addTokenFactory(new TokenFactoryOperatorPower());
		tocanizer.addTokenFactory(new TokenFactoryOperatorAssign());
		tocanizer.addTokenFactory(new TokenFactoryParenOpen());
		tocanizer.addTokenFactory(new TokenFactoryParenClose());
		tocanizer.addTokenFactory(new TokenFactoryVariable());
	}
	
	public Calculator() {
		this(new HashMap<String,TokenValue>());
	}
	
	public String evaluate(String problem) {
		
		try {
			Expression expr = tocanizer.parse(problem);
			ExpressionEvaluator eval = new ExpressionEvaluator(expr, variables);
			return eval.eval().toString();
		} catch (Error e) {
			return "INVALID";
		}
	}
	
	private static long getCpuTime( ) {
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
	    return bean.isCurrentThreadCpuTimeSupported( ) ?
	        bean.getCurrentThreadCpuTime( ) : 0L;
	}
}
