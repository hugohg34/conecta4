package view;

public class ErrorView {
	
	private static ErrorView instance;

	public static ErrorView getInstanse() {
		if(instance == null) {
			instance = new ErrorView();
		}
		return instance;
	}

	public void show(String string) {
		System.out.println("Error " + string);
	}

}
