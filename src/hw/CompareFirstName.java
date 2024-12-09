package hw;
import java.util.* ;
public class CompareFirstName extends Compare {

	public CompareFirstName () {
		super(UserFields.FIRST_NAME, false );
	}
	public CompareFirstName ( boolean reverse ) {
		super(UserFields.FIRST_NAME, reverse );
	}

    @Override
    public int compare(User o1, User o2) {
        int result = o1.getFirstName().compareTo(o2.getFirstName());
        if(result == 0) o1.getLastName().compareTo(o2.getLastName());
        return result;
    }
};

