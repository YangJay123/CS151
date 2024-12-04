package hw;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class LoginScreen extends JDialog {
	
	private Map<String, User> users;
	private static cafe mycafe = cafe.DB;;
	
    public LoginScreen(JFrame parent, Map<String, User> users) {
        super(parent, "Login", true);
       // UserManager userManager = new UserManager();
        //setLayout(new BorderLayout());
       // setSize(300, 300);
        //setLocationRelativeTo(parent);

	// xxx your codes
    }
    
    public static void displayLoginForm() {
        JFrame frame = new JFrame("Login");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 50, 10, 50);

        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");
        
        Font fieldFont = new Font("Arial", Font.PLAIN, 24);
        usernameField.setFont(fieldFont);
        passwordField.setFont(fieldFont);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));

        usernameField.setBorder(BorderFactory.createEmptyBorder());
        passwordField.setBorder(BorderFactory.createEmptyBorder());

        loginButton.setBackground(new Color(200, 200, 200));
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Both username and password fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                User user = mycafe.getUser(username);
                if (user == null) {
                    JOptionPane.showMessageDialog(frame, "Username does not exist.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                } else if (!user.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Invalid password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                } else {
                	if(user instanceof Admin) {
                    JOptionPane.showMessageDialog(frame, "Login Successful! Welcome, " + user.getFirstName() + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    AdminDashboard admin = new AdminDashboard(user); 
                    admin.displayAdminDashboard();
                	} else {
                    JOptionPane.showMessageDialog(frame, "Login Successful! Welcome, " + user.getFirstName() + "! You will now go to menu selection!"
                    		, "Success", JOptionPane.INFORMATION_MESSAGE);	
                    frame.dispose();
                    //CustomerDashboard customer = new CustomerDashboard(user);
                    //customer.displayCustomerDashboard
                	}
                }
            }
        });
        cancelButton.addActionListener(e -> frame.dispose());;
        
        frame.add(new JLabel("Username:"), gbc);
        frame.add(usernameField, gbc);
        frame.add(new JLabel("Password:"), gbc);
        frame.add(passwordField, gbc);
        frame.add(loginButton, gbc);
        frame.add(cancelButton);

        frame.setVisible(true);
    }
    
}


  
