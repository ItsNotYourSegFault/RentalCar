
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import rentalcar.ui.TextPrompt;
import rentalcar.system.User;
import rentalcar.data.FormObject;

public class AllenEaton {

	User user = new User();
	private JFrame frame;
	private JTextField passwordField;
	private JTextField usernameField;
	TextPrompt usernamePrompt;
	TextPrompt passwordPrompt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllenEaton window = new AllenEaton();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AllenEaton() {
		initialize();
	}

  /** 
   *  Set the top authentication banner
   */
  public void SetAuthenticationBanner() {
    if (user.IsLoggedIn()) {
      SetLoggedOutBanner(false);
      SetLoggedInBanner(true);
    } else {
      SetLoggedInBanner(false);
      SetLoggedOutBanner(true);
    }
  }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); 
		SetAuthenticationBanner();
		//DisplayAuthenticationError("Invalid username/password combination", false);
		//SetLoggedInBanner(true);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Browse's actions
			}
		});
		btnBrowse.setBounds(10, 40, 89, 23);
		frame.getContentPane().add(btnBrowse);

	}

	public void AttemptLogin() {
		user = new User();
		FormObject credentials = new FormObject();
		credentials.Set("username", usernameField.getText());
		credentials.Set("password", passwordField.getText());
		user.LogIn(credentials);
		SetAuthenticationBanner();
		if (!user.IsLoggedIn()) {
			DisplayAuthenticationError("Invalid username/password combination", true);
		}
	}

	public void AttemptLogout() {
		//user.LogOut();
		//user.LogOut();
		//setAuthenticationBanner();
	}

	public void DisplayAuthenticationError(String message, boolean bool) {
		JLabel errMessage = new JLabel(message);
		errMessage.setBounds(100, 0, 300, 20);
		frame.getContentPane().add(errMessage);
		errMessage.setVisible(bool);
		// display error next to logged out form fields
	}

	public void SetLoggedOutBanner(boolean bool) {
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Login's actions.
				AttemptLogin();
			}
		});
		btnLogin.setBounds(675, 0, 117, 25);
		frame.getContentPane().add(btnLogin);
		btnLogin.setVisible(bool);

		passwordField = new JTextField();
		passwordField.setText("");
		passwordField.setBounds(531, 0, 114, 25);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		passwordField.setVisible(bool);

		usernameField = new JTextField();
		usernameField.setText("");
		usernameField.setBounds(411, 0, 114, 25);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		usernameField.setVisible(bool);

		usernamePrompt = new TextPrompt("user", usernameField);
		passwordPrompt = new TextPrompt("pass", passwordField);

		usernamePrompt.changeAlpha(0.5f);
		passwordPrompt.changeAlpha(0.5f);
	}

	public void SetLoggedInBanner(boolean bool) {
		//The upper banner
		JLabel welMessage = new JLabel();
		try{
			welMessage.setText("Welcome, " + user.FirstName());
		}catch(IllegalStateException e){
			DisplayAuthenticationError(e.getMessage(), true);
		}
		welMessage.setBounds(475, 0, 150, 20);
		frame.getContentPane().add(welMessage);
		welMessage.setVisible(bool);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Logout's actions.
				
			}
		});
		btnLogout.setBounds(675, 0, 100, 23);
		frame.getContentPane().add(btnLogout);
		btnLogout.setVisible(bool);


		//2nd level banner.
		JButton btnMakeReservation = new JButton("Make Reservation");
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Make Reservation's actions.
			}
		});
		btnMakeReservation.setBounds(109, 40, 161, 23);
		frame.getContentPane().add(btnMakeReservation);
		btnMakeReservation.setVisible(bool);


		JButton btnHistory = new JButton("History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//History's actions.
			}
		});
		btnHistory.setBounds(282, 39, 117, 25);
		frame.getContentPane().add(btnHistory);
		btnHistory.setVisible(bool);

	}


}
