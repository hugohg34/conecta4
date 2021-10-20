package view;

import controller.ControllersVisitor;

public abstract class ViewFactory implements ControllersVisitor{
	
	protected StartView startView;
	protected PlayView playView;
	protected ResumeView resumeView;

}