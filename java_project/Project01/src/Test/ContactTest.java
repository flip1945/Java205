package Test;

import Main.Contact;
import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {
	@Test
	public void testContactConstructor() {
		Contact contact = new Contact("a", "b", "c", "d", "e", "f");
		
		assertEquals(contact.getName(), "a");
		assertEquals(contact.getPhoneNum(), "b");
		assertEquals(contact.getEmail(), "c");
		assertEquals(contact.getAddress(), "d");
		assertEquals(contact.getBirthday(), "e");
		assertEquals(contact.getGroup(), "f");
	}
}
