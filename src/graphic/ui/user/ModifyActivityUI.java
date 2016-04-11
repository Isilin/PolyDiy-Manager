package graphic.ui.user;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import common.Application;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeActivityPanel;

public class ModifyActivityUI  extends AbstractUI{
	private JTextField title = new JTextField();
	private JButton update = new JButton("Update");
	private JButton delete = new JButton("Delete");
	private JTextArea description = new JTextArea();
	private JTextField category = new JTextField();
	
	private FacadeActivityPanel facade = new FacadeActivityPanel();

	public ModifyActivityUI(UIMessage communication, Application app) throws Exception {
		super(communication, app);
		
		this.panel.setLayout(null);
		
		facade.loadActivity((int)this.communication.getElement("id_activity"));

		this.title.setBounds(42, 2, 150, 23);
		this.title.setText(facade.getActivity().getTitle());
		this.panel.add(title);
		
		// add update button
		this.update.setBounds(202 , 2, 150, 23);
		this.panel.add(update);
		this.update.addActionListener(this);
		
		// add delete button
		this.delete.setBounds(360, 2, 150, 23);
		this.panel.add(delete);
		this.delete.addActionListener(this);
		
		this.description.setText(facade.getActivity().getDescription());
		this.description.setBounds(15 , 30, 300, 100);
		this.description.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		this.panel.add(this.description);
		
		this.category.setBounds(320, 30, 150, 23);
		this.category.setText(facade.getActivityCategory().getLabel());
		this.panel.add(category);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Update")) {
			try {
				this.facade.updateActivity(this.title.getText(), this.description.getText(), this.facade.getActivityCategory().getID(), 
										(int)this.communication.getElement("id_user"));
				this.update("activityPanel");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(arg0.getActionCommand().equals("Delete")) {
			try {
				this.facade.deleteActivity();
				this.update("activityPanel");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void update(String transition) {
		// TODO Auto-generated method stub
		
	}

}
