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
}
