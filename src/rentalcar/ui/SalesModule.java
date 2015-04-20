package rentalcar.ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SalesModule extends JFrame implements ActionListener{
	public JPanel hub = new JPanel();
	public JButton view = new JButton("View Reservations");
	public JButton reserve = new JButton("Make a Reservation");
	public JButton logout = new JButton("Logout");
	public SalesModule(){
		setTitle("Allen Eaton Sales Representative");
		setSize(500,500);
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
			new BrowseModule().setVisible(true);
			dispose();
		}
		
	}

	public static void main(String[] a) {
		new SalesModule().setVisible(true);
	}
}
