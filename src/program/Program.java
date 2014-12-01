package program;
import java.util.Scanner;

import util.Calculator;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator calc = new Calculator();
		
		System.out.println("Expression evaluator by Gareth George");
		System.out.println("\tEnter 'quit' to exit the program.");
		System.out.println("\tEnter 'test' to run test cases.");
		System.out.println("\tYou may use = to assign a result to a variable in future computations.");
		
		while (true) {
			System.out.print("> ");
			String line = sc.nextLine();
			if (line.equals("quit")) {
				break;
			} else if (line.equals("test")) {
				new Tester().tests();
			} else {
				String res = calc.evaluate(line);
				System.out.println(res);
			}
		}

		System.out.println("Exited expression evaluator");
		sc.close();
	}
}
