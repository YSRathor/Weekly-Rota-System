package controller;

import model.ProfileData;
import view.DataClass;
import view.ExportChoreData;
import view.ImportChoreData;
import view.ImportProfiles;

// This class creates instances of the view and model package classes.
public class Rota {

	// Fields.
	private ProfileData model;
	private DataClass view;
	private ImportProfiles iP;
	private ImportChoreData imD;
	private ExportChoreData exD;

	// Default Constructor.
	public Rota() {
		model = new ProfileData();
		view = new DataClass();
		iP = view.getImportProfiles();
		imD = view.getImportChoreData();
		exD = view.getExportChoreData();
	}

	// Main method.
	public void runRota() {

		// Invokes the 'loadProfileData' method from the ImportProfiles class and uses
		// it to add all profiles to the model.
		iP.loadProfileData(model);

		// Removes any duplicate entries from the model.
		model.removeDuplicates(model.getProfiles());

		// Invokes the 'loadRawData' method from the ImportChoreData class and uses it
		// to populate TreeMap.
		imD.loadRawData(model);

		// Invokes the 'sendChoreData' method from the ExportChoreData class and
		// uses it to populate text files for each profile.
		exD.sendChoreData(model);

	}

}