package hw;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hw.CustomExceptions.ItemNotAvailableException;

public class Customer implements User, Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private boolean isActive;
    private List<String> orderedItems;
    private static final int MAX_ORDER_LIMIT = 10;

    public Customer(String firstName, String lastName, String email, String userName, String password, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.isActive = isActive;
        this.orderedItems = new ArrayList<>();
    }
    
	// xxx your codes
    public String getFirstName() {
    	return this.firstName;
    }
    
    public String getLastName() {
    	return this.lastName;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public String getUserName() {
    	return this.userName;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setUserName(String s) {
    	this.userName = s;
    }
    
    public boolean isActive() {
    	return this.isActive;
    }
    
    public void setActive(boolean b) {
    	this.isActive = b;
    }

	@Override
	public int compareTo(User o) {
		return 0;
	}

	@Override
	public List<String> getOrderedItems() {
		return this.orderedItems;
	}

	@Override
	public String getRole() {
		return "customer";
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
	public void setOrderedItems(List<String> orderedItems) {
		this.orderedItems = orderedItems;
	}

	@Override
	public void cancelItem(MenuItem item) {
		orderedItems.remove(item.toDataString());
		
	}

	@Override
	public boolean canPlace() {
		if (this.orderedItems.size() < MAX_ORDER_LIMIT) {
			return true;
		} else return false;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toDataString() {
		return this.toString();
	}
    
}
