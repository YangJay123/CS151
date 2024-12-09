package hw;
import java.util.* ;
public abstract class Compare implements Comparator<User> {

   	boolean m_reverse ;
    UserFields m_field ; 

    public Compare ( UserFields x, boolean reverse ) {
		super();
        m_reverse = reverse ;
		m_field = x;
    }


	String getFieldName () {
		return m_field.toString ();
	}

    @Override
    public abstract int compare(User o1, User o2) ;

    @Override
    public String toString () {
        String s = this.getClass().getName();
        if (m_reverse ) s += " (reverse)" ;
        return s ;
    }

};

