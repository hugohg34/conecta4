package model;

import java.util.Random;

import types.DiscColor;

public class Turn {
	
	private int currentPlayer;
	private DiscColor[] players = {DiscColor.RED, DiscColor.YELLOW}; 
	
	public Turn(){
		this.currentPlayer = new Random().nextInt(players.length);
	}

	public DiscColor getColor() {
		return players[this.currentPlayer];
	}
	
	public void change() {
		this.currentPlayer = (this.currentPlayer + 1)  % players.length;
	}

}