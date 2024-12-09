package hw;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {
	cafe myCafe = cafe.DB;
	ArrayList<User> m_users = new ArrayList<User> ();
	HashMap <String, Comparator<User> > m_comparator = new HashMap<> ();

	
	public UserManager() {
		
    }
	
	public UserManager(String fn) {
		
	}
	/*
	public ArrayList<User> loadUsersFromTextFile ( String filename ) {
		try {
        	File file = new File( filename );
        	Scanner fileInput = new Scanner(file);
        	while (fileInput.hasNextLine()) {   
            	String temp = fileInput.nextLine();
            	if (temp.trim().length() > 0) {  
					User newUser = foo ( fileInput, temp );
					m_users.add ( newUser );
            	}
        	}
        	fileInput.close();
		} catch (IOException ex ) {
            System.out.println(ex.getMessage());
		}
		return m_users;
    }
	
	private User foo (String info) {
		
		Scanner scanner = new Scanner(info);
		scanner.useDelimiter(";");
		
        User newUser;  // create a new user object
        Boolean b =   temp.equals ("active")   ;
        newUser.setActive(b); // set the first thing read in to firstName
        newUser.setFirstName( fileInput.nextLine() ); // set the first thing read in to firstName
        newUser.setLastName(fileInput.nextLine());  // files reads line by line, so do .nextLine
        newUser.setEmail(fileInput.nextLine());
        newUser.setPassword(fileInput.nextLine());
        newUser.setLibraryCardNum(fileInput.nextLine());

        // if there is next line, it is checkout book isbn
        while (fileInput.hasNextLine()) {
            try {
                String tempLine = fileInput.nextLine(); // first thing we read from txt
                if (tempLine.trim().length() == 0) {   // break when no more lines to read
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        // System.out.println ( newUser );
	return newUser ;
}*/
}
