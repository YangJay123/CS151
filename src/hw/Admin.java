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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void orderItems(MenuItem item) throws ItemNotAvailableException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActive(boolean active) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrderedItems(List<String> orderedItems) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUserName(String userName) {
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
    
   // xxx your codes

}
