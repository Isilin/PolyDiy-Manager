package graphic.engine;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import common.Application;

public abstract class AbstractUI implements ActionListener {
	protected JPanel panel = new JPanel();
	protected UIMessage communication = new UIMessage();
	protected Application app = null;
	
	public AbstractUI(UIMessage communication, Application app) {
		this.communication = communication;
		this.app = app;
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	public UIMessage getMessage() {
		return this.communication;
	}
	
	public abstract void update(String transition);
}
