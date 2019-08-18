package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import model.Chore;
import model.ProfileData;
import view.HelperMethods;

// This class is responsible for storing output data to individual text files.
public class ExportChoreData {

	// Fields.
	// An Print Writer is created for each text file to be generated by the
	// program.
	private PrintWriter pw;

	// Entry, Key and Value variables are created to be used with ease, for the
	// iterator below.
	private Entry<Chore, ArrayList<String>> currentEntry;
	private Chore currentKey;
	private ArrayList<String> currentValue;

	// An iterator is declared.
	private Iterator<Entry<Chore, ArrayList<String>>> i;

	// Main method.
	public void sendChoreData(ProfileData pd) {
		// IF statement surrounds code block to ensure no empty or null values are
		// worked on.
		if (pd != null && !pd.getProfiles().isEmpty()) {

			// Java 8 for-each method enables profiles within 'pd' to be iterated through.
			pd.forEach(p -> {

				// The iterator is assigned and passed a TreeMap's iterator method to allow for
				// use below in the while loop.
				i = pd.getChoresAllocation().returnIterator();

				// Tasks for Person:
				// Try-catch block surrounds code section due to a file required to be
				// generated.
				try {
					// String variable to store list of all chores together.
					String output = "";

					// New file object is created at a specific path.
					File file = new File(p.getFilePath());

					// The Print Writer will write to the file specified in the location above.
					pw = new PrintWriter(file);

					// The Strings are accessed from the model and are written to the file.
					pw.write(p.getCurrentDateLine());
					pw.write(p.getWCDateLine());
					pw.write(p.getTitle());
					pw.write(p.getSeparator());

					// Stores index position used for retrieving a Chore from the ChoresList.
					int index = 0;

					// This while loop retrieves all the chores required to be done by a person and
					// stores it together in the 'output' String.
					while (i.hasNext()) {
						currentEntry = (Map.Entry<Chore, ArrayList<String>>) i.next();
						currentKey = currentEntry.getKey();
						currentValue = currentEntry.getValue();

						if (currentValue.get(HelperMethods.getWeekSelector()).substring(3)
								.contains(p.getPerson().getFirstName())) {
							p.addChore(new Chore(currentKey.getChoreName(), currentKey.getChoreTime()));
							output += "  - " + p.getAllChores().getChore(index).getChoreName() + "\r\n";
							index++;
						} else {
							output += "";
						}
					}

					// Stores total count of chores to profile.
					p.setNoOfChores(p.getAllChores().choresListSize());

					// Sets the correct values for the time output Strings by getting the
					// int time values and then formatting them.
					p.setTotalChoreTime(p.getAllChores());
					p.setAverageChoreTime(p.getTotalChoreTime(), p.getNoOfChores());
					p.setTotalChoreTimeOutput(p.getTotalChoreTime());
					p.setAverageTimeOutput(p.getAverageChoreTime());

					// The 'output' String is trimmed at the end and added to non-trimmed part of
					// itself to ensure that no newline is generated redundantly at the end of the
					// file.
					if (!output.isEmpty()) {
						String trimmed = output.substring(4).trim();
						output = output.substring(0, 4) + trimmed;
					}

					// The output String is written to the file.
					pw.write(output);

					// The Strings are accessed from the model and are written to the file.
					pw.write(p.getSeparator2());
					pw.write(p.getTotalLine());
					pw.write(p.getTotalChoreTimeOutput());
					pw.write(p.getAverageChoreTimeOutput());

					pw.close(); // Output Stream is closed.

				} catch (FileNotFoundException e) { // Handles non-existent file name.
					e.printStackTrace();
				}
			});
		}
	}
}
