package rentalcar.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import rentalcar.system.User;

public class AdminModule extends JFrame implements ActionListener{

	private User user = new User();
	private JPanel hub = new JPanel();
	private JButton viewEditReservations = new JButton("View/Edit Reservations");
	private JButton addRemoveUsers = new JButton("Add/Remove Users");
	private JButton logout = new JButton("Logout");

	public AdminModule(User _user){

		this.user = _user;
		JLabel header = new JLabel("Welcome " + this.user.FirstName());	
		setTitle("Allen Eaton Administrator");
		setBounds(800,400,250,200);
		viewEditReservations.addActionListener(this);
		addRemoveUsers.addActionListener(this);
		logout.addActionListener(this);
		hub.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
		hub.add(header, gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
		hub.add(viewEditReservations,gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
		hub.add(addRemoveUsers,gbc);
        gbc.gridx = 3;
        gbc.gridy = 5;
		hub.add(logout,gbc);
		add(hub);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object s = e.getSource();
		if(s == viewEditReservations){
			//new ManagerHistory(user).setVisible(true);
			
		}
		else if(s == addRemoveUsers){
			//new UserManagement(user).setVisible(true);
			
		}
		else if(s == logout){
			
			new LoginModule().setVisible(true);
			dispose();
		}
		
	}

	
}
