package graphic.ui.session;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import common.Application;
import common.exception.dev.ErrorConnectionException;
import common.exception.dev.UnknowFactory;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeSession;
import persistent.abstractclass.Account;
import persistent.abstractclass.Session;
import persistent.common.GlobalFactory;
import persistent.factory.AccountFactory;

/**
 * This panel is the UI for the login.
 * Displays two textfields for the login and the password. 
 * And a button to valid
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */

public class LoginUI extends AbstractUI{
	private JButton connection = new JButton();
	private JLabel loginLabel = new JLabel("Login :");
	private JTextField login = new JTextField();
	private JLabel passwordLabel = new JLabel("Password :");
	private JPasswordField password = new JPasswordField();
	private JLabel lblWelcome = new JLabel();
	
	public LoginUI(UIMessage communication, Application app) {
		super(communication, app);
		
		// label welcome
		this.lblWelcome.setText("PolyDIY Manager");
		this.lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.lblWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		this.panel.add(lblWelcome);
		
		this.panel.add(loginLabel);
		
		this.panel.add(login);
		this.login.setColumns(10);
		
		this.panel.add(passwordLabel);
		
		this.panel.add(password);
		this.password.setColumns(10);
		
		this.connection.setText("Connect");
		this.panel.add(connection);
		
		this.connection.addActionListener(this);
		this.panel.setVisible(true);
	}
	
	/**
	 * The ActionPerformed execute the connection.
	 * And create the token.
	 * 
	 * @author Pierre Casati
	 * @version 1.0
	 * @since 2016-03-03
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == this.connection) {
			FacadeSession facade = new FacadeSession();
			
			AccountFactory factory = null;
			Account account = null;
			try {
				factory = GlobalFactory.<AccountFactory>buildFactory(AccountFactory.class);
				account = factory.buildEmptyAccount();
			} catch (UnknowFactory e) {
				System.err.println(e.getMessage());
			} catch (ErrorConnectionException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			if(account != null) {
				account.setLogin(this.login.getText());
				account.setPassword(String.valueOf(this.password.getPassword()));
			}
			
			Session session = null;
			try {
				session = facade.login(account);
				if(session != null) {
					this.communication.shareElement("id_account", session.getID());
					this.update("login");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	@Override
	public void update(String transition) {
		switch(transition) {
		case "login":
			this.app.clearUI();
			this.app.addUI("navBar", BorderLayout.NORTH, this.communication);
			this.app.addUI("account_welcome", BorderLayout.CENTER, this.communication);
			break;
		default:
			break;
		}
	}
}
