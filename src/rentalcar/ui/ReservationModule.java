package rentalcar.ui; 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;

public class ReservationModule extends JFrame {

	private JPanel contentPane;
	private JTextField txtLocation;
	private JTextField txtDate;
	private JTextField txtStart;
	private JTextField txtEnd;
	private JTextField txtDaymonthyear;
	private JTextField txtVehicle;
	private JTextField txtOptionalServicesequipments;
	private JTextField txtServices;
	private JTextField txtEquipments;
	private JTextField txtChildSeat;
	private JTextField txtTotalPrice;
	private JTextField txtPrintThePrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationModule frame = new ReservationModule();
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
	public ReservationModule() {
		super("RentalCar/Reservation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 601);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLocation = new JTextField();
		txtLocation.setEditable(false);
		txtLocation.setForeground(Color.BLACK);
		txtLocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLocation.setText("Locations :");
		txtLocation.setBounds(77, 44, 95, 20);
		contentPane.add(txtLocation);
		txtLocation.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(12);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Atchison, KS", "Belton, MO", "Emporia, KS", "Hiawatha, KS", "Kansas City, MO", "Lawrence, KS", "Leavenworth, KS", "Manhattan, KS", "Platte City, MO", "St Joseph, MO", "Topeka, KS", "Warrensburg, MO"}));
		comboBox.setBounds(235, 44, 137, 20);
		contentPane.add(comboBox);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDate.setText("Dates :");
		txtDate.setEditable(false);
		txtDate.setBounds(77, 114, 64, 20);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
		txtStart = new JTextField();
		txtStart.setEditable(false);
		txtStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtStart.setText("Start : ");
		txtStart.setBounds(156, 114, 67, 20);
		contentPane.add(txtStart);
		txtStart.setColumns(10);
		
		txtEnd = new JTextField();
		txtEnd.setEditable(false);
		txtEnd.setText("End :");
		txtEnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnd.setBounds(156, 156, 58, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);
		
		txtDaymonthyear = new JTextField();
		txtDaymonthyear.setEditable(false);
		txtDaymonthyear.setText("M        /      D      /     Y");
		txtDaymonthyear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDaymonthyear.setBounds(235, 85, 172, 20);
		contentPane.add(txtDaymonthyear);
		txtDaymonthyear.setColumns(10);
		
		txtVehicle = new JTextField();
		txtVehicle.setEditable(false);
		txtVehicle.setText("Vehicle Class");
		txtVehicle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtVehicle.setBounds(77, 198, 118, 20);
		contentPane.add(txtVehicle);
		txtVehicle.setColumns(10);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Economy", "Compact", "Standard", "Premium", "Small SUV", "Standard SUV", "Minivan"}));
		comboBox_7.setMaximumRowCount(7);
		comboBox_7.setBounds(235, 200, 137, 20);
		contentPane.add(comboBox_7);
		
		txtOptionalServicesequipments = new JTextField();
		txtOptionalServicesequipments.setEditable(false);
		txtOptionalServicesequipments.setText("Optional Services/Equipments");
		txtOptionalServicesequipments.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtOptionalServicesequipments.setBounds(77, 247, 226, 20);
		contentPane.add(txtOptionalServicesequipments);
		txtOptionalServicesequipments.setColumns(10);
		
		txtServices = new JTextField();
		txtServices.setEditable(false);
		txtServices.setText("Services");
		txtServices.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtServices.setBounds(156, 289, 86, 20);
		contentPane.add(txtServices);
		txtServices.setColumns(10);
		
		txtEquipments = new JTextField();
		txtEquipments.setEditable(false);
		txtEquipments.setText("Equipments");
		txtEquipments.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEquipments.setBounds(156, 333, 102, 20);
		contentPane.add(txtEquipments);
		txtEquipments.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Roadside Assistance");
		chckbxNewCheckBox.setToolTipText("");
		chckbxNewCheckBox.setBounds(270, 290, 161, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Loss Damage Waiver Insurance");
		chckbxNewCheckBox_1.setBounds(443, 288, 226, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Personal Accident Insurance");
		chckbxNewCheckBox_2.setBounds(670, 288, 209, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		txtChildSeat = new JTextField();
		txtChildSeat.setEditable(false);
		txtChildSeat.setText("Child Seat");
		txtChildSeat.setBounds(530, 334, 80, 20);
		contentPane.add(txtChildSeat);
		txtChildSeat.setColumns(10);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1.setBounds(611, 333, 58, 20);
		contentPane.add(spinner_1);
		
		txtTotalPrice = new JTextField();
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setText("Total Price : ");
		txtTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTotalPrice.setBounds(156, 395, 102, 20);
		contentPane.add(txtTotalPrice);
		txtTotalPrice.setColumns(10);
		
		txtPrintThePrice = new JTextField();
		txtPrintThePrice.setText("Print the price here");
		txtPrintThePrice.setBounds(270, 395, 144, 20);
		contentPane.add(txtPrintThePrice);
		txtPrintThePrice.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm Reservation");
		btnNewButton.setBounds(327, 498, 161, 23);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("GPS");
		chckbxNewCheckBox_3.setBounds(270, 332, 58, 23);
		contentPane.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("K-Tag");
		chckbxNewCheckBox_4.setBounds(392, 332, 82, 23);
		contentPane.add(chckbxNewCheckBox_4);
		
		JSpinner spinner = new JSpinner();
		spinner.setForeground(new Color(0, 0, 0));
		spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		spinner.setModel(new SpinnerDateModel(new Date(1426050000000L), new Date(1426050000000L), null, Calendar.DAY_OF_WEEK_IN_MONTH));
		spinner.setBounds(235, 114, 196, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerDateModel(new Date(1426050000000L), new Date(1426050000000L), null, Calendar.DAY_OF_YEAR));
		spinner_2.setForeground(Color.BLACK);
		spinner_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		spinner_2.setBounds(235, 156, 196, 20);
		contentPane.add(spinner_2);
		
	}
}
