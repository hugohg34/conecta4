package utils;
/*
	 	 	norte/ North
				  |
	North-West \  |  / North-East
				\ | /
Oeste/West ______\|/_______ Estes/East
		 		 /|\
				/ | \
	 South-West/  |  \ South-East
	  			  |
		 	  Sur/South

*/
public enum CardinalDirection {
	NORTH(0, 1),
	NORTH_EAST(1, 1),
	EAST(1, 0),
	SOUTH_EAST(1, -1),
	SOUTH(0, -1),
	SOUTH_WEST(-1, -1),
	WEST(-1, 0),
	NORTH_WEST(-1, 1);
	
	private int x;
	private int y;
	
	private CardinalDirection(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
