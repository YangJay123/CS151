package hw;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDashboard extends JFrame {

	private UserManager userManager;
	private User currentUser; // The user who is currently logged in

	private JPanel cartPane =  new JPanel ();
	private JPanel billPane =  new JPanel ();
	private JPanel menuPane =  new JPanel ();
	private StyledDocument cartDoc;
	private StyledDocument billDoc;
	private StyledDocument menuDoc;

	private JCheckBox breakfastCheckbox;
	private JCheckBox dinnerCheckbox;

	private JPanel tipPanel;
	private ButtonGroup tipGroup;
	private JRadioButton noTipButton;
	private JRadioButton tenPercentButton;
	private JRadioButton fifteenPercentButton;
	private JRadioButton twentyPercentButton;

   	// xxx your codes
	
	public CustomerDashboard(User u) {
		currentUser = u;
		displayCustomerDashboard();
	}
	
	
	public void displayCustomerDashboard() {
		setTitle("Customer Management Dashboard");
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(10, 50, 10, 50);  
		
		JPanel foodType = Foody();
		JPanel cart = addPanes();
	    JPanel tip = tipPanel();
		JPanel choice = choiceButtons();
	    JPanel sort = sortSearch();
	    
		this.add(foodType, gbc);
		this.add(cart, gbc);
		this.add(tip, gbc);
		this.add(choice, gbc);
		this.add(sort, gbc);
		this.show();
	}
	
	
	public JPanel Foody() {
		JPanel p = new JPanel ();
		JCheckBox dinnerCheckbox = new JCheckBox ("Dinner");
		JCheckBox breakfastCheckbox = new JCheckBox ("Breakfast");
		JLabel name = new JLabel(currentUser.getFirstName() + " " + currentUser.getLastName() + ": " + currentUser.getUserName());
		JButton logOut = new JButton("LogOut");
		
		p.add(dinnerCheckbox);
		p.add(breakfastCheckbox);
		p.add(name);
		p.add(logOut);
		p.setBounds (50,400,500, 30);
		
		logOut.addActionListener(e -> this.dispose());
		
		return p;
	}
	
	public JPanel addPanes() {
		JPanel p = new JPanel ();
		cartPane.setLayout(new BoxLayout(cartPane, BoxLayout.Y_AXIS));
		billPane.setLayout(new BoxLayout(billPane, BoxLayout.Y_AXIS));
		menuPane.setLayout(new BoxLayout(menuPane, BoxLayout.Y_AXIS)); 
		
		JLabel blankLabel2 = new JLabel("                                Cart                                       ");
        JLabel blankLabel1 = new JLabel("                                Bill                                     ");
        JLabel blankLabel3 = new JLabel("                                Cafe Menu                                     ");
		
        cartPane.add(blankLabel2);
        billPane.add(blankLabel1);
        menuPane.add(blankLabel3);
        
        JScrollPane cartScroll = new JScrollPane(cartPane);
        JScrollPane billScroll= new JScrollPane(billPane);
        JScrollPane menuScroll= new JScrollPane(menuPane);
        
        p.add(cartScroll);
        p.add(menuScroll);
        p.add(billScroll);
        
		return p;
	}
	
	public JPanel tipPanel() {
		JPanel p = new JPanel ();
		noTipButton = new JRadioButton("No tip");
		tenPercentButton = new JRadioButton("10% tip");;
		fifteenPercentButton = new JRadioButton("15% tip");;
		twentyPercentButton = new JRadioButton("20% tip");;
		
		
		
		p.add(noTipButton);
		p.add(tenPercentButton);
		p.add(fifteenPercentButton);
		p.add(twentyPercentButton);
		
		BoxLayout layout = new BoxLayout(p, BoxLayout.X_AXIS);
		 
		p.setLayout(layout);
		return p;
		
	}
	
	public JPanel choiceButtons() {
		JPanel p = new JPanel ();
		JButton cancel = new JButton("Cancel");
		JButton order = new JButton("Order");
		JButton add = new JButton("Add to Cart");
		
		p.add(cancel);
		p.add(order);
		p.add(add);
		
		BoxLayout layout = new BoxLayout(p, BoxLayout.X_AXIS);
		p.setLayout(layout);
		
		return p;
	}
	
	public JPanel sortSearch() {
		JPanel p = new JPanel ();
		
		final JLabel lblSort  = new  JLabel( "Sort Order" );
		final JLabel lblSeacrhSort  = new  JLabel( "Search/Sort by" );
		String[] searchSort = { "title", "description" , "ItemID ", "price"};
		String[] criteria = { "Ascedning", "Descending" };
		
		JTextField text = new JTextField(10);
		
		JComboBox<String> JCombcbxSortCriteria = new  JComboBox<>( criteria );
		JComboBox<String> JCombcbxSearchSortCriteria = new  JComboBox<>( searchSort );
		
		JButton sort = new JButton("Sort");
		JButton search = new JButton("Search");
		
		
		
		p.add(lblSort);
		p.add(JCombcbxSortCriteria);
		p.add(lblSeacrhSort);
		p.add(JCombcbxSearchSortCriteria);
		p.add(sort);
		p.add(text);
		p.add(search);
		
		
		
		return p;
	}
}
