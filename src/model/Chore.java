package model;

/**
 * This class is responsible for creating a Chore object.
 * 
 * Implements Comparable to allow elements to be compared.
 * 
 * @author Yashwant Rathor
 */

public class Chore implements Comparable<Chore> {

	// Fields.
	/**
	 * Name of the chore.
	 */
	private String choreName;
	/**
	 * Time taken to complete chore.
	 */
	private int choreTime;

	// Constructor.
	/**
	 * Custom constructor.
	 * 
	 * Creates a Chore object with two input parameters.
	 * 
	 * @param choreName
	 *            Name of the chore.
	 * @param choreTime
	 *            Time taken to complete the chore.
	 * @throws IllegalArgumentException
	 *             If choreName is empty or null.
	 * 
	 */
	public Chore(String choreName, int choreTime) {
		if (choreName.trim().isEmpty() || choreName == null) {
			throw new IllegalArgumentException("You must enter in a chore name!");
		}
		if (choreTime < 0) {
			throw new IllegalArgumentException("You must enter in a positive int value!");
		}
		this.choreName = choreName;
		this.choreTime = choreTime;
	}

	// Methods.
	/**
	 * Allows choreName to be assigned a valid value from an input parameter.
	 * 
	 * @param s
	 *            The String to be assigned to the {@link choreName} field, if
	 *            s.trim() is not empty.
	 */
	public void setChoreName(String s) {
		if (!s.trim().isEmpty() && s != null) {
			choreName = s;
		}
	}

	/**
	 * Allows choreTime to be assigned a value from an input parameter.
	 * 
	 * @param i
	 *            The int to be assigned to the {@link choreTime} field.
	 */
	public void setChoreTime(int i) {
		if (i >= 0) {
			choreTime = i;
		}
	}

	/**
	 * Ensures that the choreName is returned with the correct formatting.
	 * 
	 * @return returns choreName with every word capitalised.
	 */
	public String getChoreName() {
		char characters[] = choreName.toCharArray();
		for (int i = 0; i < choreName.length(); i++) {
			if (i == 0 && characters[i] != ' ' || characters[i] != ' ' && characters[i - 1] == ' ') {
				if (characters[i] >= 'a' && characters[i] <= 'z') {
					characters[i] = (char) (characters[i] - 'a' + 'A');
				}
			} else if (characters[i] >= 'A' && characters[i] <= 'Z')
				characters[i] = (char) (characters[i] + 'a' - 'A');
		}
		choreName = new String(characters).trim();
		return choreName;
	}

	/**
	 * Allows the choreTime value to be accessed.
	 * 
	 * @return returns the choreTime.
	 */
	public int getChoreTime() {
		return choreTime;
	}

	/**
	 * Checks if two Chore objects have the same values.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		Chore other = (Chore) obj;

		return this.choreName.equals(other.choreName) && this.choreTime == (other.choreTime);
	}

	/**
	 * Compares two Chore objects with each other.
	 */
	@Override
	public int compareTo(Chore other) {
		int result = this.choreName.compareTo(other.choreName);

		if (result == 0) {
			result = Integer.compare(this.choreTime, other.choreTime);
		}

		return result;
	}

	/**
	 * Overrides the default toString() representation of this class.
	 */
	@Override
	public String toString() {
		return "Chore: [choreName=" + choreName + ", choreTime=" + choreTime + "]";
	}

}
