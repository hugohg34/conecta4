package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

	private static Console instance;
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	private Console() {}

	public static Console getInstance() {
		if (instance == null) {
			instance = new Console();
		}
		return instance;
	}

	public String readString(String label) {
		String input = null;
		do {
			print(label + ": ");
			try {
				input = this.bufferedReader.readLine();
			} catch (Exception e) {
				inputFormatError("String");
			}
		} while (input == null);
		return input;
	}

	public void print(String string) {
		System.out.print(string); // NOSONAR
	}

	public void println(String string) {
		System.out.println(string); // NOSONAR
	}

	private void inputFormatError(String string) {
		printError("Error input required " + string + " value.");
	}

	public void printError(String string) {
		System.err.println(string); // NOSONAR
	}

	public int readInt(String label) {
		Integer input = null;
		do {
			try {
				input = Integer.valueOf(readString(label));
			} catch (Exception e) {
				inputFormatError("integer");
			}
		} while (input == null);
		return input.intValue();
	}

}