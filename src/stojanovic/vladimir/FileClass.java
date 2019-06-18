package stojanovic.vladimir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileClass {

	public void printMessages(String message_file) {// print txt file in console

		String line = null;
		try {

			FileReader fileReader = new FileReader("resource/message_logs/" + message_file);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

			bufferedReader.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + message_file + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + message_file + "'");
		}
	}

	public List<String> loadMessages(String fileName) {
		List<String> messages = new ArrayList<String>();
		File file = new File("resource/message_logs/" + fileName);

		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String aLine;
			buffer.readLine();
			while ((aLine = buffer.readLine()) != null) {
				if (aLine.trim().length() != 0) {
					messages.add(aLine);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return messages;
	}
}
