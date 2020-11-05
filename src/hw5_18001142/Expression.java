package hw5_18001142;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
	private String expression;

	public Expression(String expression) {
		this.expression = expression;
	}

	public boolean isValidBracket() {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(' || expression.charAt(i) == '[' || expression.charAt(i) == '{') {
				stack.push(expression.charAt(i));
			} else if (expression.charAt(i) == ')') {
				if (stack.isEmpty())
					return false;
				if (stack.peek() == '(') {
					stack.pop();
				} else
					return false;
			} else if (expression.charAt(i) == ']') {
				if (stack.isEmpty())
					return false;
				if (stack.peek() == '[') {
					stack.pop();
				} else
					return false;
			} else if (expression.charAt(i) == '}') {
				if (stack.isEmpty())
					return false;
				if (stack.peek() == '{') {
					stack.pop();
				} else
					return false;
			}
		}

		return stack.isEmpty();
	}

	public boolean isValid() {
		// Check Bracket
		if (isValidBracket() == false)
			return false;

		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?|\\(|\\)|\\+|\\-|\\*|\\/");
		Matcher matcher = pattern.matcher(expression);

		// Get tokens
		ArrayList<String> tokens = new ArrayList<String>();
		String clearStr = "";
		while (matcher.find()) {
			String token = matcher.group();
			tokens.add(token);
			clearStr += token;
		}
		// Check valid tokens
		if (!clearStr.equals(expression.replaceAll("\\s+", "")))
			return false;

		// Check operand
		for (int i = 0; i < tokens.size(); i++) {
			// Check * and /
			if (tokens.get(i).matches("\\*|\\/")) {
				// First or last
				if (i == 0 || i == tokens.size() - 1)
					return false;
				// Before must not be + or -
				if (tokens.get(i - 1).matches("\\+|\\-|\\("))
					return false;
				// After must not be + or -
				int j = i + 1;
				while (j < tokens.size() && !tokens.get(j).matches("-?\\d+(\\.\\d+)?|\\(")) {
					if (tokens.get(j).matches("\\*|\\/|\\)"))
						return false;
					j++;
				}
				if (j == tokens.size() - 1)
					return false;
			}
			// Check - and +
			if (tokens.get(i).matches("\\+|\\-")) {
				if (i == tokens.size() - 1)
					return false;
				int j = i + 1;
				while (j < tokens.size() && !tokens.get(j).matches("-?\\d+(\\.\\d+)?|\\(")) {
					if (tokens.get(j).matches("\\*|\\/|\\)"))
						return false;
					j++;
				}
				if (j == tokens.size() - 1)
					return false;
			}
		}

		return true;
	}

	public String[] getTokens() {
		if (isValid() == false)
			return null;

		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?|\\(|\\)|\\+|\\-|\\*|\\/");
		Matcher matcher = pattern.matcher(expression);

		// Get tokens
		ArrayList<String> tokens = new ArrayList<String>();
		while (matcher.find()) {
			String token = matcher.group();
			if (tokens.isEmpty()) {
				tokens.add(token);
				continue;
			}
			String preToken = tokens.get(tokens.size() - 1);
			if (token.matches("\\+")) {
				if (preToken.matches("-?\\d+(\\.\\d+)?|\\("))
					tokens.add(token);
			} else if (token.matches("\\-")) {
				if (preToken.matches("\\+"))
					tokens.set(tokens.size() - 1, "-");
				else if (preToken.matches("\\-"))
					tokens.set(tokens.size() - 1, "+");
				else
					tokens.add(token);
			} else
				tokens.add(token);
		}
		return tokens.toArray(new String[tokens.size()]);
	}

	private static boolean isPriority(String op1, String op2) {
		if (op1.matches("\\+|\\-") && op2.matches("\\*|\\/"))
			return false;
		return true;
	}

	public static ArrayList<String> innerToPost(String[] tokens) {
		ArrayList<String> result = new ArrayList<String>();

		Stack<String> stack = new Stack<String>();

		for (String token : tokens) {
			if (token.matches("-?\\d+(\\.\\d+)?")) {
				result.add(token);
			}
			if (token.matches("\\(")) {
				stack.push(token);
			}
			if (token.matches("\\)")) {
				while (!stack.peek().equals("(")) {
					result.add(stack.pop());
				}
				stack.pop();
			}
			if (token.matches("\\+|\\-|\\*|\\/")) {
				while (!stack.empty() && stack.peek().matches("\\+|\\-|\\*|\\/") && isPriority(stack.peek(), token)) {
					result.add(stack.pop());
				}
				stack.push(token);
			}
		}

		while (!stack.empty()) {
			result.add(stack.pop());
		}

		return result;
	}

	public static BinaryTreeNode<String> buildTree(String[] tokens) {
		Stack<BinaryTreeNode<String>> stack = new Stack<BinaryTreeNode<String>>();

		for (int i = 0; i < tokens.length; i++) {
			BinaryTreeNode<String> node = new BinaryTreeNode<String>(tokens[i]);
			if (tokens[i].matches("-?\\d+(\\.\\d+)?")) {
				stack.push(node);
			}
			if (tokens[i].matches("\\+|\\-|\\*|\\/")) {
				node.setRight(stack.pop());
				node.setLeft(stack.pop());
				stack.push(node);
			}
		}

		return stack.pop();
	}

	public static String getExpression(BinaryTreeNode<String> tree) {
		String result = "";
		if (tree != null) {
			if (tree.getElement().matches("\\*|\\/")) {
				if (!tree.getLeft().getElement().matches("-?\\d+(\\.\\d+)?")
						&& !tree.getRight().getElement().matches("-?\\d+(\\.\\d+)?")) {
					result = "(" + getExpression(tree.getLeft()) + ")" + tree.getElement() + "("
							+ getExpression(tree.getRight()) + ")";
				} else if (tree.getLeft().getElement().matches("-?\\d+(\\.\\d+)?")
						&& !tree.getRight().getElement().matches("-?\\d+(\\.\\d+)?")) {
					result = getExpression(tree.getLeft()) + tree.getElement() + "(" + getExpression(tree.getRight())
							+ ")";
				} else if (!tree.getLeft().getElement().matches("-?\\d+(\\.\\d+)?")
						&& tree.getRight().getElement().matches("-?\\d+(\\.\\d+)?")) {
					result = "(" + getExpression(tree.getLeft()) + ")" + tree.getElement()
							+ getExpression(tree.getRight());
				} else {
					result = getExpression(tree.getLeft()) + tree.getElement() + getExpression(tree.getRight());
				}

			} else if(tree.getElement().matches("\\-")) {
				if (tree.getRight().getElement().matches("\\+|\\-")) {
					result = getExpression(tree.getLeft()) + tree.getElement() + "(" + getExpression(tree.getRight())
					+ ")";
				}
				else {
					result = getExpression(tree.getLeft()) + tree.getElement() + getExpression(tree.getRight());
				}
			}
			else {
				result = getExpression(tree.getLeft()) + tree.getElement() + getExpression(tree.getRight());
			}
		}

		return result;
	}

	public static double caculate(Double value1, Double value2, String op) {
		if (op.equals("+")) {
			return Double.valueOf(value1) + Double.valueOf(value2);
		}
		if (op.equals("-")) {
			return Double.valueOf(value1) - Double.valueOf(value2);
		}
		if (op.equals("*")) {
			return Double.valueOf(value1) * Double.valueOf(value2);
		}
		if (op.equals("/")) {
			return Double.valueOf(value1) / Double.valueOf(value2);
		}
		return 0;
	}

	public static double caculate(BinaryTreeNode<String> tree) {
		if (tree != null) {
			if (tree.left(tree) != null && tree.right(tree) != null) {
				return caculate(caculate(tree.getLeft()), caculate(tree.getRight()), tree.getElement());
			}
			if (tree.getElement().matches("-?\\d+(\\.\\d+)?")) {
				return Double.valueOf(tree.getElement());
			} else {
				throw new IllegalArgumentException("Tree is incorrect");
			}
		}

		else {
			throw new IllegalArgumentException("Tree is null");
		}
	}

	public static void main(String[] args) {
		String[] tokens = { "(", "6", "/", "2", "+", "3", ")", "*", "(", "7", "-", "4", ")", "-", "(", "2", "-", "3", ")" };
//		String[] tokens = { "(", "6", "/", "2", "+", "3", ")", "*", "(", "7", "-", "4", ")"};

		ArrayList<String> list = innerToPost(tokens);

		String[] postFix = (String[]) list.toArray(new String[list.size()]);

		BinaryTreeNode<String> tree = buildTree(postFix);

		tree.printTree();
		System.out.println(getExpression(tree));
		System.out.println();
		System.out.println(caculate(tree));

//		Scanner scanner = new Scanner(System.in);
//
//		String expression = scanner.nextLine();
//		scanner.close();
//
//		Expression ex = new Expression(expression);
//		
////		System.out.println(ex.isValid());
//		
//		String tokens[] = ex.getTokens();
//		
//		for(int i = 0; i < tokens.length; i++) {
//			System.out.print(tokens[i] + " ");
//		}

	}
}
