package hw;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public enum cafe {
	DB; // singleton design

	private List<MenuItem> menu;
	private  Map<String, User> users;

    private cafe() { // must be private
		menu = new ArrayList<>();
		users = new HashMap<>();
	}

   		// xxx your codes
	public synchronized boolean addUser(User u) {
		users.put(u.getUserName(), u);
		return true;
	}
	public static synchronized User getUser(String username) {
	    return DB.users.get(username);
	}
}
