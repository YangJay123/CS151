package hw;
import javax.swing.*;
import javax.swing.text.*;



import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CustomerManagementScreen extends JFrame {

	private UserManager userManager;
	private User currentUser; // The user who is currently logged in
	private JTextPane inactiveCustomersPane;
	private JTextPane activeCustomersPane;
	private JComboBox<String> userTypeComboBox;
	private Map<String, String> nameToUserNameMap = new HashMap<>();
	private boolean noUsers = true;
	
	JButton btnExit = new JButton ("Exit" );
    JButton btnSort   = new JButton("Sort"); // 
	JButton btnSearch   = new JButton("Search"); //
	JPanel unactiveUsers = new JPanel();
    JPanel activeUsers = new JPanel();
    JComboBox cbxSortCriteria ; 
    JComboBox cbxSearchCriteria ;

//	JRadioButton btnAscending = new JRadioButton ( "Ascending" );
//	JRadioButton btnDescending = new JRadioButton ( "Descending" );
	JComboBox<String> comboBox = new JComboBox();
	
	JTextField txtSearch   = new JTextField(10);

	public CustomerManagementScreen(User admin) {
		currentUser = admin;
		setup();
		
	}
	
	private void setup() {
		setTitle("Customer Management Dashboard");
		setSize(800, 800);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlTop = buildPnlTop ();
		JPanel userDisplayPanel =  buildUserDisplayPanel ( );
		JPanel pnlSort   = buildPnlSort ();
		JPanel pnlSearch   = buildPnlSearch ();
		


            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.insets = new Insets(10, 50, 10, 50);  
            
            
        	this.add(pnlTop, gbc);                                    
        	this.add(userDisplayPanel, gbc);
        	
        	this.add(pnlSort, gbc);
        	this.add(pnlSearch, gbc);
        	this.show();
	}
	

    public JPanel buildPnlTop  ( ) {
		JPanel p = new JPanel ();
		JLabel lblTitle = new JLabel ( "Pug Petting Cafe Users" ) ;
        p.add( lblTitle );
		p.add (btnExit);
		p.setBounds (50,50,600, 30);		
		return p ;
	}

    public JPanel buildUserDisplayPanel  ( ) {
		JPanel 	   p = new JPanel();
        BoxLayout layout = new BoxLayout(p, BoxLayout.Y_AXIS);
        p.setLayout(layout);    
        
        JPanel scroll = buildUsersScrollPanes ();

        p.add(scroll);
		p.setBounds ( 50,100,600, 300);
		p.setBackground(Color.green);

		return p ;
	}
    
    public JPanel buildUsersScrollPanes  ( ) {

        activeUsers.setLayout(new BoxLayout(activeUsers, BoxLayout.Y_AXIS));
        unactiveUsers.setLayout(new BoxLayout(unactiveUsers, BoxLayout.Y_AXIS));
        if(noUsers) {
        	noUsers = !noUsers;
            JLabel blankLabel2 = new JLabel("                                Active                                       ");
            JLabel blankLabel1 = new JLabel("                                Unactive                                     ");
            unactiveUsers.add(blankLabel1);
        	activeUsers.add(blankLabel2);
        }

        Iterator iterator = cafe.DB.userIterator();
        while(iterator.hasNext()) {
        	Map.Entry u = (Map.Entry) iterator.next();
        	User user = (User) u.getValue();
        	JLabel label = new JLabel(user.getFirstName() + ", " + user.getLastName());
        	if(user.isActive()) {
        		activeUsers.add(label);
        	} else {
        		unactiveUsers.add(label);
        	}
        }
    	noUsers = !noUsers;
        JLabel blankLabel3 = new JLabel("                                                                              ");
        JLabel blankLabel4 = new JLabel("                                                                              ");

    	activeUsers.add(blankLabel3);
    	unactiveUsers.add(blankLabel4);
    	JScrollPane left = new JScrollPane(unactiveUsers);
    	JScrollPane right = new JScrollPane(activeUsers);

    	JPanel panel =  new JPanel();
    	panel.add(left);
    	panel.add(right);
        return panel;

	}

    public JPanel buildPnlSort  ( ) {
    		ButtonGroup rbgOrder = new ButtonGroup();
//      		rbgOrder.add(btnAscending);
//      		rbgOrder.add(btnDescending);
//			btnAscending.setSelected(true);
			comboBox.addItem("Ascending");
			comboBox.addItem("Descending");

        	final JLabel lblSort  = new  JLabel( "Sort By" );
        	String[] criteria = { "First Name", "Last Name" };
        	cbxSortCriteria = new  JComboBox( criteria );
    
        	JButton sortUsersButton   = new JButton("sort"); //

			JPanel p = new JPanel() ;
        	BoxLayout layout = new BoxLayout(p, BoxLayout.X_AXIS);

        	p.setLayout(layout);
        	p.add(lblSort);
        	p.add(cbxSortCriteria);
 //       	p.add(btnAscending);
 //       	p.add(btnDescending);
        	p.add(comboBox);
        	p.add(btnSort);

			p.setBounds (50,400,500, 30);

			return p ;
	}
    


    public JPanel buildPnlSearch  ( ) {
        	final JLabel lblSearch  = new  JLabel( "Search By" );
        	String[] criteria = { "All Fields", "Last Name", "First Name", "Username" };
    		cbxSearchCriteria = new  JComboBox( criteria );

			JPanel p = new JPanel() ;
        	BoxLayout layout = new BoxLayout(p, BoxLayout.X_AXIS);
        	p.setLayout(layout);
        	p.add(lblSearch);
        	p.add(cbxSearchCriteria);

        	p.add( txtSearch);
        	p.add(btnSearch);

			p.setBounds (50,450,500, 30);

			return p ;
	}

    public static void main(String[] args) {
		new CustomerManagementScreen(null);
	}
	
}
