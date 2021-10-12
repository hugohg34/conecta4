package view;

import java.util.List;

import model.Board;
import model.DiscDrop;
import utils.Console;

public class BoardView {

	private Board board;

	public void show() {
		assert (board != null);
		Console console = Console.getInstance();
		
		console.println(getSeparator());
		for(int rowIndex = Board.ROWS-1; rowIndex >= 0; rowIndex--) {
			for(int colIndex = 0; colIndex < Board.COLUMNS; colIndex++) {
				//console.printError("colIndex: " + colIndex);
				List<DiscDrop> columList = board.getDiscDropList().get(colIndex);
				char disc = 'o';
				if(columList.size() > rowIndex) {
					disc = columList.get(rowIndex).getColor().getChar();
				}
				console.print(String.format("| %s |", disc));
			}
			Console.getInstance().println("");
		}
		console.println(getSeparator());
	}
	
	private String getSeparator() {
		return String.format("|%33s|", "").replace(" ", "-");
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
