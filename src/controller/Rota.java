package controller;

import java.util.Arrays;
import model.Person;
import model.Profile;
import model.ProfileData;
import view.DataClass;
import view.ExportData;
import view.ImportData;

// This class creates instances of the view and model package classes.
public class Rota {

	// Fields.
	private ProfileData model;
	private DataClass view;
	private ImportData imD;
	private ExportData exD;

	// Default Constructor.
	public Rota() {
		model = new ProfileData();
		view = new DataClass();
		imD = view.getImportData();
		exD = view.getExportData();
	}

	// Main method.
	public void runRota() {

		// Creates 3 new profiles with name, last name (or
		// nickname) and ID, assigns a
		// boolean value to whether a nickname is to be used.
		Profile p = new Profile(new Person("Mike", "Taylor", "Mikey", 1), true);
		Profile p2 = new Profile(new Person("John", "Smith", 2), false);
		Profile p3 = new Profile(new Person("Lucy", "Knowles", 3), false);

		// Adds all 3 profiles to the model.
		model.addProfiles(Arrays.asList(p, p2, p3));

		// Removes any duplicate entries from the model.
		model.removeDuplicates(model.getProfiles());

		// Invokes the 'loadRawData' method from the importData class and uses it to
		// populate HashMap.
		imD.loadRawData(model);

		// Invokes the 'exportChoresToTextFile' method from the exportChores class and
		// uses it to populate text files for each person.
		exD.exportChoresToTextFiles(model);

	}
}
