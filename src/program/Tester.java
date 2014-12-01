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
	
	// input is a string expression like: "1/2 + 3/4"
	// output is the fully formatted string like: "1_1/4"
	private String doMath(String input) {
		return calc.evaluate(input);
	}

	public void tests() {
		// full requirements:
		test("1/2 + 2/3", "1_1/6");
		test("10 / -5", "-2");
		test("-1/2 - 2", "-2_1/2");
		test("10/11 * 5/8", "25/44");
		test("1/100 / -1_5/10", "-1/150");
		
		test("1/4 + 1_1/2", "1_3/4");
		test("8/4 + 2", "4");
		test("-1 * -1/2", "1/2");
		test("11/17 - -1/17", "12/17");
		test("1/2 + 2/3", "1_1/6");
		
		// extra credit (more than 2 operands):
		test("1/2 + 2/3 + 3/4", "1_11/12");
		test("5/9 - 2/11 - 1/20", "641/1980");
		
		// extra credit (order of operations):
		test("1/2 + 2/3 * 3/4 - 1/2", "1/2");
		test("1/2 * 3/4 + 1/2 * 1/2", "5/8");
		test("2 + 4 * 3 - 1", "13");
		test("2 + 4 * 3 - 1 + 10 / -5", "11");
		test("5 / 10 * 2", "1");
		test("5 * 10 / 2", "25");

		// extra credit (handle invalid input):
		test("1 + + 1/2", "INVALID");
		test("2_0/1 + 2_0/10", "4");
		test("Hazen Rocks!", "INVALID");
		test("abc + 5", "INVALID");
	}

	public void test(String input, String expected) {
		try { // don't worry about understanding try
			String result = doMath(input);
	        if(result.equals(expected)) {
	            System.out.println(input+" = "+expected);
	        } else {
	            System.out.println(input+" FAILED: "+result+ " != " + expected);
	        }
		} catch(Exception e) { // don't worry about understanding catch and Exception
			System.out.println(input+" FAILED: "+e.getClass());
		}
	}
}
