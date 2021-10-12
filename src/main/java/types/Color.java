package types;

public enum Color {
	RED('R'), YELLOW('Y');

	private char value;

	Color(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}