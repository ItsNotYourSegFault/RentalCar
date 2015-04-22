package rentalcar.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import rentalcar.system.User;

public class CustomerModule extends JFrame implements ActionListener{
	private User user;
	private JPanel hub = new JPanel();
	private JButton browse = new JButton("Browse Cars");
	private JButton reserve = new JButton("Make a Reservation");
	private JButton history = new JButton("View my Rental History");
	private JButton logout = new JButton("Logout");
	
	public CustomerModule(User _user){
		this.user = _user;
		setTitle("Allen Eaton Customer");
		//setSize(500,500);
		setBounds(400, 400, 600, 601);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if(s == browse){
			BrowseModule br = new BrowseModule();
			br.setVisible(true);
		}
		else if(s == reserve){
			MakeReservationModule res = new MakeReservationModule();
			res.setVisible(true);
		}
		else if(s == history){
						
			History h = new History(user);
			h.setVisible(true);
		}
		else if(s == logout){
			new LoginModule().setVisible(true);
			dispose();
		}
		
	}

	/*public static void main(String[] a) {
		new CustomerModule().setVisible(true);
	}*/
}

