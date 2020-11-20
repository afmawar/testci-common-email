package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EmailTest {
	private static final String[] TEST_EMAILS = { "test@test.com", "a.sas@so.com", "some@as.org" , "sdqwqdwfq@asdsadad.com.uk"};
	// Concrete email class for testing  
	private EmailConcrete email;
	
	@Before 
	public void setUpEmailTest() throws Exception {
		email = new EmailConcrete();		
	}
	@After
	public void tearDownEmailTest() throws Exception{
		email= null;
		assertNull(email);
	}
	
	@Test
	public void testAddBcc() throws Exception{
		email.addBcc(TEST_EMAILS); // adding premade valid emails list to bcc 
		assertEquals(4, email.getBccAddresses().size()); // asserting that the number of emails added to email bcc list is equal 
		String[] testDummy = {}; // empty string list to test null/invalid list
		try {
			email.addBcc(testDummy); // sending test list to addbcc method
		}	
		catch (IllegalArgumentException e) {
			assertEquals("Address List provided was invalid", e.getMessage()); // asserting that the exception message is the same 
		}

	}
	@Test
	public void testAddCc() throws Exception{
		email.addCc("sadas@mail.com"); // adding a sample email to addCc
		assertEquals(1, email.getCcAddresses().size()); // asserting that the size is 1 confriming the meail was added
	}

	
}