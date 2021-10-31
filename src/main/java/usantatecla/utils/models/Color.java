package usantatecla.utils.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Color {

	RED, YELLOW, NULL;

	public static Color get(int ordinal) {
		assert ordinal >= 0 && ordinal < Color.NULL.ordinal();
		return Color.values()[ordinal];
	}

	public static Color get(char character) {
		for (Color color : Color.values()) {
			if (color.name().charAt(0) == character) {
				return color;
			}
		}
		return Color.NULL;
	}

	public boolean isNull() {
		return this == Color.NULL;
	}

	public static List<Color> getAll() {
		List<Color> colors = new ArrayList<>(Arrays.asList(Color.values()));
		colors.remove(Color.NULL);
		return colors;
	}

	public String print() {
		if (isNull())
			return " ";
		return this.name().charAt(0) + "";
	}

}
