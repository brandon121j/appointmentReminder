package appointmentReminder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataReader {
	public static String[] dataFetcher() {
		String firstLine = "";
		String secondLine = "";

		try {
			File txtData = new File("infoSaver.txt");
			Scanner dataScanner = new Scanner(txtData);

			if (dataScanner.hasNextLine()) {
				firstLine = dataScanner.nextLine();

				if (dataScanner.hasNextLine()) {
					secondLine = dataScanner.nextLine();
				}

				dataScanner.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("An error has occured");
			e.printStackTrace();
		}

		return new String[] { firstLine, secondLine };
	}
}
