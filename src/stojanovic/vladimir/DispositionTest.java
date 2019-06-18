package stojanovic.vladimir;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class DispositionTest extends TestCase {

	@Test
	void testDisposition() throws IOException {

		List<Character> ch = Character_Data.createListOfCharacters();
		Emoji emo = new Emoji();
		assertEquals("POSITIVE", emo.stateOfDisposition(ch.get(0).message_file));
		assertEquals("NORMAL", emo.stateOfDisposition(ch.get(1).message_file));
		assertEquals("POSITIVE", emo.stateOfDisposition(ch.get(2).message_file));
		assertEquals("NEGATIVE", emo.stateOfDisposition(ch.get(3).message_file));
	}

	void testNumberOfMessages() throws IOException {
		List<Character> ch = Character_Data.createListOfCharacters();
		FileClass filez = new FileClass();
		assertEquals(17, filez.loadMessages(ch.get(0).message_file));
		assertEquals(10, filez.loadMessages(ch.get(1).message_file));
		assertEquals(15, filez.loadMessages(ch.get(2).message_file));
		assertEquals(10, filez.loadMessages(ch.get(3).message_file));
	}
}
