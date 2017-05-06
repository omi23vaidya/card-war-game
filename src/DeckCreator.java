import java.util.ArrayList;

public class DeckCreator {

	ArrayList<Card> PlayingCards = new ArrayList<Card>();
	
	public ArrayList<Card> createDeck()
	{
		String[] shape = {"Spade","Hearts","Diamond","Clubs"};
		
		
		for(int c=0; c<4; c++)
		{
				for(int v=2; v<15; v++)
				{
					Card newCard = new Card(shape[c], v);
					PlayingCards.add(newCard);
				}
		}
	
		return PlayingCards;
	}
	
}
