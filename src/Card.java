public class Card {
	
	String shape; //Spade //Hearts //Diamond //Clubs
	String face; //eg. S6, HK, DA
	int value; //eg. 2,3,4,5,6,7,8,9,10,11,12,13,14
	
	Card(String s, int v) {
		shape = s;
		value = v;
		face = s.substring(0, 1);
		
			if (value == 11)
				face = face + "J ";
			else if (value == 12)
				face = face + "Q ";
			else if (value == 13)
				face = face + "K ";
			else if (value == 14)
				face = face + "A ";
			else if (value == 10)
				face = face + value;
			else 
				face = face + value + " ";
	}
}
