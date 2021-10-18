package view;

import controller.StartController;

public abstract class ViewFactory {
	
	protected StartView startView;
	protected PlayView playView;
	protected ResumeView resumeView;

	public void visit(StartController startController) {
		this.startView.interact(startController);
	}

}