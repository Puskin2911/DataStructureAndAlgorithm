package hw3_18001142;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private int count;

	public WordCount(String word) {
		this.word = word;
		this.count = 1;
	}

	@Override
	public boolean equals(Object obj) {
		return word.equals(((WordCount) obj).word);
	}

	@Override
	public String toString() {
		return word + ": " + count + " times\n";
	}

	public static SimpleArrayList<WordCount> getWordCount(String words) {
		SimpleArrayList<WordCount> list = new SimpleArrayList<WordCount>();
		words = words.toLowerCase();

		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(words);

		while (matcher.find()) {
			String word = matcher.group();
			WordCount wordObject = new WordCount(word);
			if (list.isContain(wordObject) == false) {
				list.add(wordObject);
			} else {
//				wordObject = list.get(wordObject);
				wordObject.setCount(wordObject.getCount() + 1);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		File file = new File("data.txt");

		Scanner scanner;
		String words = "";
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				words += scanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

//		Scanner scanner = new Scanner(System.in);
//		String words = scanner.nextLine();

		SimpleArrayList<WordCount> list = getWordCount(words);
//		list.printArray();
	}

}
