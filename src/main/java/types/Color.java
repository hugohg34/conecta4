package types;

public enum Color {
	RED('R'), YELLOW('Y');

	private char value;

	Color(char value) {
		this.value = value;
	}

	public char getChar() {
		return this.value;
	}
}