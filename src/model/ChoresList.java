package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is responsible for creating an object which can store a list of
 * Chores.
 * 
 * Implements Iterable to allow elements to be iterated through.
 * 
 * @author Yashwant Rathor
 */

public class ChoresList implements Iterable<Chore> {

	// Field.
	/**
	 * List of chores.
	 */
	private ArrayList<Chore> choresList;

	// Constructor.
	/**
	 * Default Constructor.
	 */
	public ChoresList() {
		choresList = new ArrayList<>();
	}

	// Methods.
	/**
	 * Adds a non-null Chore object to the list.
	 * 
	 * @param c
	 *            the Chore object to be added to {@link choresList} field.
	 */
	public void addChore(Chore c) {
		if (c != null) {
			choresList.add(c);
		}
	}

	/**
	 * Allows a Chore object to be retrieved from the choresList.
	 * 
	 * @param index
	 *            the index to be accessed from the choresList.
	 * @return returns the Chore object located at the supplied index.
	 */
	public Chore getChore(int index) {
		if ((index < 0 || index >= choresList.size() || choresList.isEmpty())
				|| ((index < 0 || index >= choresList.size()) && !choresList.isEmpty())) {
			return null;
		} else {
			return choresList.get(index);
		}
	}

	/**
	 * Allows the size of the choresList to be returned.
	 * 
	 * @return returns the size of the list.
	 */
	public int choresListSize() {
		return choresList.size();
	}

	/**
	 * Allows elements within choresList to be iterated through.
	 */
	@Override
	public Iterator<Chore> iterator() {
		return choresList.iterator();
	}

	/**
	 * Overrides the default toString() representation of this class.
	 */
	@Override
	public String toString() {
		return "ChoresList: [ChoresList=" + choresList + "]";
	}
}
