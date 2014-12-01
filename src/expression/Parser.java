package expression;

import java.util.Stack;
import java.util.Vector;
import util.ArrayStack;

public class Parser {
	private ArrayStack<Token> expr;
	private Stack<Token> prog;

	public Parser(Vector<Token> expr) {
		this.expr = new ArrayStack<Token>(expr);
		this.expr.reverse();
		this.prog = new Stack<Token>();

		try {
			parse();
		} catch (Error e) {
			throw e;
		}
	}
	
	public void pushToken(Token token) {
		prog.push(token);
	}
	
	public Token peekAhead() {
		return expr.size() > 0 ? expr.peek() : null;
	}
	
	public Token popToken() {
		return expr.size() > 0 ? expr.pop() : null;
	}

	public Token[] getProgram() {
		Token[] tokens = new Token[prog.size()];
		for (int i = 0; i < prog.size(); ++i) {
			tokens[i] = prog.get(i);
		}
		return tokens;
	}

	public void popValue(int priority) {
		Token nextToken = expr.pop();
		if (nextToken instanceof TokenOperator) {
			((TokenOperator) nextToken).parse(this);
		} else if (nextToken instanceof TokenEvaluatable) { // token value is evaluatable
			Token nextOp = expr.size() > 0 ? expr
					.peek() : null;

			prog.push(nextToken);
			if(nextOp != null){
				if(!(nextOp instanceof TokenOperator))
					throw new Error("expected token operator following value, got unexpected");
				if (((TokenOperator) nextOp).getPriority() > priority)
					processOperator((TokenOperator) expr.pop());
			}
			
		} else {
			throw new Error("expected token value or open paren, got neither.");
		}
	}

	public void processOperator(TokenOperator op) {
		popValue(op.getPriority());
		prog.push((Token) op);
	}

	public void parse() {
		int leftArgs = 0;
		while (expr.size() > 0) {
			Token next = expr.pop();
			if( next instanceof TokenOperatorParenClose ){
				break ;
			} else if( next instanceof TokenOperator) {
				if(leftArgs > 1)
					throw new Error("Expected one left hand value, operator got " + leftArgs + " values.");
				((TokenOperator) next).parse(this);
				leftArgs = 0;
			} else if(next instanceof TokenEvaluatable) {
				leftArgs++;
				pushToken(next);
			}
		}
		if(leftArgs > 0)
			throw new Error("Parse error, value(s) could not be linked to operator, evaulation may have unexpected behavior.");
	}
}
