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
	
	@Test
	public void testAddHeader() throws Exception{
	
		email.addHeader("name", "value"); // testing add header with non null values
		
		assertEquals(1, email.headers.keySet().size()); // asserting that a header was added
	        
        try {
            email.addHeader("", "value ");  // testing add header with an empty string for name 
        }
        catch (IllegalArgumentException e) {
            assertEquals("name can not be null or empty", e.getMessage()); // testing throw exception message is equal to correct exception
        }
        try {
            email.addHeader("name ", ""); // testing add header with an empty string for value 
        }
        catch (IllegalArgumentException e) {
            assertEquals("value can not be null or empty", e.getMessage()); // testing throw exception message is equal to correct exception
        }
	}
	@Test
	public void testAddreplyTo() throws Exception{
		Email e = email.addReplyTo("sada@mail.com.uk", "name"); // creating a dummy Email 'e' and calling addReplyTo method with sample data
		assertEquals(1, e.getReplyToAddresses().size()); // asserting data was added 
	}
	@Test
	public void testBuildMimeMessage() throws Exception{
		
		email.buildMimeMessage();
	}
	@Test
	public void testGetHost() throws Exception{
		
		assertEquals(null, email.getHostName()); // asserting hostname is null
		email.hostName = "test"; // setting host name with a sample
		assertEquals("test", email.getHostName()); // asserting host name gotten from call is equal to one set
	}
	
	@Test
	public void testGetMailSession() throws Exception{
		
		email.setHostName("test Host"); //setting host name to sample data
		assertNotNull(email.getMailSession()); // asserting mail session from call is not null
		
	}

	
}