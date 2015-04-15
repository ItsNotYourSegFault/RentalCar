import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import rentalcar.ui.MakeReservationModule;
//import rentalcar.system.User;
//import rentalcar.data.FormObject;



public class AllenEaton {
	public static void main(String[] args) {
		/**
		* Launch the application.
		*/
		try {
			MakeReservationModule MRModule = new MakeReservationModule();
			MRModule.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

