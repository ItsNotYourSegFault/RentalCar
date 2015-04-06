import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class custHub extends JFrame implements ActionListener, ItemListener {
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
		//browse.setAlignmentY(BOTTOM_ALIGNMENT);
		reserve.setAlignmentX(CENTER_ALIGNMENT);
		//reserve.setAlignmentY(BOTTOM_ALIGNMENT);
		history.setAlignmentX(CENTER_ALIGNMENT);
		//history.setAlignmentY(BOTTOM_ALIGNMENT);
		p.add(browse);
		p.add(reserve);
		p.add(history);
		add(p);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object s = e.getSource();
		if(s == browse){
			
		}
		else if(s == reserve){
			
		}
		else if(s == history){
			
		}
		
	}

	public static void main(String[] a) {
		custHub cust = new custHub();
	}
}
