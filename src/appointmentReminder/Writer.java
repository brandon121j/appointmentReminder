package appointmentReminder;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	public static void dataSaver(String therapist, String link) {
		try {
			FileWriter writer = new FileWriter("infoSaver.txt");
			writer.write(therapist);
			writer.append("\n");
			writer.write(link);
			writer.close();
			System.out.println("Therapist: " + therapist + "Link: " + link);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
