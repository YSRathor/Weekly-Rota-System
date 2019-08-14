package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * This class is responsible for creating a ChoresAllocation object. The object
 * uses the TreeMap data structure to store a Chore object and an
 * ArrayList[String].
 * 
 * @author Yashwant Rathor
 */

public class ChoresAllocation {

	// Field.
	/**
	 * TreeMap
	 */
	private TreeMap<Chore, ArrayList<String>> tMap;

	// Constructor.
	/**
	 * Default Constructor. Creates an empty TreeMap.
	 */
	public ChoresAllocation() {
		tMap = new TreeMap<>();
	}

	// Methods.
	/**
	 * Stores a Chore object and an ArrayList[String] to the TreeMap.
	 * 
	 * @param c
	 *            Chore to be added as key to the {@link tMap} field.
	 * @param al
	 *            ArrayList[String] to be added as value linked to a key, to the
	 *            {@link tMap} field.
	 */
	public void addAllocation(Chore c, ArrayList<String> al) {
		if (c != null && al != null) {
			tMap.put(c, al);
		}
	}

	/**
	 * Returns a collection of TreeMap values.
	 * 
	 * @return returns all of the values stored within the TreeMap.
	 */
	public Collection<ArrayList<String>> getPeople() {
		return tMap.values();
	}

	/**
	 * Returns a collection of TreeMap keys.
	 * 
	 * @return returns all of the keys stored within the TreeMap.
	 */
	public Collection<Chore> getChores() {
		return tMap.keySet();
	}

	/**
	 * Allows elements within the TreeMap to be iterated through.
	 * 
	 * @return returns an iterator over the elements in this TreeMap's set.
	 */
	public Iterator<Entry<Chore, ArrayList<String>>> returnIterator() {
		return tMap.entrySet().iterator();
	}

	/**
	 * Overrides the default toString() representation of this class.
	 */
	@Override
	public String toString() {
		return "ChoresList:[map=" + tMap + "]";
	}

}
