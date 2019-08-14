package model;

import view.HelperMethods;

/**
 * This class is responsible for creating a Profile object.
 * 
 * @author Yashwant Rathor
 */

public class Profile {

	// Fields.
	/**
	 * A Person object.
	 */
	private Person person;
	/**
	 * A Boolean value for whether a nickname is to be used or not.
	 */
	private Boolean useNickName;

	/**
	 * A ChoresList object.
	 */
	private ChoresList chores;
	/**
	 * An int value to store the number of chores for each Profile.
	 */
	private int noOfChores;
	/**
	 * An int value to store the combined time needed to complete all chores.
	 */
	private int totalChoreTime;
	/**
	 * An int value to store the average time needed to complete a chore.
	 */
	private int averageChoreTime;
	/**
	 * A String value to store the filepath to where the text file will be created
	 * and written to.
	 */
	private String filePath;
	/**
	 * A String value to represent a (-) division of a dynamic length.
	 */
	private String seperator;
	/**
	 * A String value to represent a (-) division of a fixed length.
	 */
	private String seperator2;
	/**
	 * A String value to represent the title line for a text file.
	 */
	private String titleLine;
	/**
	 * A String value to represent the current Date line for a text file.
	 */
	private String currentDateLine;
	/**
	 * A String value to represent the week commencing Date line for a text file.
	 */
	private String wcDateLine;
	/**
	 * A String value to represent the total line for a text file.
	 */
	private String totalLine;

	// Constructor.
	/**
	 * Custom Constructor.
	 * 
	 * @param person
	 *            A Person object to be assigned to person.
	 * @param useNickName
	 *            A Boolean value to be assigned to useNickName.
	 * 
	 * @throws NullPointerException
	 *             If person or useNickname are null.
	 */
	public Profile(Person person, Boolean useNickName) {
		if (person == null) {
			throw new NullPointerException("You must provide a Person!");
		}
		if (useNickName == null) {
			throw new NullPointerException("You must enter in a true/false value!");
		}
		this.person = person;
		this.useNickName = useNickName;
		chores = new ChoresList();
		noOfChores = 0;
		totalChoreTime = 0;
		averageChoreTime = 0;
		filePath = "C:/Users/yashw/Desktop/Misc/Rota_System/Chores for " + person.getFirstName() + ".txt";
		seperator = "";
		seperator2 = "-----------------------------------";
		titleLine = "\r\n" + person.getFirstName() + "'s Chores for Week " + HelperMethods.getWeek() + ":\r\n";
		currentDateLine = "Date: " + HelperMethods.getCurrentDate() + "\r\n";
		wcDateLine = "W/C:  " + HelperMethods.getCurrentWCDate() + "\r\n";
		totalLine = "";
	}

	// Methods.
	/**
	 * Adds a non-null Chore object to the list.
	 * 
	 * @param c
	 *            the Chore object to be added to {@link chores} field.
	 */
	public void addChore(Chore c) {
		if (c != null) {
			chores.addChore(c);
		}
	}

	/**
	 * Stores the numbers of chores for a profile.
	 * 
	 * @param i
	 *            number of chores to be assigned to {@link noOfChores} field.
	 */
	public void countChores(int i) {
		noOfChores = i;
	}

	/**
	 * Allows a list of chores to be accessed.
	 * 
	 * @return returns a list of all chores for a profile.
	 */
	public ChoresList getAllChores() {
		return chores;
	}

	/**
	 * Allows person's details to be accessed.
	 * 
	 * @return returns a Person object.
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Allows the total time required to complete all chores to be accessed.
	 * 
	 * @return returns the String of the totalChoreTime in hours and minutes.
	 */
	public String getTotalChoreTimeOutput() {
		for (Chore c : chores) {
			totalChoreTime = totalChoreTime + c.getChoreTime();
		}

		String formattedTotalTime = "\r\nTotal Time:    " + String.format("%d Hours", totalChoreTime / 60) + " & "
				+ String.format("%02d Minutes", totalChoreTime % 60);

		return formattedTotalTime;
	}

	/**
	 * Allows the average time required to complete a chore to be accessed.
	 * 
	 * @return returns the String of the averageChoreTime in hours and minutes.
	 */
	public String getAverageChoreTimeOutput() {
		String formattedAverageTime = "";
		if (noOfChores != 0) {
			averageChoreTime = totalChoreTime / noOfChores;

			formattedAverageTime = "\r\nAverage Time:  " + String.format("%d Hours", averageChoreTime / 60) + " & "
					+ String.format("%02d Minutes", averageChoreTime % 60);
		} else {
			formattedAverageTime = "\r\nAverage Time:  " + "0 Hours" + " & " + "00 Minutes";
		}
		return formattedAverageTime;
	}

	/**
	 * Allows a profile's filepath to be accessed.
	 * 
	 * @return returns the String of the filepath to store data for a profile.
	 */
	public String getFilePath() {
		if (useNickName == true && !person.getNickName().trim().isEmpty()) {
			filePath = "C:/Users/yashw/Desktop/Misc/Rota_System/Chores for " + person.getNickName() + ".txt";
			return filePath;
		} else {
			return filePath;
		}
	}

	/**
	 * Allows a profile's title line to be accessed.
	 * 
	 * @return returns the String for the titleLine to be inputed in the profile's
	 *         text file.
	 */
	public String getTitle() {
		if (useNickName == true && !person.getNickName().trim().isEmpty()) {
			titleLine = "\r\n" + person.getNickName() + "'s Chores for Week " + HelperMethods.getWeek() + ":\r\n";
			return titleLine;
		} else {
			return titleLine;
		}
	}

	/**
	 * Allows the separator String value to be accessed.
	 * 
	 * @return returns a String with a length dependent on the length of the
	 *         titleLine.
	 */
	public String getSeperator() {
		for (int i = 0; i < titleLine.trim().length(); i++) {
			seperator = seperator + "-";
		}
		seperator = seperator + "\r\n";
		return seperator;
	}

	/**
	 * Allows a profile's current Date line to be accessed.
	 * 
	 * @return returns the String for the currentDateLine to be inputed in profile's
	 *         text file.
	 */
	public String getCurrentDateLine() {
		return currentDateLine;
	}

	/**
	 * Allows a profile's week commencing Date line to be accessed.
	 * 
	 * @return returns the String for the wcDateLine to be inputed in profile's text
	 *         file.
	 */
	public String getWCDateLine() {
		return wcDateLine;
	}

	/**
	 * Allows a profile's total line to be accessed.
	 * 
	 * @return returns the String for the totalLine to be inputed in profile's text
	 *         file.
	 */
	public String getTotalLine() {
		totalLine = "\r\n\r\n" + seperator2 + "\r\n" + "Total Chores:  " + noOfChores;
		return totalLine;
	}

	/**
	 * Overrides the default toString() representation of this class.
	 */
	@Override
	public String toString() {
		return "Profile:[person=" + person + ", chores=" + chores + ", noOfChores=" + noOfChores + ", totalChoreTime="
				+ totalChoreTime + ", averageChoreTime=" + averageChoreTime + ", filePath=" + filePath + ", seperator="
				+ seperator + ", titleLine=" + titleLine + ", currentDateLine=" + currentDateLine + ", wcDateLine="
				+ wcDateLine + ", seperator2=" + seperator2 + ", totalLine=" + totalLine + "]";
	}

}
