package hw;
import java.util.* ;
public class CompareLastName extends Compare {

	public CompareLastName () {
		super(UserFields.LAST_NAME, false );
	}
	public CompareLastName ( boolean reverse ) {
		super(UserFields.LAST_NAME, reverse );
	}

    @Override
    public int compare(User o1, User o2) {
        int result = o1.getLastName().compareTo(o2.getLastName());
        if(result == 0) result = o1.getFirstName().compareTo(o2.getFirstName());
        return result;
    }
};

