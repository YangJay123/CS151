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
	public List<String> getOrderedItems() {
		return this.orderedItems;
	}

	@Override
	public String getRole() {
		return "customer";
	}

	@Override
	public void orderItems(MenuItem item) throws ItemNotAvailableException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrderedItems(List<String> orderedItems) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelItem(MenuItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canPlace() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toDataString() {
		// TODO Auto-generated method stub
		return null;
	}
    
}
