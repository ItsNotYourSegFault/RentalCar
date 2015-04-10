package rentalcar.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import rentalcar.system.User;

public class CustomerModule extends JFrame implements ActionListener{
	private User user = new User();
	public JPanel hub = new JPanel();
	public JButton browse = new JButton("Browse Cars");
	public JButton reserve = new JButton("Make a Reservation");
	public JButton history = new JButton("View my Rental History");
	public JButton logout = new JButton("Logout");
	public CustomerModule(){
		setTitle("Allen Eaton Customer");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		logout.addActionListener(this);
		browse.addActionListener(this);
		reserve.addActionListener(this);
		history.addActionListener(this);
		hub.setLayout(new BoxLayout(hub, BoxLayout.PAGE_AXIS));
		logout.setAlignmentX(CENTER_ALIGNMENT);
		browse.setAlignmentX(CENTER_ALIGNMENT);
		reserve.setAlignmentX(CENTER_ALIGNMENT);
		history.setAlignmentX(CENTER_ALIGNMENT);
		hub.add(logout);
		hub.add(browse);
		hub.add(reserve);
		hub.add(history);
		add(hub);
	}

	public void setUser(User u) {
		user = u;
	}

	User getUser() {
		return user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if(s == browse){
			BrowseModule br = new BrowseModule();
			br.setVisible(true);
		}
		else if(s == reserve){
			ReservationModule res = new ReservationModule();
			res.setVisible(true);
		}
		else if(s == history){
			History h = new History();
			h.createAndShowGUI();
		}
		else if(s == logout){
			dispose();
		}
		
	}

	public static void main(String[] a) {
		new CustomerModule().setVisible(true);
	}
}

