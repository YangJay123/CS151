package hw;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;


public class SignupScreen extends JDialog {

	private CafeOnlineOrderSystemGUI mainGUI;
    private cafe mycafe;
    
    public SignupScreen(CafeOnlineOrderSystemGUI parent, cafe pugCafe) {
    	 super(parent, "Signup", true);
    	 setLayout(new BorderLayout());
         setSize(300, 300);
         setLocationRelativeTo(parent);
    }
   		// xxx your codes

}