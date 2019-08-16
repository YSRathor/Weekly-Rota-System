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
	 * A String value to store the filepath to where the text file will be created
	 * and written to.
	 */
	private String filePath;
	/**
	 * A String value to represent the current Date line for a text file.
	 */
	private String currentDateLine;
	/**
	 * A String value to represent the week commencing Date line for a text file.
	 */
	private String wcDateLine;
	/**
	 * A String value to represent the title line for a text file.
	 */
	private String titleLine;
	/**
	 * A String value to represent a (-) division of a dynamic length, calculated
	 * from titleLine's length.
	 */
	private String separator;
	/**
	 * A String value to represent a (-) division of a dynamic length, calculated
	 * from formatted time String lengths.
	 */
	private String separator2;
	/**
	 * A String value to represent the total line for a text file.
	 */
	private String totalLine;
	/**
	 * An int value to store the combined time needed to complete all chores.
	 */
	private int totalChoreTime;
	/**
	 * An int value to store the average time needed to complete a chore.
	 */
	private int averageChoreTime;
	/**
	 * A String value to store the formatted combined time.
	 */
	private String formattedTotalTime;
	/**
	 * A String value to store the formatted average time.
	 */
	private String formattedAverageTime;

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
		filePath = "C:/Users/admin/Chores for " + person.getFirstName() + ".txt";
		currentDateLine = "Date: " + HelperMethods.getCurrentDate() + "\r\n";
		wcDateLine = "W/C:  " + HelperMethods.getCurrentWCDate() + "\r\n";
		titleLine = "\r\n" + person.getFirstName() + "'s Chores for Week " + HelperMethods.getWeek() + ":\r\n";
		separator = "";
		separator2 = "";
		totalLine = "";
		totalChoreTime = 0;
		averageChoreTime = 0;
		formattedTotalTime = "";
		formattedAverageTime = "";
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
	public void setNoOfChores(int i) {
		if (i >= 0) {
			noOfChores = i;
		}
	}

	/**
	 * Calculates and stores the value of the combined total chore time.
	 * 
	 * @param cl
	 *            the list of chores to be searched through to set a value for
	 *            totalTime
	 */
	public void setTotalChoreTime(ChoresList cl) {
		if (cl.choresListSize() > 0 && cl != null) {
			for (Chore c : cl) {
				totalChoreTime += c.getChoreTime();
			}
		}
	}

	/**
	 * Calculates and stores the value of the average chore time.
	 * 
	 * @param totalChoreTime
	 *            the combined total chore time value.
	 * @param noOfChores
	 *            the number of chores value.
	 */
	public void setAverageChoreTime(int totalChoreTime, int noOfChores) {
		if (noOfChores > 0) {
			averageChoreTime = totalChoreTime / noOfChores;
		}
	}

	/**
	 * Calculates and stores the String value to be outputted for the
	 * totalChoreTime.
	 * 
	 * @param totalChoreTime
	 *            the combined total chore time value.
	 */
	public void setTotalChoreTimeOutput(int totalChoreTime) {
		formattedTotalTime = "\r\nTotal Time:    " + String.format("%d Hours", totalChoreTime / 60) + " & "
				+ String.format("%02d Minutes", totalChoreTime % 60);
	}

	/**
	 * Calculates and stores the String value to be outputted for the
	 * averageChoreTime.
	 * 
	 * @param averageChoreTime
	 *            the average chore time value.
	 */
	public void setAverageTimeOutput(int averageChoreTime) {
		if (averageChoreTime > 0) {
			formattedAverageTime = "\r\nAverage Time:  " + String.format("%d Hours", averageChoreTime / 60) + " & "
					+ String.format("%02d Minutes", averageChoreTime % 60);
		} else {
			formattedAverageTime = "\r\nAverage Time:  " + "0 Hours" + " & " + "00 Minutes";
		}
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
	 * Allows the number of chores allocated to a profile to be accessed.
	 * 
	 * @return returns the number of chores for a profile.
	 */
	public int getNoOfChores() {
		return noOfChores;
	}

	/**
	 * Allows a profile's filepath to be accessed.
	 * 
	 * @return returns the String of the filepath to store data for a profile.
	 */
	public String getFilePath() {
		if (useNickName == true && !person.getNickName().trim().isEmpty()) {
			filePath = "C:/Users/admin/Chores for " + person.getNickName() + ".txt";
			return filePath;
		} else {
			return filePath;
		}
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
	public String getSeparator() {
		for (int i = 0; i < titleLine.trim().length(); i++) {
			separator += "-";
		}
		separator += "\r\n";
		return separator;
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
	 * Allows the separator2 String value to be accessed.
	 * 
	 * @return returns a String with a length dependent on the length of the
	 *         formatted time Strings.
	 */
	public String getSeparator2() {

		if (formattedTotalTime.trim().length() > formattedAverageTime.trim().length()) {
			for (int i = 0; i < formattedTotalTime.trim().length(); i++) {
				separator2 += "-";
			}
		} else if (formattedAverageTime.trim().length() > formattedTotalTime.trim().length()) {
			for (int i = 0; i < formattedAverageTime.trim().length(); i++) {
				separator2 += "-";
			}
		} else {
			int length = formattedTotalTime.trim().length();
			for (int i = 0; i < length; i++) {
				separator2 += "-";
			}
		}

		separator2 = "\r\n\r\n" + separator2 + "\r\n";

		return separator2;
	}

	/**
	 * Allows a profile's total line to be accessed.
	 * 
	 * @return returns the String for the totalLine to be inputed in profile's text
	 *         file.
	 */
	public String getTotalLine() {
		totalLine = "Total Chores:  " + noOfChores;
		return totalLine;
	}

	/**
	 * Allows the combined total chore time to be accessed.
	 * 
	 * @return returns the totalChoreTime value.
	 */
	public int getTotalChoreTime() {
		return totalChoreTime;
	}

	/**
	 * Allows the average chore time to be accessed.
	 * 
	 * @return returns the averageChoreTime value.
	 */
	public int getAverageChoreTime() {
		return averageChoreTime;
	}

	/**
	 * Allows the total time required to complete all chores to be accessed.
	 * 
	 * @return returns the formattedTotalTime, which is the totalChoreTime in hours
	 *         and minutes.
	 */
	public String getTotalChoreTimeOutput() {
		return formattedTotalTime;
	}

	/**
	 * Allows the average time required to complete a chore to be accessed.
	 * 
	 * @return returns the formattedAverageTime, which is the averageChoreTime in
	 *         hours and minutes.
	 */
	public String getAverageChoreTimeOutput() {
		return formattedAverageTime;
	}

	/**
	 * Overrides the default toString() representation of this class.
	 */
	@Override
	public String toString() {
		return "Profile [person=" + person + ", useNickName=" + useNickName + ", chores=" + chores + ", noOfChores="
				+ noOfChores + ", filePath=" + filePath + ", currentDateLine=" + currentDateLine + ", wcDateLine="
				+ wcDateLine + ", titleLine=" + titleLine + ", separator=" + separator + ", separator2=" + separator2
				+ ", totalLine=" + totalLine + ", totalChoreTime=" + totalChoreTime + ", averageChoreTime="
				+ averageChoreTime + ", formattedTotalTime=" + formattedTotalTime + ", formattedAverageTime="
				+ formattedAverageTime + "]";
	}
}
