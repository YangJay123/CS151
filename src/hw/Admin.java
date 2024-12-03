package hw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hw.CustomExceptions.ItemNotAvailableException;

public class Admin implements User, Serializable {
	private static final long serialVersionUID = 1L;
	
	private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private boolean isActive;
    private List<String> orderedItems;
    private static final int MAX_ORDER_LIMIT = 10;

    // Constructor to initialize a Admin object 
    public Admin(String firstName, String lastName, String email, String userName, String password, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.isActive = isActive;
        this.orderedItems = new ArrayList<>();
    }

	@Override
	public int compareTo(User o) {
		return this.userName.compareTo(o.getUserName());
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isActive() {
		return isActive;
	}

	@Override
	public List<String> getOrderedItems() {
		return this.orderedItems;
	}

	@Override
	public String getRole() {
		return "Admin";
	}

	@Override
	public void orderItems(MenuItem item) throws ItemNotAvailableException {
		if(!item.isAvailable()) {
			throw new ItemNotAvailableException("Item is not available: " + item.toDataString());
		} 	
		if(!canPlace()) {
			 throw new IllegalStateException("Cannot order more than " + MAX_ORDER_LIMIT + " items.");
		}
		this.orderedItems.add(item.toDataString());
		
	}

	@Override
	public void setActive(boolean active) {
		this.isActive = active;
		
	}

	@Override
	public void setOrderedItems(List<String> orderedItems) {
		this.orderedItems = orderedItems;
		
	}

	@Override
	public void setUserName(String userName) {
		this.setUserName(userName);
		
	}

	@Override
	public void cancelItem(MenuItem item) {
		this.orderedItems.remove(item.toDataString());
		
	}

	@Override
	public boolean canPlace() {
		if (this.orderedItems.size() < MAX_ORDER_LIMIT) {
			return true;
		} else return false;
	}

	@Override
	public String getDetails() {
		return null;
	}

	@Override
	public String toDataString() {
		return this.toString();
	}
    
   // xxx your codes

}
