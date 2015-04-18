package rentalcar.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import rentalcar.ui.CustomerModule;
import rentalcar.ui.servicemngrWindow;
import rentalcar.system.User;

public class LoginModule extends JFrame {
		User user = new User();
		JPanel contentPane = new JPanel();
		JLabel usernameLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");
		JLabel status = new JLabel();
		JButton loginButton = new JButton("login");
		JTextField username = new JTextField(20);
		JTextField password = new JTextField(20);
    
    void redirectByUserType(String type) {
      if (type.equals("customer")) {
        CustomerModule customerMod = new CustomerModule(user);
        customerMod.setVisible(true);
        this.close();
      } else if (type.equals("service_manager")) {

      } else if (type.equals("admin")) {

      }
    }
    
    public LoginModule() {
    	loginButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) {
    			user.LogIn(username.getText(), password.getText());
    			if (user.IsLoggedIn()) {
    				redirectByUserType(user.Type());
    			} else {
    				status.setText("Error!");
    			}
    		}
    	});
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 200, 201);
			contentPane.add(usernameLabel);
			contentPane.add(username);
			contentPane.add(passwordLabel);
			contentPane.add(password);
			contentPane.add(loginButton);
			contentPane.add(status);
			setContentPane(contentPane);
		}
}