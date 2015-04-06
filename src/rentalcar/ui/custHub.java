package rentalcar.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class custHub extends JFrame implements ActionListener{
	public JPanel p = new JPanel();
	public JButton browse = new JButton("Browse Cars");
	public JButton reserve = new JButton("Make a Reservation");
	public JButton history = new JButton("View my Rental History");
	public custHub(){
		setTitle("Allen Eaton Customer");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		browse.addActionListener(this);
		reserve.addActionListener(this);
		history.addActionListener(this);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		browse.setAlignmentX(CENTER_ALIGNMENT);
		reserve.setAlignmentX(CENTER_ALIGNMENT);
		history.setAlignmentX(CENTER_ALIGNMENT);
		p.add(browse);
		p.add(reserve);
		p.add(history);
		add(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object s = e.getSource();
		if(s == browse){
			new BrowseModule().setVisible(true);
		}
		else if(s == reserve){
			new ReservationModule().setVisible(true);
		}
		else if(s == history){
			new History().setVisible(true);
		}
		
	}

	public static void main(String[] a) {
		new custHub().setVisible(true);
	}
}
