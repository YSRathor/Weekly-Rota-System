package model;

/**
 * This class is responsible for creating a Person object.
 * 
 * Implements Comparable to allow elements to be compared.
 * 
 * @author Yashwant Rathor
 */

public class Person implements Comparable<Person> {

	// Fields.
	/**
	 * A person's forename.
	 */
	private String firstName;
	/**
	 * A person's surname.
	 */
	private String lastName;
	/**
	 * A person's nickname.
	 */
	private String nickName;
	/**
	 * An identification number unique to each person.
	 */
	private int ID;

	// Constructors.
	/**
	 * Custom Constructor with no nickname field parameter.
	 * 
	 * @param firstName
	 *            Forename of a person.
	 * @param lastName
	 *            Surname of a person.
	 * @param ID
	 *            Identification number of a person.
	 * 
	 * @throws IllegalArgumentException
	 *             If firstName or lastName parameters are empty or null.
	 */
	public Person(String firstName, String lastName, int ID) {
		if (firstName.trim().isEmpty() || firstName == null) {
			throw new IllegalArgumentException("You must enter in a first name!");
		}
		if (lastName.trim().isEmpty() || lastName == null) {
			throw new IllegalArgumentException("You must enter in a last name!");
		}
		if (ID < 0) {
			throw new IllegalArgumentException("You must enter in a positive ID value!");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		nickName = "";
		this.ID = ID;
	}

	/**
	 * Custom Constructor 2 with nickname field parameter
	 * 
	 * @param firstName
	 *            Forename of a person.
	 * @param lastName
	 *            Surname of a person
	 * @param nickName
	 *            Nickname of a person.
	 * @param ID
	 *            Identification number of a person.
	 * 
	 * @throws IllegalArgumentException
	 *             If firstName, lastName or nickName parameters are empty or null.
	 */
	public Person(String firstName, String lastName, String nickName, int ID) {
		if (firstName.trim().isEmpty() || firstName == null) {
			throw new IllegalArgumentException("You must enter in a first name!");
		}
		if (lastName.trim().isEmpty() || lastName == null) {
			throw new IllegalArgumentException("You must enter in a last name!");
		}
		if (nickName.trim().isEmpty() || nickName == null) {
			throw new IllegalArgumentException("You must enter in a nick name!");
		}
		if (ID < 0) {
			throw new IllegalArgumentException("You must enter in a positive ID value!");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.ID = ID;
	}

	// Methods.

	/**
	 * Ensures that the firstName is returned with the correct formatting.
	 * 
	 * @return returns firstName with every word capitalised.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Ensures that the lastName is returned with the correct formatting.
	 * 
	 * @return returns lastName with every word capitalised.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Ensures that the nickName is returned with the correct formatting.
	 * 
	 * @return returns nickName with every word capitalised.
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Allows a full name String to be generated from a person's forename, surname
	 * and nickname.
	 * 
	 * @return a combined String which represents a person's full name.
	 */
	public String getFullName() {
		if (!nickName.trim().isEmpty()) {
			return firstName + " '" + nickName + "' " + lastName;
		} else {
			return firstName + " " + lastName;
		}
	}

	/**
	 * Allows a person's ID number to be accessed.
	 * 
	 * @return returns the unique ID value.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Checks if two Person objects have the same values.
	 */
	@Override
	public boolean equals(Object obj) {
		// test exceptional cases, i.e. obj not null and is a Person
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		Person other = (Person) obj; // downcast to a Person object

		// compare first, last and nick names using String's .equals() method
		return this.lastName.equals(other.lastName) && this.firstName.equals(other.firstName)
				&& this.nickName.equals(other.nickName);
	}

	/**
	 * Compares two Person objects with each other.
	 */
	@Override
	public int compareTo(Person other) {
		int result = this.lastName.compareTo(other.lastName);

		if (result == 0) {
			result = this.firstName.compareTo(other.firstName);
		}
		if (result == 0) {
			result = this.nickName.compareTo(other.nickName);
		}
		return result;
	}

	/**
	 * Overrides the default toString() representation of this class.
	 */
	@Override
	public String toString() {
		return "Person: [firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName + ", ID=" + ID
				+ "]";
	}

}
