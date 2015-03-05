import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import rentalcar.ui.TextPrompt;

public class AllenEaton {

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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(681, 0, 117, 25);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JTextField();
		passwordField.setText("");
		passwordField.setBounds(531, 0, 114, 19);
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(10);
		
		
		usernameField = new JTextField();
		usernameField.setText("");
		usernameField.setBounds(411, 0, 114, 19);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		usernamePrompt = new TextPrompt("username", usernameField);
		passwordPrompt = new TextPrompt("password", passwordField);
		
		usernamePrompt.changeAlpha(0.5f);
		passwordPrompt.changeAlpha(0.5f);
		
	}
}
