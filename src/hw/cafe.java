package hw;
import java.io.*;
import java.util.*;

public enum cafe {
	DB; // singleton design

	private List<MenuItem> menu;
	private  Map<String, User> users;

    private cafe() { // must be private
		menu = new ArrayList<>();
		users = new HashMap<>();
		loadFile("cafeData.txt");
	}

	public synchronized boolean addUser(User u) {
		users.put(u.getUserName(), u);
		return true;
	}
	public static synchronized User getUser(String username) {
	    return DB.users.get(username);
	}
	public synchronized boolean removeUser(User u) {
		DB.users.remove(u);
		return true;
	}
	public synchronized boolean addMenuItem(MenuItem item) {
		menu.add(item);
		return true;
	}
	public synchronized Iterator<Map.Entry<String, User>> userIterator() {
		return users.entrySet().iterator();
	}
	public synchronized Iterator<MenuItem> menuIterator() {
		return menu.iterator();
	}
	private void loadFile(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scn = new Scanner(file);
			scn.nextLine();
			loadMenu(scn);
			loadUsers(scn);
        	scn.close();
			
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	private void loadMenu(Scanner scn) {
		String temp;
		Scanner lineReader;
		String itemType;
		String title;
		String id;
		String description;
		int count;
		float price;
		boolean inSeason;
		MenuItem item;
		while(scn.hasNext()) {
			temp = scn.nextLine();
			if(temp.equals("Users:")) break;
			lineReader = new Scanner(temp);
			lineReader.useDelimiter(";");
			itemType = lineReader.next();
			title = lineReader.next();
			id = lineReader.next();
			description = lineReader.next();
			price = lineReader.nextFloat();
			count = lineReader.nextInt();
			inSeason = lineReader.nextBoolean();
			
			if(itemType.equals("Pancake")) {
				item = new PancakeMenuItem(title, id, description, price, count, inSeason);
				
			} else {
				item = new DinerMenuItem(title, id, description, price, count, inSeason);
			}
		
			
		}
		
	}
	private void loadUsers(Scanner scn) {
		Scanner lineReader;
		String type;
		String first;
		String last;
		String email;
		String username;
		String pw;
		boolean active;
		User user;
		while(scn.hasNext()) {
			lineReader = new Scanner(scn.nextLine());
			lineReader.useDelimiter(";");
			type = lineReader.next();
			first = lineReader.next();
			last = lineReader.next();
			email = lineReader.next();
			username = lineReader.next();
			pw = lineReader.next();
			active = lineReader.nextBoolean();
			
			if(type.equals("Customer")) {
				user = new Customer(first, last, email, username, pw, active);
			}
			else {
				user = new Admin(first, last, email, username, pw, active);
			}
			addUser(user);
		}
		
	}
}
