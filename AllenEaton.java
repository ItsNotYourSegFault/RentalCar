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

//import rentalcar.ui.TextPrompt;
//import rentalcar.system.User;
//import rentalcar.data.FormObject;



public class AllenEaton {
	
	//------------------------------
	//Declare all components globally
	//------------------------------
	
	//User user;
	private JFrame frame;

	//Authentication Banner
	private JTextField passwordField;
	private JTextField usernameField;
	private JButton btnRegister;
	//TextPrompt usernamePrompt;
	//TextPrompt passwordPrompt;
	private JButton btnLogout;
	private JButton btnLogin;
	private JLabel welMessage;

	//Error banner
	private JLabel errMessage;
	
	//Register Button
	private JLabel userMessage;
	private JLabel passMessage;
	private JTextField userField;
	private JTextField passField;
	private JButton btnSubmit;

	// NavMenu buttons
	private final JButton btnBrowse = new JButton("browse");
	private final JButton btnMakeReservation = new JButton("make reservation");;
	private final JButton btnHistory = new JButton("history");
	
	public final int MENU_GAP = 5;
	public final int AUTHENTICATION_MENU_OFFSET = 0;
	public final int AUTHENTICATION_MENU_HEIGHT = 25;
	public final int NAVIGATION_MENU_OFFSET = AUTHENTICATION_MENU_OFFSET + AUTHENTICATION_MENU_HEIGHT + MENU_GAP;
	public final int NAVIGATION_MENU_HEIGHT = 25;
	public final int MODULE_OFFSET = NAVIGATION_MENU_OFFSET + NAVIGATION_MENU_HEIGHT + MENU_GAP;
	public final int MODULE_HEIGHT = 600;
	public final int WINDOW_HEIGHT = AUTHENTICATION_MENU_HEIGHT + NAVIGATION_MENU_HEIGHT + MODULE_HEIGHT + MENU_GAP;
	
	/** Rental car application Modules */
	
	// public class BrowseModule extends Module {
	// 	@Override
	// 	public Container load(Container initialContent) {
	// 		// add buttons, action listeners, text fields, etc.
	// 		return initialContent;
	// 	}
		
	// 	@Override
	// 	public Container clear(Container initialContent) {
	// 		return initialContent;
	// 	}
	// }
	
	private Module browseModule  = new BrowseModule();
	private Module reservationModule = new ReservationModule();

	/** The current module at any stage of the application */
	private Module currentModule = browseModule;

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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//------------------------------------
		//Initialize all functions, set everything to false except logout banner.
		//------------------------------------
		SetAuthenticationBannerLoggedOut(true);
		SetAuthenticationBannerLoggedIn(false);
		SetNavigationBannerLoggedOut(true);
		SetNavigationBannerLoggedIn(false);
		DisplayAuthenticationError("", false);
		AttachNavigationMenuActionListeners();
		browseActions(false);
		registerActions(false);
	}

	
	private void AttachNavigationMenuActionListeners() {

		/** Set navigation menu button action listeners **/
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentModule.clear();
				currentModule = browseModule;
				frame.setContentPane(
						currentModule.load(frame.getContentPane()));
				//browseActions(true);
				
			}
		});
		
		
	}


	public void SetAuthenticationBannerLoggedOut(boolean bool) {

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Login's actions.
				clear();
				SetAuthenticationBannerLoggedIn(true);
			}
		});
		btnLogin.setBounds(260, AUTHENTICATION_MENU_OFFSET, 120, AUTHENTICATION_MENU_HEIGHT);
		frame.getContentPane().add(btnLogin);
		btnLogin.setVisible(true);
		

		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Register's actions.
				clear();
				SetAuthenticationBannerLoggedOut(true);
				registerActions(true);
			}
		});
		btnRegister.setBounds(385, AUTHENTICATION_MENU_OFFSET, 120, AUTHENTICATION_MENU_HEIGHT);
		frame.getContentPane().add(btnRegister);
		btnRegister.setVisible(bool);


		//Username/Password inputFields
		passwordField = new JTextField();
		passwordField.setText("");
		passwordField.setBounds(0, AUTHENTICATION_MENU_OFFSET, 120, AUTHENTICATION_MENU_HEIGHT);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		passwordField.setVisible(bool);

		usernameField = new JTextField();
		usernameField.setText("");
		usernameField.setBounds(125, AUTHENTICATION_MENU_OFFSET, 120, AUTHENTICATION_MENU_HEIGHT);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		usernameField.setVisible(bool);

		//usernamePrompt = new TextPrompt("user", usernameField);
		//passwordPrompt = new TextPrompt("pass", passwordField);

		//usernamePrompt.changeAlpha(0.5f);
		//passwordPrompt.changeAlpha(0.5f);
	}

	public void SetAuthenticationBannerLoggedIn(Boolean bool) {
		//The upper banner
		welMessage = new JLabel("Welcome, " /*user.getFirstName*/);
		welMessage.setBounds(475, 0, 150, 20);
		frame.getContentPane().add(welMessage);
		welMessage.setVisible(bool);

		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Logout's actions.
				clear();
				SetAuthenticationBannerLoggedOut(true);
			}
		});
		btnLogout.setBounds(675, 0, 100, 23);
		frame.getContentPane().add(btnLogout);
		btnLogout.setVisible(bool);
	}

	
	public void SetNavigationBannerLoggedIn(Boolean bool) {
		// Browse button
		btnBrowse.setBounds(10, 40, 89, 23);
		btnBrowse.setVisible(true);
		frame.getContentPane().add(btnBrowse);
		
		//2nd level banner.
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Make Reservation's actions.
			}
		});
		btnMakeReservation.setBounds(109, 40, 161, 23);
		frame.getContentPane().add(btnMakeReservation);
		btnMakeReservation.setVisible(bool);


		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//History's actions.
			}
		});
		btnHistory.setBounds(282, 39, 117, 25);
		frame.getContentPane().add(btnHistory);
		btnHistory.setVisible(bool);
	}
	
	
	public void SetNavigationBannerLoggedOut(Boolean bool) {
		//Browse button
		btnBrowse.setBounds(0, NAVIGATION_MENU_OFFSET, 120, NAVIGATION_MENU_HEIGHT);
		btnBrowse.setVisible(bool);
		frame.getContentPane().add(btnBrowse);
	} 
	
	
	public void DisplayAuthenticationError(String message, boolean bool) {
		// display error next to logged out form fields
		errMessage = new JLabel(message);
		errMessage.setBounds(100, 0, 300, 20);
		frame.getContentPane().add(errMessage);
		errMessage.setVisible(bool);
	}




	public void browseActions(boolean bool){;
		//load your components.
		//Sample code below to demonstrate.
		
		JButton btnbut = new JButton("butttton");
		btnbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Browse's actions
			}
		});
		btnbut.setBounds(10, 100, 110, 23);
		frame.getContentPane().add(btnbut);
		btnbut.setVisible(bool);
	}



	public void registerActions(boolean bool){

		userMessage = new JLabel("Please enter your preferred username.");
		userMessage.setBounds(100, 100, 300, 25);
		frame.getContentPane().add(userMessage);
		userMessage.setVisible(bool);
		
		userField = new JTextField();
		userField.setText("");
		userField.setBounds(100, 130, 300, 25);
		frame.getContentPane().add(userField);
		userField.setColumns(10);
		userField.setVisible(bool);
		
		passMessage = new JLabel("Please enter your preferred password.");
		passMessage.setBounds(100, 200, 300, 25);
		frame.getContentPane().add(passMessage);
		passMessage.setVisible(bool);
		
		passField = new JTextField();
		passField.setText("");
		passField.setBounds(100, 230, 300, 25);
		frame.getContentPane().add(passField);
		passField.setColumns(10);
		passField.setVisible(bool);
		
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Submit's actions
			}
		});
		btnSubmit.setBounds(175, 300, 110, 23);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.setVisible(bool);
		
		
	}

	

	
	
	
	public void AttemptLogin() {
		//	user = new User();
		//  FormObject credentials = new FormObject();
		//	credentials.Set("username", usernameField.getText());
		//	credential309, 5assword", passwordField.getText());
		//	user.LogIn(credentials);
		//	if (user.IsLoggedIn()) {
		//		SetLoggedOutBanner(false);
		//		SetLoggedInBanner(true);
		//	} else {
		//		DisplayAuthenticationError("Invalid username/password combination", true);
		//	}
	}


	public void AttemptLogout() {
		//user.LogOut();
		//if (!user.IsLoggedIn()) {
		//  SetLoggedInBanner(false);
		//	SetLoggedOutBanner(true);
		//} else {
		//	DisplayAuthenticationError("Unable to log user out", true);
		//}
	}

	
	

	public void clear(){
		
		
		//Logout components
		frame.getContentPane().remove(usernameField);
		frame.getContentPane().remove(passwordField);
		frame.getContentPane().remove(btnLogin);
		frame.getContentPane().remove(btnRegister);
		
		//Login components
		frame.getContentPane().remove(btnLogout);
		frame.getContentPane().remove(btnHistory);
		frame.getContentPane().remove(btnMakeReservation);
		frame.getContentPane().remove(welMessage);
		
		//Error components
		frame.getContentPane().remove(errMessage);
		
		//Register components
		frame.getContentPane().remove(userMessage);
		frame.getContentPane().remove(passMessage);
		frame.getContentPane().remove(userField);
		frame.getContentPane().remove(passField);
		frame.getContentPane().remove(btnSubmit);
		
		frame.repaint();
	}



}