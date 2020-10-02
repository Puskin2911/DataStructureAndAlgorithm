package hw2_18001142;

import java.util.Comparator;

public class Card implements Comparable<Card>{
	// @@ Bad card, but now I'm very hungry.
	// @@ One day, I can remake it with Enum @@
	private int rank;
	private String suit;

	public Card(int rank, String suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getRank() {
		return rank;
	}
	public String getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return "Rank: " + rank + "---------Suit: " + suit;
	}

	@Override
	public int compareTo(Card o) {
		if(rank > o.getRank()) return 1;
		else if(rank < o.getRank()) return -1;
		else {
			if(suit.compareTo(o.getSuit()) > 0) return 1;
			else if(suit.compareTo(o.getSuit()) < 0) return -1;
			else return 0;
		}
	}
}

class CompareCard implements Comparator<Card>{
	@Override
	public int compare(Card o1, Card o2) {
		if(o1.getRank() > o2.getRank()) return 1;
		else if(o1.getRank() < o2.getRank()) return -1;
		else {
			if(o1.getSuit().compareTo(o2.getSuit()) > 0) return 1;
			else if(o1.getSuit().compareTo(o2.getSuit()) < 0) return -1;
			else return 0;
		}
	}
}
