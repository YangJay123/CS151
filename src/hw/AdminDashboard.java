package hw;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AdminDashboard extends JFrame {

    private User admin;


    public AdminDashboard( User admin) {
        //super("Admin Dashboard");
        this.admin = admin;
       // UserManager userManager = new UserManager(); 

   		// xxx your codes
	}
    
    public void displayAdminDashboard() {
    	JFrame frame = new JFrame ("Admin Dashboard");
    	//frame.setTitle("Pug's Puncake Diner Co.");
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
        gbc.insets = new Insets(20, 50, 10, 50); 
		
    	JLabel welcomeLabel = new JLabel("Welcome, " + admin.getFirstName(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 32));
        
        JButton manageCustomer = new JButton("Manage Customer");
        JButton manageMenu = new JButton ("Manage Menu");
        JButton loginAsCustomer = new JButton ("Login as Customer");
        
       manageCustomer.addActionListener(e -> addCustomerDisplay());
       // manageMenu.addActionListener(e -> menuDisplay );
       //loginAsCustomer.addActionListener(e -> customerLogDisplay());
        
        frame.add(welcomeLabel, gbc);
        frame.add(manageCustomer, gbc);
        frame.add(manageMenu, gbc);
        frame.add(loginAsCustomer, gbc);
        
       
        frame.setVisible(true);
    }
    
    public void addCustomerDisplay() {
    	
    	CustomerManagementScreen customerManagement = new CustomerManagementScreen(admin);
    	/*
    	JFrame frame = new JFrame ("Enter User Details");
    	frame.setSize(800, 600);
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
			JOptionPane.showMessageDialog(frame, "Signup Successful! Your username is: " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
    		
    	});
    	JButton cancelButton = new JButton("cancel");
    	cancelButton.addActionListener(e -> {
    		frame.dispose();
    	});
    	
    	frame.add(new JLabel("User Type"), gbc);
    	frame.add(userType, gbc);
    	frame.add(new JLabel("First Name:"), gbc);
    	frame.add(firstNameField, gbc);
    	frame.add(new JLabel("Last Name:"), gbc);
    	frame.add(lastNameField, gbc);
    	frame.add(new JLabel("Email:"), gbc);
    	frame.add(emailField, gbc);
    	frame.add(new JLabel("Password:"), gbc);
    	frame.add(passwordField, gbc);
    	frame.add(new JLabel("Status"), gbc);
    	frame.add(userStatus, gbc);
    	frame.add(okButton,gbc);
    	frame.add(cancelButton,gbc);
    	frame.setVisible(true);
    	
    	*/
    }
    private static String generateUsername(String firstName, String lastName) {
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);  // Generates a number from 1000 to 9999
        return "" + firstName + randomNumber;
    }
}


