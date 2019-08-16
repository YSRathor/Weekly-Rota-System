package view;

import java.util.Scanner;
import model.Person;
import model.Profile;
import model.ProfileData;

// This class is responsible for importing data from the profileData text file.
public class ImportProfiles {

	public void loadProfileData(ProfileData pd) {
		if (pd != null) {
			// Creates a Scanner object that will accept the profileData.txt file
			// as an input stream.
			Scanner in = null;
			in = new Scanner(ImportProfiles.class.getResourceAsStream("profileData.txt"));

			// These variables allow each element from a line to be parsed.
			String line;
			String[] arr;

			// Simple while loop which goes through each line of the input text file and
			// stores the profiles into the ProfileData object.
			while (in.hasNextLine()) {
				line = in.nextLine();
				arr = line.split(",");

				// IF statement checks the number of elements on a line, in order to see which
				// constructor should be used.
				if (arr.length == 4) {
					pd.addProfile(new Profile(
							new Person(HelperMethods.getCapitalisedString(arr[0]),
									HelperMethods.getCapitalisedString(arr[1]), Integer.parseInt(arr[2])),
							Boolean.parseBoolean(arr[3])));
				} else if (arr.length == 5) {
					pd.addProfile(new Profile(
							new Person(HelperMethods.getCapitalisedString(arr[0]),
									HelperMethods.getCapitalisedString(arr[1]),
									HelperMethods.getCapitalisedString(arr[2]), Integer.parseInt(arr[3])),
							Boolean.parseBoolean(arr[4])));
				}
			}

			// Close the Scanner Object.
			in.close();
		}
	}

}
