package view;

// This class creates instances of the ExportData and ImportData classes,
// so that the Rota class can utilise main methods from both classes.
public class DataClass {

	// Fields.
	private ExportData exD;
	private ImportData imD;

	// Default Constructor.
	public DataClass() {
		exD = new ExportData();
		imD = new ImportData();
	}

	// Methods.
	// Returns the instance of the ExportData class.
	public ExportData getExportData() {
		return exD;
	}

	// Returns the instance of the ImportData class.
	public ImportData getImportData() {
		return imD;
	}

}
