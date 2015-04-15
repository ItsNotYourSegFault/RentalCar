package rentalcar.ui;

import java.util.*;
import java.util.Set;
import java.util.HashMap;
import java.util.Date;
import java.util.Calendar;
import java.util.Vector;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import org.jdesktop.swingx.JXDatePicker;
import org.json.JSONException;

import rentalcar.web.Request;
import rentalcar.system.Database;
//import rentalcar.system.User;

public class MakeReservationModule extends JFrame implements ActionListener{
 
  //private User user = new User();
  private Database dbClient = new Database();

  private Boolean locationSelected = false;
  private Boolean startDateSelected = false;
  private Boolean endDateSelected = false;

  private JPanel  contentPane;
  private JLabel  labelLocation;
  private JLabel  labelDate;
  private JLabel  labelStart;
  private JLabel  labelEnd;
  private JLabel  labelDaymonthyear;
  private JLabel  labelVehicle;
  private JLabel  labelOptionalServicesequipments;
  private JLabel  labelServices;
  private JLabel  labelEquipments;
  private JLabel  labelChildSeat;
  private JLabel  labelTotalPrice;
  private JTextField labelTotalPriceValue;

  private JComboBox<String> locationsComboBox;
  private JComboBox comboBox_7;
  private JXDatePicker startPicker;
  private JXDatePicker endPicker;
  

  public Vector<String> getAvailableClasses(HashMap<String, Integer> totalClasses, HashMap<String, Integer> reservedClasses) {
    Vector<String> availableClasses = new Vector<String>();
    Iterator<String> classIterator = totalClasses.keySet().iterator();
    String _class;
    while(classIterator.hasNext()) {
        _class = classIterator.next();
        if (reservedClasses.get(_class) == null || 
            reservedClasses.get(_class) < totalClasses.get(_class)) 
        {
                availableClasses.add(_class);
        } 
    }
    return availableClasses;
  }
   
  /**
   * Create the frame.
   */
  public MakeReservationModule() {    
    super("RentalCar/Reservation");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 1000, 601);
    contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    /** Select a location */

    labelLocation = new JLabel("Locations:");
    labelLocation.setForeground(Color.BLACK);
    labelLocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
    labelLocation.setBounds(77, 44, 95, 20);
    contentPane.add(labelLocation);
    
    String[] locations = dbClient.GetLocations();
    locationsComboBox = new JComboBox<String>(locations);
    locationsComboBox.setMaximumRowCount(12);
    locationsComboBox.setBounds(235, 44, 172, 20);
    contentPane.add(locationsComboBox);
    locationsComboBox.addActionListener(this);

    comboBox_7 = new JComboBox<String>();
    comboBox_7.setBounds(235, 200, 137, 20);
    contentPane.add(comboBox_7);

    /** Select the Date */

    labelStart = new JLabel ();
    labelStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
    labelStart.setText("Start : ");
    labelStart.setBounds(77, 114, 67, 20);
    contentPane.add(labelStart);
    
    labelEnd = new JLabel ();
    labelEnd.setText("End :");
    labelEnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
    labelEnd.setBounds(77, 156, 58, 20);
    contentPane.add(labelEnd);
    
    startPicker = new JXDatePicker();
    startPicker.setDate(Calendar.getInstance().getTime());
    startPicker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
    startPicker.setBounds(256, 114, 118, 20);
    startPicker.addActionListener(this);
    contentPane.add(startPicker);

    endPicker = new JXDatePicker();
    endPicker.setDate(Calendar.getInstance().getTime());
    endPicker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
    endPicker.setBounds(256, 156, 118, 20);
    endPicker.addActionListener(this);
    contentPane.add(endPicker);

    labelVehicle = new JLabel ();
    labelVehicle.setText("Vehicle Class");
    labelVehicle.setFont(new Font("Tahoma", Font.PLAIN, 15));
    labelVehicle.setBounds(77, 198, 118, 20);
    contentPane.add(labelVehicle);
    
    labelOptionalServicesequipments = new JLabel ();
    labelOptionalServicesequipments.setText("Optional Services/Equipments");
    labelOptionalServicesequipments.setFont(new Font("Tahoma", Font.PLAIN, 15));
    labelOptionalServicesequipments.setBounds(77, 247, 226, 20);
    contentPane.add(labelOptionalServicesequipments);
    
    labelServices = new JLabel ();
    labelServices.setText("Services");
    labelServices.setFont(new Font("Tahoma", Font.PLAIN, 15));
    labelServices.setBounds(156, 289, 86, 20);
    contentPane.add(labelServices);
    
    labelEquipments = new JLabel ();
    labelEquipments.setText("Equipments");
    labelEquipments.setFont(new Font("Tahoma", Font.PLAIN, 15));
    labelEquipments.setBounds(156, 333, 102, 20);
    contentPane.add(labelEquipments);
    
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
    
    labelChildSeat = new JLabel ();
    labelChildSeat.setText("Child Seat");
    labelChildSeat.setBounds(530, 334, 80, 20);
    contentPane.add(labelChildSeat);
    
    JSpinner spinner_1 = new JSpinner();
    spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
    spinner_1.setBounds(611, 333, 58, 20);
    contentPane.add(spinner_1);
    
    labelTotalPrice = new JLabel ();
    labelTotalPrice.setText("Total Price : ");
    labelTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
    labelTotalPrice.setBounds(156, 395, 102, 20);
    contentPane.add(labelTotalPrice);
    
    labelTotalPriceValue = new JTextField();
    labelTotalPriceValue.setText("Print the price here");
    labelTotalPriceValue.setBounds(270, 395, 144, 20);
    contentPane.add(labelTotalPriceValue);
    
    JButton btnNewButton = new JButton("Confirm Reservation");
    btnNewButton.setBounds(327, 498, 161, 23);
    contentPane.add(btnNewButton);
    
    JCheckBox chckbxNewCheckBox_3 = new JCheckBox("GPS");
    chckbxNewCheckBox_3.setBounds(270, 332, 58, 23);
    contentPane.add(chckbxNewCheckBox_3);
    
    JCheckBox chckbxNewCheckBox_4 = new JCheckBox("K-Tag");
    chckbxNewCheckBox_4.setBounds(392, 332, 82, 23);
    contentPane.add(chckbxNewCheckBox_4);    
  }

  public void actionPerformed(ActionEvent e){
    int Locationid = 0;
    String sDate = null;
    String eDate = null;

    if(e.getSource() == locationsComboBox){
        String mylocation = (String)locationsComboBox.getSelectedItem();
        Locationid = dbClient.GetLocationId(mylocation);
        locationSelected = true;
    }
    if(e.getSource() == startPicker){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sDate = df.format(startPicker.getDate());
        startDateSelected = true;
    }
    if(e.getSource() == endPicker){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        eDate = df.format(endPicker.getDate());
        endDateSelected = true;
    }
    try{
        HashMap<String, Integer> totalClasses = dbClient.GetVehicleClassCount(Locationid);
        HashMap<String, Integer> reservedClasses = dbClient.GetReservedVehicleClassCount(Locationid, sDate, eDate);
        Vector<String> availableClasses = getAvailableClasses(totalClasses, reservedClasses);
        if(locationSelected == true && startDateSelected == true && endDateSelected == true){
            if(availableClasses == null){
                comboBox_7.setModel(new DefaultComboBoxModel());
            }else{
                comboBox_7.setModel(new DefaultComboBoxModel(availableClasses));
            }
        }   
    }catch(JSONException a){
        e.printStackTrace();
    }
  }
}