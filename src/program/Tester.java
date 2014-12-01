package program;
import java.util.HashMap;

import util.Calculator;
import util.Fraction;
import expression.*;
public class Tester {
	private Calculator calc;
	
	public Tester() {
		this.calc = new Calculator();
	}

	public void tests() {
		TestCase[] testCases = {
			new TestCase("1/2 + 2/3", "1_1/6"),
			new TestCase("10 / -5", "-2"),
			new TestCase("-1/2 - 2", "-2_1/2"),
			new TestCase("10/11 * 5/8", "25/44"),
			new TestCase("1/100 / -1_5/10", "-1/150"),
			new TestCase("1/4 + 1_1/2", "1_3/4"),
			new TestCase("8/4 + 2", "4"),
			new TestCase("-1 * -1/2", "1/2"),
			new TestCase("11/17 - -1/17", "12/17"),
			new TestCase("1/2 + 2/3", "1_1/6"),
			
			// extra credit (more than 2 operands)
			new TestCase("1/2 + 2/3 + 3/4", "1_11/12"),
			new TestCase("5/9 - 2/11 - 1/20", "641/1980"),
			
			// extra credit (order of operations)
			new TestCase("1/2 + 2/3 * 3/4 - 1/2", "1/2"),
			new TestCase("1/2 * 3/4 + 1/2 * 1/2", "5/8"),
			new TestCase("2 + 4 * 3 - 1", "13"),
			new TestCase("2 + 4 * 3 - 1 + 10 / -5", "11"),
			new TestCase("5 / 10 * 2", "1"),
			new TestCase("5 * 10 / 2", "25"),
			
			// extra credit: handle invalid input
			new TestCase("1 + + 1/2", "INVALID"),
			new TestCase("2_0/1 + 2_0/10", "4"),
			new TestCase("Hazen Rocks!", "INVALID"),
			new TestCase("abc + 5", "INVALID")
		};
		
		int failures = 0;
		for(TestCase c : testCases)
			if(!c.run(calc))
				failures++;
		
		System.out.println("--------------------------");
		System.out.println("Tests failed: " + failures);
	}
		
	public static class TestCase {
		private String question, answer;
		public TestCase(String question, String answer) {
			this.question = question;
			this.answer = answer;
		}
		
		public boolean run(Calculator calc) {
			String result = "TEST ENCOUNTERED AN ERROR";
			try {
				result = calc.evaluate(question);
			} catch (Error e) {
				System.out.println("Test Case encountered error:");
				System.out.println(e.getMessage());
			}
			boolean passed = result.equals(answer);
			if(passed) {
				System.out.println(question + " = " + answer);
				return true;
			} else {
				System.out.println(question + " != " + answer + " FAILED, WRONG ANSWER: " + result);
				return false;
			}
		}
	}
}
