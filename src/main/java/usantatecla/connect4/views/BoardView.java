package usantatecla.connect4.views;

import java.util.ArrayList;
import java.util.List;

import usantatecla.utils.models.Color;

public abstract class BoardView {
	
	protected List<Color> colors;

    public BoardView() {
        this.colors = new ArrayList<>();
    }

    public void set(Color color) {
        this.colors.add(color);
    }

	public abstract void write();

}