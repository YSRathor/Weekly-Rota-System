package view;

// This class creates instances of the ImportProfiles, ImportChoreData, and ExportChoreData classes,
// so that the Rota class can utilise main methods each of these classes.
public class DataClass {

	// Fields.
	private ImportProfiles iP;
	private ImportChoreData imD;
	private ExportChoreData exD;

	// Default Constructor.
	public DataClass() {
		iP = new ImportProfiles();
		imD = new ImportChoreData();
		exD = new ExportChoreData();
	}

	// Methods.
	// Returns the instance of the ImportProfiles class.
	public ImportProfiles getImportProfiles() {
		return iP;
	}

	// Returns the instance of the ImportChoreData class.
	public ImportChoreData getImportChoreData() {
		return imD;
	}

	// Returns the instance of the ExportChoreData class.
	public ExportChoreData getExportChoreData() {
		return exD;
	}

}
