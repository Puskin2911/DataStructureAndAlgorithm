package hw2_18001142;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CardGame {
	
	public Card[] cards;
	
	public CardGame(Card[] cards) {
		this.cards = cards;
	}
	
	public static Card[] createCard() {
		Card[] cards = new Card[52];
		String[] suits = {"2Diamond", "3Club", "1Heart", "4Spade"};
		int slot = 0;
		for(int rank = 1; rank <= 13; rank++) {
			for(String suit : suits) {
				cards[slot] = new Card(rank, suit);
				slot++;
			}
		}
		
		return cards;
	}
	
	public void printCard() {
		for(Card card : cards) {
			System.out.println(card.toString());
		}
	}
	
	// Fisher–Yates shuffle
	public void shuffleDeck() {
		Random random = new Random();
		for(int i = cards.length - 1; i > 0; i--) {
			int r = random.nextInt(i + 1);
			if(r != i) {
				Card temp = cards[r]; 
	            cards[r] = cards[i]; 
	            cards[i] = temp; 
			}
		}
	}
	
	public static void main(String[] args) {
		CardGame game = new CardGame(createCard());
		
		game.printCard();
		
		// Generic sort (Bubble, Selection, Insertion)
		GenericSort<Card> sortCard = new GenericSort<Card>();
//		sortCard.bubbleSort(game.cards);
//		sortCard.selectionSort(game.cards);
//		sortCard.insertionSort(game.cards);
		
		// Arrays.sort
//		CompareCard compare = new CompareCard();
//		Arrays.sort(game.cards, compare);
		
		game.shuffleDeck();
		
		game.printCard();
	}
}
