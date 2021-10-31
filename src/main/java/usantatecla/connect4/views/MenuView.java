package usantatecla.connect4.views;

public interface MenuView {

	void writeIntro();

	void writeOption(int code, String value);

	int readOption();

}
