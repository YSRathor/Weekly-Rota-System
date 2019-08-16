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

	// Methods
	/**
	 * Allows the choreName value to be accessed.
	 * 
	 * @return returns choreName.
	 */
	public String getChoreName() {
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
