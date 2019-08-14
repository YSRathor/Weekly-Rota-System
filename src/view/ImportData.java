package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.Chore;
import model.ChoresAllocation;
import model.ChoresList;
import model.ProfileData;

// This class is responsible for importing data from choreData text file.
public class ImportData {

	// Fields.
	// ArrayList of chores and HashMap (of chores linking with applicable people) is
	// created.
	private ChoresList cl;
	private ChoresAllocation ca;

	// Default Constructor enables fields to be initialised.
	public ImportData() {
		cl = new ChoresList();
		ca = new ChoresAllocation();
	}

	// Main method.
	public void loadRawData(ProfileData pd) {
		if (pd != null) {
			// Creates a Scanner object that will accept the raw data file as an input
			// stream.
			Scanner in = null;
			in = new Scanner(ImportData.class.getResourceAsStream("choreData.txt"));

			// These variables allow each element from a line to be parsed, whilst the
			// counter ensures that each HashMap key, value map will store the correct
			// values.
			String line;
			String[] arr;
			int lineNo = 0;

			// Simple while loop which goes through each line of the input text file and
			// stores the chores into the ArrayList.
			// Each chore is placed along with the applicable people to each HashMap
			// mapping.
			while (in.hasNextLine()) {
				line = in.nextLine();
				arr = line.split(",");

				cl.addChore(new Chore(arr[0], Integer.parseInt(arr[4])));
				ca.addAllocation(cl.getChore(lineNo), new ArrayList<String>(Arrays.asList(arr[1], arr[2], arr[3])));

				lineNo++;
			}

			// Close the Scanner Object.
			in.close();

			// Stores HashMap into ProfileData class.
			pd.setChoresAllocation(ca);

		}
	}
}
