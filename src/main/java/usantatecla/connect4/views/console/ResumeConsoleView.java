package usantatecla.connect4.views.console;

import usantatecla.connect4.models.Message;
import usantatecla.connect4.views.ResumeView;
import usantatecla.utils.views.YesNoDialog;

class ResumeConsoleView implements ResumeView {

	@Override
	public boolean read() {
		YesNoDialog isResumed = new YesNoDialog();
		isResumed.read(Message.RESUME.toString());
		return isResumed.isAffirmative();
	}

}
