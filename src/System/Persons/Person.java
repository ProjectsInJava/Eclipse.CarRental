package System.Persons;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
public abstract class Person {

	/** The _id. */
	private String _id;

	/** The _name. */
	private String _name;

	/**
	 * Instantiates a new person.
	 */
	public Person() {
		_name = "_";
		_id = "_";
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param aName
	 *            the a name
	 * @param aID
	 *            the a id
	 */
	public Person(String aName, String aID) {
		_name = aName;
		_id = aID;
	}

	/**
	 * Gets the id.
	 *
	 * @return the string
	 */
	public String GetID() {
		return _id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the string
	 */
	public String GetName() {
		return _name;
	}

	/**
	 * Sets the id.
	 *
	 * @param aID
	 *            the a id
	 */
	public void SetID(String aID) {
		_id = aID;
	}

	/**
	 * Sets the name.
	 *
	 * @param aName
	 *            the a name
	 */
	public void SetName(String aName) {
		_name = aName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [_name=" + _name + ", _id=" + _id + "]";
	}
}
