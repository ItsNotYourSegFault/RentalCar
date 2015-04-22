package rentalcar.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.*;

import rentalcar.web.JSONRequest;
import rentalcar.system.Database;
import rentalcar.data.FormObject;
import org.json.JSONObject;
import org.json.JSONArray;


public class BrowseModule extends JFrame implements ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Database db = new Database();
	private String[] Locations = 
	{
		"Atchison",
		"Belton",
		"Emporia",
		"Hiawatha",
		"Kansas City",
		"Lawrence",
		"Leavenworth",
		"Manhattan",
		"Platte City",
		"St. Joseph",
		"Topeka",
		"Warrensburg"
	};
	private String[] VehicleListStr = 
	{
		"Economy - $45/day or $300/week",
		"Compact - $50/day or $325/week",
		"Standard - $60/day or $400/week",
		"Premium - $65/day or $435/week",
		"Small SUV - $70/day or $475/week",
		"Standard SUV - $75/day or $500/week",
		"Minivan - $85/day or $575/week"
	};
	private JList<String> VehicleList;
	private JList<String> LocationsList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowseModule frame = new BrowseModule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BrowseModule() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel LocationsPanel = new JPanel();
		LocationsPanel.setBorder(new TitledBorder(null, "Locations", 
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		LocationsPanel.setBounds(25, 9, 364, 241);
		contentPane.add(LocationsPanel);
		LocationsPanel.setLayout(null);
		
		LocationsList = new JList<String>(Locations);
		LocationsList.setBounds(5, 17, 354, 219);
		LocationsPanel.add(LocationsList);
		LocationsList.addListSelectionListener(this);
		
		
		JPanel VehicleListPanel = new JPanel();
		VehicleListPanel.setBorder(new TitledBorder(null, "Available Vehicle Classes", 
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		VehicleListPanel.setBounds(412, 9, 364, 241);
		contentPane.add(VehicleListPanel);
		VehicleListPanel.setLayout(null);
		
		VehicleList = new JList<String>();
		VehicleList.setBounds(5, 17, 354, 219);
		VehicleListPanel.add(VehicleList);
		
		JPanel ServicesPanel = new JPanel();
		ServicesPanel.setBorder(new TitledBorder(null, "Additional Equipment/Services", 
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ServicesPanel.setBounds(26, 275, 364, 241);
		contentPane.add(ServicesPanel);
		ServicesPanel.setLayout(null);
		
		JLabel ServicesLabel = new JLabel();
		ServicesLabel.setBounds(5, 17, 354, 219);
		ServicesPanel.add(ServicesLabel);
		ServicesLabel.setText("<HTML>GPS Receiver - $15/day"
				+ "<BR>Child Seat - $10/day"
				+ "<BR>K-TAG Rental - $2/day (plus accumulated tolls)"
				+ "<BR>Roadside Assistance - $7/day"
				+ "<BR>Loss Damage Waiver Insurance - $25/day"
				+ "<BR>Personal Accident Insurance - $5/day</HTML>");
		
		JPanel VehicleExamplePanel = new JPanel();
		VehicleExamplePanel.setBorder(new TitledBorder(null, "Vehicle Example", 
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		VehicleExamplePanel.setBounds(415, 275, 364, 241);
		contentPane.add(VehicleExamplePanel);
		VehicleExamplePanel.setLayout(null);
		
		JLabel VehicleExampleLabel = new JLabel();
		VehicleExampleLabel.setBounds(5, 17, 354, 219);
		VehicleExamplePanel.add(VehicleExampleLabel);
	}
	
	public String findVehicleString(String v) {
		if(v.equals("Economy")) {
			return(VehicleListStr[0]);
		} else if(v.equals("Compact")) {
			return(VehicleListStr[1]);
		} else if(v.equals("Standard")) {
			return(VehicleListStr[2]);
		} else if(v.equals("Premium")) {
			return(VehicleListStr[3]);
		} else if(v.equals("Small SUV")) {
			return(VehicleListStr[4]);
		} else if(v.equals("Standard SUV")) {
			return(VehicleListStr[5]);
		} else if(v.equals("Std SUV")) {
			return(VehicleListStr[5]);
		} else if (v.equals("Minivan")){
			return(VehicleListStr[6]);
		} else {
			return(" ");
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		int selectedLocationIndex = LocationsList.getSelectedIndex();
		int selectedLocationID = (selectedLocationIndex * 10) + 1;
		HashMap<String, Integer> countsV = db.GetVehicleClassCount(selectedLocationID);
		HashMap<String, Integer> countsR = db.GetReservedVehicleClassCount(selectedLocationID,
												"2016-01-01", "2015-01-01");
		DefaultListModel<String> newModel = new DefaultListModel<String>();
		Iterator<String> it = countsV.keySet().iterator();
		
		while(it.hasNext()) {
			String nextKey = it.next();
			//System.out.println(nextKey+"   "+countsV.get(nextKey));
			newModel.addElement(findVehicleString(nextKey));
		}
		
		VehicleList.setModel(newModel);
		
		//lblNewLabel.setIcon(pics[list.getSelectedIndex()]);
		
	}
}
