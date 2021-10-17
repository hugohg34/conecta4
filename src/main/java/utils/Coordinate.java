package utils;

public class Coordinate {

	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

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
	
	public Coordinate getDisplaced(CardinalDirection direction, int displacement) {
		return new Coordinate(this.x + (direction.getX() * displacement), this.y + (direction.getY() *displacement));
	}
	
	public Coordinate[] getNeighbords(CardinalDirection direcion, int neighbors) {
		Coordinate[] neighbordsArray = new Coordinate[neighbors];
		for (int i = 0; i < neighbors; i++) {
			neighbordsArray[i] = getDisplaced(direcion, i);
		}
		return neighbordsArray;
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean inCuadrant(Coordinate coordinate) {		
		boolean a = coordinate.getX() >= this.x;
		boolean b = coordinate.getX() <= this.y;
		return a && b;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	      return false;
	    }

	    Coordinate coordinate = (Coordinate)obj;
		return this.x == coordinate.getX() && this.y == coordinate.getY();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.x;
		result = prime * result + this.y;
		return result;
	}
	
}