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
        setTitle("Pug's Puncake Diner Co.");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
   		// Welcome title
        JLabel welcomeLabel = new JLabel("Welcome to Pug's Puncake Diner!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(welcomeLabel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new GridLayout(4,1,10,10));
        
        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        JButton signUpButton = new JButton("Sign up");
        
        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);
        
        JLabel notUser = new JLabel("Not a User? Click here to sign up!", SwingConstants.CENTER);
        notUser.setFont(new Font("Sans", Font.PLAIN, 16));
        
        buttonPanel.add(notUser);
        buttonPanel.add(signUpButton);
        
        loginButton.addActionListener(e -> {
            LoginScreen loginScreen = new LoginScreen(CafeOnlineOrderSystemGUI.this, null);
            loginScreen.setVisible(true);
        });
        signUpButton.addActionListener(e -> {
            SignupScreen signUp = new SignupScreen(CafeOnlineOrderSystemGUI.this, pugCafe);
            signUp.setVisible(true);
        });
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        
	}
	public static void main(String[] args) {
		 SwingUtilities.invokeLater(() -> {
	            CafeOnlineOrderSystemGUI gui = new CafeOnlineOrderSystemGUI();
	            gui.setVisible(true);
	        });
	}
}
