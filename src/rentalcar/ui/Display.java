package rentalcar.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;
//Most up to date version of Display is on EECS HELPDESK machine.

@SuppressWarnings("serial")
public class Display extends JFrame implements KeyListener, FocusListener{
	private static JFrame frame = new JFrame();
	private static JTextArea txt;
	private static JTextField inputField;
	//static ImageIcon art;
	//static File artFile;
	//static JLabel label = new JLabel("", art, JLabel.CENTER);
	//static JPanel picturePane = new JPanel(new BorderLayout());
	//static JSplitPane splitPane= null;
	@SuppressWarnings("unused")
	private static Component c = null;
	private static String text;
	private static String choice;
	private static char keyStroke;
	private static boolean enter = false;
	private static boolean keyTyped = false;
	private static int messageSpeed = 4;
	Container positioner = frame.getContentPane();

	Display(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		text = "";
		txt = new JTextArea(text);
		txt.setEditable(false);
		inputField = new JTextField("");
		txt.setBackground(Color.black);
		txt.setFont(new Font("Courier New", Font.PLAIN, 18));
		txt.setForeground(Color.lightGray);
		inputField.setBackground(Color.black);
		inputField.setFont(new Font("Courier New", Font.PLAIN, 18));
		inputField.setForeground(Color.lightGray);
		frame.add(inputField);
		JScrollPane scrollPane = new JScrollPane(txt);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//picturePane.add(label, BorderLayout.CENTER);
		//picturePane.setBackground(Color.black);
		//picturePane.setSize(frame.getGraphicsConfiguration().getBounds().height, frame.getGraphicsConfiguration().getBounds().width*934/1600);
		//splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, picturePane);
		positioner.setLayout(new BorderLayout());
		positioner.add(inputField, BorderLayout.PAGE_END);
		positioner.setBackground(Color.black); 
		positioner.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(1200, 675);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//splitPane.setDividerLocation(frame.getGraphicsConfiguration().getBounds().width*934/1600);
		DefaultCaret caret = (DefaultCaret)txt.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		frame.setVisible(true);
		inputField.addKeyListener(this);
		inputField.requestFocusInWindow();
		txt.addFocusListener(this);

		frame.addComponentListener(new ComponentListener() {  
			public void componentResized(ComponentEvent evt) {
				c = (Component)evt.getSource();
				try{
			//		art = new ImageIcon(artFile.toString());
			//		setArtSize();
				}catch(Exception E){
					//println("Error resizing artwork.");
					E.printStackTrace();
				}
				//label.setIcon(art);
				//splitPane.setDividerLocation((int) Math.round(c.getWidth()*.58375));
			}
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
			@Override
			public void componentMoved(ComponentEvent arg0) {
			}
			@Override
			public void componentShown(ComponentEvent arg0) {
			}
		});
	}

	
	
	//------------------------------------------------------
	//Output functions
	//print/println : Outputs to screen with no pause.  Overloaded method to handle Strings, chars, and ints.
	//read/readln : Outputs to screen one letter at a time.  Currently only handles Strings, easily extended to others.
	//------------------------------------------------------
	
	
	public static void println(String line){
		text += line + "\n";
		txt.setText(text);
	}

	public static void println(char line){
		text += line + "\n";
		txt.setText(text);
	}
	
	public static void println(int num){
		String line = String.valueOf(num);
		text += line + "\n";
		txt.setText(text);
	}

	
	public static void print(String line){
		text += line;
		txt.setText(text);
	}

	public static void print(char line){
		text += line;
		txt.setText(text);
	}
	
	public static void print(int num){
		String line = String.valueOf(num);
		text += line;
		txt.setText(text);
	}

	
	public static void readln(String line){
		if(messageSpeed == 0){
			text += line + "\n";
			txt.setText(text);
		}else{
			for(int i = 0; i < line.length(); i++){
				text += (line.charAt(i));
				txt.setText(text);
				messageWait(5);
				if(line.charAt(i) == ',' || line.charAt(i) == ':' || line.charAt(i) == ';'){
					messageWait(50);
				}
				if(line.charAt(i) == '.' || line.charAt(i) == '?' || line.charAt(i) == '!'){
					messageWait(100);
				}
			}
			text += "\n";
			txt.setText(text);
		}
	}

	public static void read(String line){
		if(messageSpeed == 0){
			text += line;
			txt.setText(text);
		}else{
			for(int i = 0; i < line.length(); i++){
				text += (line.charAt(i));
				txt.setText(text);
				messageWait(5);
				if(line.charAt(i) == ',' || line.charAt(i) == ':' || line.charAt(i) == ';'){
					messageWait(50);
				}
				if(line.charAt(i) == '.' || line.charAt(i) == '?' || line.charAt(i) == '!'){
					messageWait(100);
				}
			}
		}
	}
	
	
	
	//------------------------------------------------
	//Components to the read/readln methods. Don't worry about them.
	//------------------------------------------------
	
	
	private static void messageWait(int waitCycles){
		for(int i = 0; i < waitCycles; i++){
			if(messageSpeed == 0){
				return;
			}else{
				wait(messageSpeed);
			}
		}
	}
	
	private static void wait(int waitTime){
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	
	//----------------------------------------------
	//Input methods.
	//Input handles Strings.
	//InputChar handles chars.
	//InputInt handles ints.
	//Would be very easy to extend to doubles and other types.
	//----------------------------------------------
	

	public static String input(){
		enter = false;
		inputField.setText(""); //Improves catching of loose input, possibly reduces speed.
		for(;;){
			if(enter == true){
				enter = false;
				println("\n" + choice + "\n");
				return choice;
			}else{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					if(enter == true){
						enter = false;
						println("\n" + choice + "\n");
						return choice;
					}
				}
			}
		}
	}

	public static char inputChar(){
		keyTyped = false;
		inputField.setText("");
		for(;;){
			if(keyTyped == true){
				keyTyped = false;
				inputField.setText("");
				println("\n" + keyStroke + "\n");
				return keyStroke;
			}else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					if(keyTyped == true){
						keyTyped = false;
						inputField.setText("");
						println("\n" + keyStroke + "\n");
						return keyStroke;
					}
				}
			}
		}
	}

	public static int inputInt(){
		enter = false;
		inputField.setText(""); //Improves catching of loose input, possibly reduces speed.
		for(;;){
			if(enter == true){
				enter = false;
				try{
					int i = Integer.parseInt(choice);
					println("\n" + choice + "\n");
					return i;
				}catch(Exception e){
					println("Please enter a number only.");
				}
			}else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					if(enter == true){
						enter = false;
						try{
							int i = Integer.parseInt(choice);
							println("\n" + choice + "\n");
							return i;
						}catch(Exception E){
							println("Please enter a number only.");
						}
					}
				}
			}
		}
	}
	
	
	
	//----------------------------------------------------------
	//Additional functions related to keyListener/focusListener. Pay no mind to them.
	//----------------------------------------------------------
	
	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			choice = inputField.getText();
			inputField.setText("");
			enter = true;
			try{
				Thread.currentThread().interrupt();
			}catch(Exception E){

			}
		}//else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			//Options.messageSpeed = 0;
			//Thread.currentThread().interrupt();
		//}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyStroke = e.getKeyChar();
		keyStroke = Character.toLowerCase(keyStroke);
		keyTyped = true;
	}

	@Override
	public void focusGained(FocusEvent e) {
		inputField.requestFocusInWindow();
	}

	@Override
	public void focusLost(FocusEvent e) {

	}
}

