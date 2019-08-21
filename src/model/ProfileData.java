package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * This class is responsible for creating a ProfileData object.
 * 
 * Implements Iterable to allow elements to be iterated through.
 * 
 * @author Yashwant Rathor
 */

public class ProfileData implements Iterable<Profile> {

	// Fields.
	/**
	 * An object that contains an ArrayList of profiles.
	 */
	private ArrayList<Profile> profiles;
	/**
	 * A ChoresAllocation object.
	 */
	private ChoresAllocation choresAllocation;

	// Constructor.
	/**
	 * Default Constructor.
	 */
	public ProfileData() {
		profiles = new ArrayList<>();
		choresAllocation = new ChoresAllocation();
	}

	// Methods.
	/**
	 * Allows the profiles list to be populated with a single profile.
	 * 
	 * @param p
	 *            Profile object to be added to the {@link profiles} field.
	 */
	public void addProfile(Profile p) {
		if (p != null) {
			profiles.add(p);
		}
	}

	/**
	 * Populates the allocation of chores.
	 * 
	 * @param c
	 *            ChoresAllocation object to be assigned to the
	 *            {@link choresAllocation} field.
	 */
	public void setChoresAllocation(ChoresAllocation c) {
		if (c != null) {
			choresAllocation = c;
		}
	}

	/**
	 * Removes any duplicate Profile objects from the ArrayList.
	 * 
	 * @param list
	 *            filtered ArrayList of Profile objects to the {@link profiles}
	 *            field..
	 */
	public void removeDuplicates(ArrayList<Profile> list) {
		if (profiles.size() >= 2) {
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i).getPerson().getID() == list.get(j).getPerson().getID()) {
						list.remove(j);
						j--;
					}
				}
			}
			profiles = list;
		}
	}

	/**
	 * Allows a profile to be accessed using a index position.
	 * 
	 * @param index
	 *            The index of the Profile object to be accessed.
	 * @return returns the Profile object located at the index supplied in the
	 *         parameter.
	 */
	public Profile getProfile(int index) {
		if ((index < 0 || index >= profiles.size() || profiles.isEmpty())
				|| ((index < 0 || index >= profiles.size()) && !profiles.isEmpty())) {
			return null;
		} else {
			return profiles.get(index);
		}
	}

	/**
	 * Allows all profiles stored within the ArrayList to be accessed.
	 * 
	 * @return returns all Profile objects stored within the ArrayList in sorted
	 *         order (by ID number).
	 */
	public ArrayList<Profile> getProfiles() {
		Collections.sort(profiles);
		return profiles;
	}

	/**
	 * Allows the allocation of chores to be accessed.
	 * 
	 * @return returns the choresAllocation object.
	 */
	public ChoresAllocation getChoresAllocation() {
		return choresAllocation;
	}

	/**
	 * Allows elements within profiles to be iterated through.
	 */
	@Override
	public Iterator<Profile> iterator() {
		return profiles.iterator();
	}

	/**
	 * Overrides the default toString() representation of this class.
	 */
	@Override
	public String toString() {
		return "ProfileData: [profiles=" + profiles + ", choresAllocation=" + choresAllocation + "]";
	}

}