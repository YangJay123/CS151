package hw;
import java.util.* ;
public class CompareUserName extends Compare {

	public CompareUserName () {
		super(UserFields.LAST_NAME, false );
	}
	public CompareUserName ( boolean reverse ) {
		super(UserFields.LAST_NAME, reverse );
	}

    @Override
    public int compare(User o1, User o2) {

        int result = o1.getLastName().compareTo(o2.getLastName());
        if(result == 0) result = o1.getUserName().compareTo(o2.getUserName());
        return result;

    }
};

