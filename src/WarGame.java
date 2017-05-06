import java.util.ArrayList;
import java.util.Collections;

public class WarGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Card> Deck = new ArrayList<Card>();
		DeckCreator D = new DeckCreator();
		Deck = D.createDeck(); //create a deck of 52 cards
		Collections.shuffle(Deck);                            /////*****
		
		ArrayList<Card> Deck1, Deck2, Play1, Play2, Won;
		Deck1 = new ArrayList<Card>(); //player one's deck
		Deck2 = new ArrayList<Card>(); //player two's deck
		Play1 = new ArrayList<Card>();	//player one's playing cards
		Play2 = new ArrayList<Card>();	//player two's playing cards 
		Won = new ArrayList<Card>();	//temporary list where cards get shuffled before going to any player's deck
		
		int count = 0;	//number of turns played before a result is reached
		
		//Deal Cards
		System.out.println("Deck Size:" + Deck.size());
		
		for (int i=0; i<Deck.size(); i++)	
		{
			if(i%2==0)
			{
				Deck1.add(Deck.get(i));
			}
			else
			{
				Deck2.add(Deck.get(i));
			}
		}
		
		
		System.out.println("Player 1's Deck Size:" + Deck1.size());
		System.out.println("Player 2's Deck Size:" + Deck2.size());
		
		System.out.println("\nPlayers     Scoreline");
		System.out.println("P1" + "  - " + "P2" + "    >> " + Deck1.size() + "/" + Deck2.size());
		System.out.println("--------------------");
		int war = 0;
		String str;
		while(Deck1.size() > 0 && Deck2.size() > 0)
		{
			Play1.add(Deck1.remove(0)); //player one places first card from his/her deck into the playing pile
			Play2.add(Deck2.remove(0)); //player two places first card from his/her deck into the playing pile
			count++;
			str = (Play1.get(Play1.size()-1).face + " - " + Play2.get(Play2.size()-1).face); //string maintained to display the cards at the top of the playing pile
			
			if (war > 0)
			{
				war--;
				System.out.println(str + "   >> Facedown");
			}
			else
			{
				//scenario 1: player one has higher value card
				if (Play1.get(Play1.size()-1).value > Play2.get(Play2.size()-1).value)
				{
					Won.addAll(Play1);
					Won.addAll(Play2);
					Collections.shuffle(Won);
					Deck1.addAll(Won);
					Play1.clear();
					Play2.clear();
					Won.clear();
					str = str + "   >> " + Deck1.size() + "/" + Deck2.size();
				}
				
				//scenario 2: player two has higher value card
				else if (Play1.get(Play1.size()-1).value < Play2.get(Play2.size()-1).value)
				{
					Won.addAll(Play1);
					Won.addAll(Play2);
					Collections.shuffle(Won);
					Deck2.addAll(Won);
					Play1.clear();
					Play2.clear();
					Won.clear();
					str = str + "   >> " + Deck1.size() + "/" + Deck2.size();
				}
				
				//scenario 3: both players have same value card
				else if (Play1.get(Play1.size()-1).value == Play2.get(Play2.size()-1).value)
				{
					war++;
					str = str + "   >> WAR!!";
				}
				System.out.println(str);
			}
		}
		
		if (Deck1.size() == 0 && Deck2.size() > 0)
		{
			System.out.println("\nPlayer 2 wins!");	
		}
		else if (Deck1.size() > 0 && Deck2.size() == 0)
		{
			System.out.println("\nPlayer 1 wins!");
		}
		else if (Deck1.size() == 0 && Deck2.size() == 0)
		{
			System.out.println("\nGame Tied!");	
		}
		
		System.out.println("The game finished in " + count + " chances.");
	}

}
