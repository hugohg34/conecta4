package types;

public enum DiscColor {
	RED('R'), YELLOW('Y'), NULL('o');

	private char value;

	DiscColor(char value) {
		this.value = value;
	}

	public char getChar() {
		return this.value;
	}
}