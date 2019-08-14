package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

// This class contain useful methods to be statically accessed in other classes.
public class HelperMethods {

	// Fields.
	// Creates Calendar object with current date.
	private static Calendar cal = Calendar.getInstance();
	// Creates a Date format.
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

	// Methods.
	// Useful method to calculate the current lettered week.
	public static String getWeek() {
		// Creates 3 basic ArrayLists to store week numbers for each different lettered
		// week.
		ArrayList<Integer> weekANos = new ArrayList<Integer>();
		ArrayList<Integer> weekBNos = new ArrayList<Integer>();
		ArrayList<Integer> weekCNos = new ArrayList<Integer>();

		// Creates the variable which will store the current lettered week.
		String weekLetter = "";

		// Populating week numbers for the Week A ArrayList.
		for (int a = 1; a <= 52; a = a + 3) {
			weekANos.add(a);
		}

		// Populating week numbers for the Week B ArrayList.
		for (int b = 2; b <= 52; b = b + 3) {
			weekBNos.add(b);
		}

		// Populating week numbers for the Week C ArrayList.
		for (int c = 3; c <= 52; c = c + 3) {
			weekCNos.add(c);
		}

		// Finds the current numbered week.
		int weekNo = cal.get(Calendar.WEEK_OF_YEAR);

		// IF-ELSE statements will check if it's Week A, B or C and assign the
		// calculated value to the variable
		if (weekANos.contains(weekNo)) {
			weekLetter = "A";
		} else if (weekBNos.contains(weekNo)) {
			weekLetter = "B";
		} else if (weekCNos.contains(weekNo)) {
			weekLetter = "C";
		}

		// Lettered week value is returned
		return weekLetter;
	}

	// Simple method to allow today's date to be retrieved.
	public static String getCurrentDate() {

		// Applies the formatting for the date.
		String currentDate = sdf.format(cal.getTime());

		// returns a String with today's date.
		return currentDate;
	}

	// Simple method to allow the week commencing date to be retrieved.
	public static String getCurrentWCDate() {
		// Creates a new Calendar object with today's date.
		Calendar cal2 = Calendar.getInstance();
		// Sets the day to the current week's Monday date.
		cal2.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		// Applies the formatting for the date.
		String currentWCDate = sdf.format(cal2.getTime());

		// returns a String with the week commencing date.
		return currentWCDate;
	}

	// Simple method to calculate what index needs to be selected.
	public static int getWeekSelector() {
		// Initialises variable.
		int weekSelector = 0;

		// IF statement checks what the value of the lettered week is equal, based on
		// that the index position is selected.
		if (getWeek() == "A") {
			weekSelector = 0;
		} else if (getWeek() == "B") {
			weekSelector = 1;
		} else if (getWeek() == "C") {
			weekSelector = 2;
		}

		// returns an int to be used to select the index.
		return weekSelector;
	}
}