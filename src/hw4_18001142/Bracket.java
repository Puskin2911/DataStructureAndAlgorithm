package hw4_18001142;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bracket {
	public static boolean checkSpell(String expression) {
		ArrayStack<Character> stack = new ArrayStack<Character>(100);

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(' || expression.charAt(i) == '[' || expression.charAt(i) == '{') {
				stack.push(expression.charAt(i));
			} else if (expression.charAt(i) == ')') {
				if (stack.isEmpty())
					return false;
				if (stack.top() == '(') {
					stack.pop();
				} else
					return false;
			} else if (expression.charAt(i) == ']') {
				if (stack.isEmpty())
					return false;
				if (stack.top() == '[') {
					stack.pop();
				} else
					return false;
			} else if (expression.charAt(i) == '}') {
				if (stack.isEmpty())
					return false;
				if (stack.top() == '{') {
					stack.pop();
				} else
					return false;
			}
		}

		return stack.isEmpty();
	}

	private static boolean isPriority(String op1, String op2) {
		if (op2.equals("(") || op2.equals(")"))
			return false;
		if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+")) || op2.contentEquals("-"))
			return false;
		else
			return true;
	}

	private static double caculate(String oprator, double num1, double num2) {
		switch (oprator) {
		case "+":
			return num1 + num2;
		case "-":
			return num2 - num1;
		case "*":
			return num1 * num2;
		case "/":
			if (num1 == 0)
				throw new UnsupportedOperationException();
			return num2 / num1;
		}

		return 0;
	}

	public static Double evaluation(String expression) {
		if (!checkSpell(expression))
			throw new IllegalArgumentException("The expression is incorrect!");
		else {
			Stack<Double> operands = new Stack<Double>();
			Stack<String> operators = new Stack<String>();

			Pattern pattern = Pattern.compile("-?\\d+(\\.*\\d*)*|\\(|\\)|\\+|-|\\*|\\/");
			Matcher matcher = pattern.matcher(expression);

			while (matcher.find()) {
				String token = matcher.group();

				if (token.matches("-?\\d+(\\.\\d+)?")) {
					operands.push(Double.valueOf(token));
				} else if (token.matches("\\(")) {
					operators.push(token);
				} else if (token.matches("\\)")) {
					while (!operators.peek().equals("(")) {
						String oprator = operators.pop();
						double num1 = operands.pop();
						double num2 = operands.pop();

						double result = caculate(oprator, num1, num2);
						operands.push(result);
					}
					operators.pop();
				} else if (token.matches("\\+|\\-|\\*|\\/")) {
					while (!operators.empty() && isPriority(token, operators.peek())) {
						String oprator = operators.pop();
						double num1 = operands.pop();
						double num2 = operands.pop();

						double result = caculate(oprator, num1, num2);
						operands.push(result);
					}
					operators.push(token);
				}

				else {
					throw new IllegalStateException("Operand is not valid: " + token);
				}
			}

			System.out.println(operands);

			while (!operators.empty()) {
				String oprator = operators.pop();
				double num1 = operands.pop();
				double num2 = operands.pop();

				double result = caculate(oprator, num1, num2);
				operands.push(result);
			}

			return operands.pop();
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String expression = scanner.nextLine();

		scanner.close();

		System.out.println(evaluation(expression));
	}
}
