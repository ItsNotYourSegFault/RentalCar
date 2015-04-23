package rentalcar.ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import rentalcar.system.User;

public class SalesModule extends JFrame implements ActionListener{

	private User user = new User();
	private JPanel hub = new JPanel();
	private JButton view = new JButton("View Reservations");
	private JButton reserve = new JButton("Make a Reservation");
	private JButton logout = new JButton("Logout");

	public SalesModule(User _user){

		this.user = _user;
		setTitle("Allen Eaton Sales Representative");
		setBounds(800,400,250,200);
		hub.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridx = 3;
        gbc.gridy = 1;
		hub.add(view,gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
		hub.add(reserve,gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
		hub.add(logout,gbc);
		add(hub);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if(s == view){
		}
		else if(s == reserve){
		}
		else if(s == logout){
			new LoginModule().setVisible(true);
			dispose();
		}
		
	}

	
}
