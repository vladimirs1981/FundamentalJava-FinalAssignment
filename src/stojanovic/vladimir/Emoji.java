package stojanovic.vladimir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Emoji {

	public int searchPositive(String message_file) {// search for positive emoji

		String positive1 = "😄";
		String positive2 = "🙂";
		String positive3 = "😊";
		String positive4 = "😍";

		File file = new File("resource/message_logs/" + message_file);
		int countpositive = 0;
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String line;

			while ((line = br.readLine()) != null) {
				if (line.contains(positive1) || line.contains(positive2) || line.contains(positive3)
						|| line.contains(positive4)) {
					countpositive++;
				}

			}
		} catch (FileNotFoundException e) {

			System.err.println("alert");
		} catch (IOException e) {

			System.err.println("alert");
		}
		return countpositive;
	}

	public int searchNegative(String message_file) {// search for negative emoji

		String negative1 = "😢";
		String negative2 = "😭";
		String negative3 = "😞";
		String negative4 = "👿";
		File file = new File("resource/message_logs/" + message_file);
		int countnegative = 0;
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String line;

			while ((line = br.readLine()) != null) {
				if (line.contains(negative1) || line.contains(negative2) || line.contains(negative3)
						|| line.contains(negative4)) {
					countnegative++;
				}

			}
		} catch (FileNotFoundException e) {

			System.err.println("alert");
		} catch (IOException e) {

			System.err.println("alert");
		}
		return countnegative;
	}

	public int loveEmo(String message_file) {

		String love1 = "😍";
		String love2 = "😘";

		File file = new File("resource/message_logs/" + message_file);
		int countpositive = 0;
		try {
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String line;

			while ((line = br.readLine()) != null) {
				if (line.contains(love1) || line.contains(love2)) {
					countpositive++;
				}
			}

		} catch (FileNotFoundException e) {

			System.err.println("alert");
		} catch (IOException e) {

			System.err.println("alert");
		}
		return countpositive;

	}

	public String stateOfDisposition(String message_file) { // comparing two methods

		if (searchPositive(message_file) > searchNegative(message_file)) {
			return "POSITIVE";
		} else if (searchNegative(message_file) > searchPositive(message_file)) {
			return "NEGATIVE";
		} else {
			return "NORMAL";
		}
	}
}
