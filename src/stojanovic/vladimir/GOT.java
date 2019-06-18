package stojanovic.vladimir;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GOT {

	public static void main(String[] args) throws IOException {

		List<Character> c = Character_Data.createListOfCharacters();// storing data from txt file into array list
		Emoji emoji = new Emoji();
		FileClass fileHelp = new FileClass();

		Character daenerys = new Character(c.get(0).name, c.get(0).allegiance, c.get(0).message_file);
		Character jon = new Character(c.get(1).name, c.get(1).allegiance, c.get(1).message_file);
		Character tyrion = new Character(c.get(2).name, c.get(2).allegiance, c.get(2).message_file);
		Character cersei = new Character(c.get(3).name, c.get(3).allegiance, c.get(3).message_file);

		while (true) {
			int task = JOptionPane.showOptionDialog(null, "Solution of final assignment: "
					+ "\n 1. Create character class\n" + "2. Print all Daenerys' messages\n"
					+ "3. Create a pop up that displays the number of messages that each character has sent\n"
					+ "4. Analyze the character's dispositions and verify that Tyrion has a positive disposition\n"
					+ "5. Print the character who has the most positive and the most negative disposition\n"
					+ "6. Does Jon love Daenerys more than she loves him?\n" + "7. UML diagram", "Solution",
					JOptionPane.INFORMATION_MESSAGE, 0, null,
					new String[] { "out", "1.", "2.", "3.", "4.", "5.", "6.", "7." }, 0);
			switch (task) {
			case 0:
				System.exit(0);
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Look Character and Character_Data classes.");
				break;
			case 2:
				fileHelp.printMessages(daenerys.message_file);// printing messages from txt
				// file
				break;
			case 3:
				// creating a pop-up of sent messages from each character
				JOptionPane.showMessageDialog(null,
						daenerys.name + " sent " + fileHelp.loadMessages(daenerys.message_file).size() + " messages!\n"
								+ jon.name + " sent " + fileHelp.loadMessages(jon.message_file).size() + " messages!\n"
								+ tyrion.name + " sent " + fileHelp.loadMessages(tyrion.message_file).size()
								+ " messages!\n" + cersei.name + " sent "
								+ fileHelp.loadMessages(cersei.message_file).size() + " messages!\n");
				break;
			case 4:
				JOptionPane.showMessageDialog(null,
						tyrion.name + " has " + emoji.stateOfDisposition(tyrion.message_file)
								+ " disposition. Positive: " + emoji.searchPositive(tyrion.message_file)
								+ ". Negative: " + emoji.searchNegative(tyrion.message_file) + ".");
				JOptionPane.showMessageDialog(null, "Checkout DispositionTest class.");
				break;
			case 5:
				// creating hash map:key result from searchpositive method, value name of the
				// character
				HashMap<Integer, String> max = new HashMap<Integer, String>();// storing positive emojis
				max.put(emoji.searchPositive(daenerys.message_file), daenerys.name);
				max.put(emoji.searchPositive(jon.message_file), jon.name);
				max.put(emoji.searchPositive(tyrion.message_file), tyrion.name);
				max.put(emoji.searchPositive(cersei.message_file), cersei.name);

				int maxLove = Collections.max(max.keySet());// finding max value of positive emojis
				for (Entry<Integer, String> entry : max.entrySet()) {
					if (entry.getKey() == maxLove) {
						JOptionPane.showMessageDialog(null,
								"Number of positive disposition: \n" + daenerys.name + ": "
										+ emoji.searchPositive(daenerys.message_file) + "\n" + jon.name + ": "
										+ emoji.searchPositive(jon.message_file) + "\n" + tyrion.name + ": "
										+ emoji.searchPositive(tyrion.message_file) + "\n" + cersei.name + ": "
										+ emoji.searchPositive(cersei.message_file) + "\n" + entry.getValue()
										+ " has most positive dispositions.");
					}
				}

				HashMap<Integer, String> min = new HashMap<Integer, String>();// storing negative emojis
				min.put(emoji.searchNegative(daenerys.message_file), daenerys.name);
				min.put(emoji.searchNegative(jon.message_file), jon.name);
				min.put(emoji.searchNegative(tyrion.message_file), tyrion.name);
				min.put(emoji.searchNegative(cersei.message_file), cersei.name);

				int maxSad = Collections.max(min.keySet());// finding max value of negative emojis
				for (Entry<Integer, String> entry : min.entrySet()) {
					if (entry.getKey() == maxSad) {
						JOptionPane.showInternalMessageDialog(null,
								"Number of negative dispositions: \n" + daenerys.name + ": "
										+ emoji.searchNegative(daenerys.message_file) + "\n" + jon.name + ": "
										+ emoji.searchNegative(jon.message_file) + "\n" + tyrion.name + ": "
										+ emoji.searchNegative(tyrion.message_file) + "\n" + cersei.name + ": "
										+ emoji.searchNegative(cersei.message_file) + "\n" + entry.getValue()
										+ " has most negative dispositions.");
					}
				}
				break;
			case 6:

				if (emoji.loveEmo(jon.message_file) > emoji.loveEmo(daenerys.message_file)) {// comparing two methods
					JOptionPane.showMessageDialog(null,
							"Jon (" + emoji.loveEmo(jon.message_file) + " love emoji) love Daenerys ("
									+ emoji.loveEmo(daenerys.message_file) + " love emoji) more than she loves him");
				} else if (emoji.loveEmo(daenerys.message_file) > emoji.loveEmo(jon.message_file)) {
					JOptionPane.showMessageDialog(null,
							"Daenerys (" + emoji.loveEmo(daenerys.message_file) + " love emoji) love Jon ("
									+ emoji.loveEmo(jon.message_file) + " love emoji) more than he loves her");
				} else {
					JOptionPane.showMessageDialog(null, "They love eachother the same");
				}
				break;
			case 7:
				JFrame frame = new JFrame();
				ImageIcon icon = new ImageIcon("resource/Diagram.PNG");
				JLabel label = new JLabel(icon);
				frame.setSize(30, 30);
				frame.add(label);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
				break;
			}
		}

	}
}
