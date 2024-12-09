package hw;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class AddCustomerDashboard extends JFrame {
	public AddCustomerDashboard() {
		setTitle("Enter User Details");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		// xxx specify that the component's display area will be from gridx to 
		// xxx the last cell in the row
        gbc.gridwidth = GridBagConstraints.REMAINDER;
		// xxx Make the component wide enough to fill its display area horizontally, 
		// xxx but do not change its height.
        gbc.fill =      GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 50, 1, 10); 

        String[] typeTemp = { "Admin", "Customer" };
        String[] status = { "active", "inactive" };
        JComboBox<String> userType = new JComboBox<>(typeTemp);
        JComboBox<String> userStatus = new JComboBox<>(status);
        JTextField firstNameField = new JTextField(20);
      	JTextField lastNameField = new JTextField(20);
      	JTextField emailField = new JTextField(20);
    	JPasswordField passwordField = new JPasswordField(20);
    	JButton okButton = new JButton("ok");
    	okButton.addActionListener(e -> {
    		String first = firstNameField.getText().trim();
    		String last = lastNameField.getText().trim();
    		String email = emailField.getText().trim();
    		String pw = new String(passwordField.getPassword()).trim();
    		if(first.isEmpty() || last.isEmpty() || email.isEmpty() || pw.isEmpty()) return;
    		String username = generateUsername(first, last);
    		boolean active = userStatus.getSelectedItem().equals("active");
    		User newUser;
    		if(((String)userType.getSelectedItem()).equals("Admin")) {
    			newUser = new Admin(first, last, email, username, pw, active);
    		} else {
    			newUser = new Customer(first, last, email, username, pw, active);
    		}
    		cafe.DB.addUser(newUser);
			JOptionPane.showMessageDialog(this, "Signup Successful! Your username is: " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
    		
    	});
    	JButton cancelButton = new JButton("cancel");
    	cancelButton.addActionListener(e -> {
    		this.dispose();
    	});
    	
    	this.add(new JLabel("User Type"), gbc);
    	this.add(userType, gbc);
    	this.add(new JLabel("First Name:"), gbc);
    	this.add(firstNameField, gbc);
    	this.add(new JLabel("Last Name:"), gbc);
    	this.add(lastNameField, gbc);
    	this.add(new JLabel("Email:"), gbc);
    	this.add(emailField, gbc);
    	this.add(new JLabel("Password:"), gbc);
    	this.add(passwordField, gbc);
    	this.add(new JLabel("Status"), gbc);
    	this.add(userStatus, gbc);
    	this.add(okButton,gbc);
    	this.add(cancelButton,gbc);
    	this.setVisible(true);
		
	}
	private static String generateUsername(String firstName, String lastName) {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);  // Generates a number from 1000 to 9999
        return "" + firstName + randomNumber;
    }
}
