package hw;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.Random;


public class SignupScreen extends JDialog {

	private CafeOnlineOrderSystemGUI mainGUI;
    private static cafe mycafe;
    
    public SignupScreen(CafeOnlineOrderSystemGUI parent, cafe pugCafe) {
    	 super(parent, "Signup", true);
    	/* setLayout(new BorderLayout());
         setSize(300, 300);
         setLocationRelativeTo(parent)*/
    	
    }
    
   
   		// xxx your codes
    public static void displaySignupForm() {
    	 JFrame frame = new JFrame("Signup");
    	 frame.setLayout(new GridBagLayout());
    	 frame.setSize(800, 450);
    	 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.setLocationRelativeTo(null);	
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
      	JTextField firstNameField = new JTextField(20);
      	JTextField lastNameField = new JTextField(20);
      	JTextField emailField = new JTextField(20);
      	JPasswordField passwordField = new JPasswordField(20);
      	String[] typeTemp = { "Admin", "Customer" };
      	JComboBox<String> mode = new JComboBox<String>(typeTemp);
      	
      	GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 30, 5, 30);

        JButton submitButton = new JButton("Submit");

        Font fieldFont = new Font("Arial", Font.PLAIN, 24);
        firstNameField.setFont(fieldFont);
        lastNameField.setFont(fieldFont);
        emailField.setFont(fieldFont);
        passwordField.setFont(fieldFont);
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));

        SubmitButtonListener submitButtonListener =  new SubmitButtonListener(
    			frame, firstNameField, lastNameField, emailField, passwordField, mode);
    	submitButton.addActionListener( submitButtonListener );

        frame.add(new JLabel("First Name:"), gbc);
        frame.add(firstNameField, gbc);
        frame.add(new JLabel("Last Name:"), gbc);
        frame.add(lastNameField, gbc);
        frame.add(new JLabel("Email:"), gbc);
        frame.add(emailField, gbc);
        frame.add(new JLabel("Password:"), gbc);
        frame.add(passwordField, gbc);
        frame.add(new JLabel("Mode:"), gbc);
        frame.add(mode, gbc);
        frame.add(submitButton, gbc);
        

        frame.setVisible(true);
    } 
    
}
class SubmitButtonListener implements ActionListener{
	JFrame frame;
	JTextField firstNameField ;  
    JTextField lastNameField ; 
    JTextField emailField ; 
    JPasswordField passwordField ;
    JComboBox <String> mode;
    private cafe mycafe = cafe.DB;;
	public SubmitButtonListener ( JFrame frame, JTextField f , JTextField l , JTextField e , JPasswordField p , JComboBox<String> m){
		this.frame = frame;
		firstNameField = f;  
		lastNameField =  l; 
		emailField =  e; 
		passwordField = p ;
		mode = m;

}
	@Override
	public void actionPerformed(ActionEvent e) {
		 String firstName = firstNameField.getText().trim();
	     String lastName = lastNameField.getText().trim();
	     String email = emailField.getText().trim();
	     String password = new String(passwordField.getPassword()).trim();
	     String modeType = (String)mode.getSelectedItem();
	     if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
         } else {
        	 try {
				validatePassword(password);
				String username = generateUsername(firstName, lastName);
				if(modeType.equals("Admin")) {
					User newUser = new Admin(firstName, lastName, email, username, password ,true);
					mycafe.addUser(newUser);
					 JOptionPane.showMessageDialog(frame, "Signup Successful! Your username is: " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
				}else {
					User newUser = new Customer(firstName, lastName, email, username, password ,true);
					mycafe.addUser(newUser);
					 JOptionPane.showMessageDialog(frame, "Signup Successful! Your username is: " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				 frame.dispose();
			} catch (PasswordException ex) {
				JOptionPane.showMessageDialog(frame, ex.getMessage(), "Signup Error", JOptionPane.ERROR_MESSAGE);
			}
        	 
         }
		
	}
	
	private static void validatePassword(String password) throws PasswordException {
        if (password.length() < 8) throw new Minimum8CharactersRequired("Must be length of 8 or longer");
        if (!password.matches(".*\\d.*")) throw new NumberCharacterMissing("Must include a number");
        if (!password.matches(".*[a-z].*")) throw new LowerCaseCharacterMissing("Must have a lowercase character");
        if (!password.matches(".*[A-Z].*")) throw new UpperCaseCharacterMissing("Must have an uppercase character");
        if (!password.matches(".*[!@#$%^&*()].*")) throw new SpecialCharacterMissing("must have a special character");
    }
	
	private static String generateUsername(String firstName, String lastName) {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);  // Generates a number from 1000 to 9999
        return "" + firstName + randomNumber;
    }
	
	
}