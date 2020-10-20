package hw4_18001142;

import java.util.Scanner;

public class Palindrome {
	public static boolean isPalindrome(String string) {
		LinkedListStack<Character> stack = new LinkedListStack<Character>();
		LinkedListQueue<Character> queue = new LinkedListQueue<Character>();

		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (Character.toString(c).matches("\\w")) {
				stack.push(string.charAt(i));
				queue.enqueue(string.charAt(i));
			}
		}

		while (!stack.isEmpty() && !queue.isEmpty()) {
			if (stack.pop() != queue.dequeue())
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String string = scanner.nextLine();

		scanner.close();

		System.out.println(isPalindrome(string));
	}
}
