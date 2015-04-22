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
		//setSize(500,500);
		setBounds(200,200,300,301);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		logout.addActionListener(this);
		view.addActionListener(this);
		reserve.addActionListener(this);
		hub.setLayout(new BoxLayout(hub, BoxLayout.PAGE_AXIS));
		logout.setAlignmentX(CENTER_ALIGNMENT);
		view.setAlignmentX(CENTER_ALIGNMENT);
		reserve.setAlignmentX(CENTER_ALIGNMENT);
		hub.add(view);
		hub.add(reserve);
		hub.add(logout);
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
