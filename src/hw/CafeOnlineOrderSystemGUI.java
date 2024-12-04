package hw;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CafeOnlineOrderSystemGUI extends JFrame{
	
	private cafe pugCafe = cafe.DB;
	
	public CafeOnlineOrderSystemGUI() {
        // Set up the frame
		JFrame frame = new JFrame("Dineer");
		frame.setTitle("Pug's Puncake Diner Co.");
		frame.setSize(800, 450);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		GridBagConstraints gbc = new GridBagConstraints();
		// xxx specify that the component's display area will be from gridx to 
		// xxx the last cell in the row
        gbc.gridwidth = GridBagConstraints.REMAINDER;
		// xxx Make the component wide enough to fill its display area horizontally, 
		// xxx but do not change its height.
        gbc.fill =      GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 50, 10, 50); 
		
   		// Welcome title
        JLabel welcomeLabel = new JLabel("Welcome to Pug's Puncake Cafe!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 32));
      
        
        
        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        JButton signUpButton = new JButton("Sign up");
       
        
        JLabel notUser = new JLabel("Not a User? Click here to sign up!", SwingConstants.CENTER);
        notUser.setFont(new Font("Sans", Font.PLAIN, 16));
        
        frame.add(welcomeLabel, gbc);
        frame.add(loginButton, gbc);
        frame.add(exitButton,gbc);
        frame.add(notUser, gbc);
        frame.add(signUpButton, gbc);
        
        loginButton.addActionListener(e -> {
            LoginScreen loginScreen = new LoginScreen(CafeOnlineOrderSystemGUI.this, null);
            loginScreen.displayLoginForm();
        });
        signUpButton.addActionListener(e -> {
            SignupScreen signUp = new SignupScreen(CafeOnlineOrderSystemGUI.this, pugCafe);
            signUp.displaySignupForm();
          //  signUp.setVisible(true);
        });
        
        frame.setVisible(true);
	}
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(() -> {
	            CafeOnlineOrderSystemGUI gui = new CafeOnlineOrderSystemGUI();
	           // gui.setVisible(true);
	        });
	}
}
