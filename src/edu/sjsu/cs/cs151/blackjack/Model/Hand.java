package edu.sjsu.cs.cs151.blackjack.Model;

import java.util.ArrayList;

import edu.sjsu.cs.cs151.blackjack.Model.Card.Rank;


/**
 * Hand class aggregates the cards owned by a player.
 * Cards are aggregated as a list
 */
public class Hand {
	
	/**
	 * Computes and returns the value of a given hand.
	 * @return handValue  sum of each card's rank in a hand
	 */
	public int getValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getRankAsInt();
		}
		if(handValue > 21) { // if hand contains aces and is over 21 transform them to low ace
			for (Card card : hand) {
				if(card.getRank() == Rank.ACE && handValue > 21) {
					handValue -= 10;
				}
			}
		}
		
		return handValue;
	}
	
	
	/**
	 * Adds a card to the hand.
	 * @param card  the card to add
	 */
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	/**
	 * Returns the hand as a list of strings.
	 * @return hand  list of card strings
	 */
	public ArrayList<String> toList() {
		ArrayList<String> cardList = new ArrayList<>();
		for(Card card : hand) {
			cardList.add(card.toString());
		}
		
		return cardList;
	}
	
	/**
	 * Returns a string representation of a hand's cards.
	 */
	public String toString() {
		// Empty hands return an empty string
		if (this.hand.isEmpty())
			return "";
		
		StringBuilder handOfCards = new StringBuilder();
		for (Card card : hand)
			handOfCards.append(card.toString() + ", ");
		// Trim the last comma and whitespace
		handOfCards.delete(handOfCards.length()-2, handOfCards.length());
		
		return handOfCards.toString();
	}
	
	/**
	 * Returns the first card in a hand.
	 */
	public Card getFirst() {
		if (hand.size() == 0) {
			return null;
		}
		return hand.get(0);
	}
	
	private ArrayList<Card> hand = new ArrayList<>();
}
