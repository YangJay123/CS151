package hw;

enum UserFields {
	FIRST_NAME ("First Name" ),
	LAST_NAME ("Last Name" ),
	Username ("User Name" ),;


	String m_name ;
	UserFields (String s) {
		m_name = s ;
	}
	@Override
	public String toString () {
		return m_name ;
	}
}
