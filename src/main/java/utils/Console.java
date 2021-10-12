package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
	
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	
	public read() {
		String input = null;
		do {
			input = this.bufferedReader.readLine();
		}while(input != null);
		return input;
			

	}
	
	public String readString(String title) {
		String input = null;
		boolean ok = false;
		do {
			this.write(title);
			try {
				input = this.bufferedReader.readLine();
				ok = true;
			} catch (Exception ex) {
				this.writeError("characte string");
			}
			assert ok;
		} while (!ok);
		return input;
	}


}
