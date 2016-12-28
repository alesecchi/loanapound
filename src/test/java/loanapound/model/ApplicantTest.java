package loanapound.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ApplicantTest {
	private Applicant applicant;

	@Before
	public void setUp() throws Exception {
		applicant = new Applicant();
	}

	@Test
	public void testGetApplicantId() {
		assertNull(applicant.getApplicantId());
	}

	@Test
	public void testSetApplicantId() {
		applicant.setApplicantId(1L);
		assertEquals((Long)1L, applicant.getApplicantId());
	}

	
	@Test
	public void testGetFirstName() {
		assertNull(applicant.getFirstName());
	}

	@Test
	public void testSetFirstName() {
		applicant.setFirstName("Marco");
		assertEquals("Marco", applicant.getFirstName());
	}

	@Test
	public void testGetLastName() {
		assertNull(applicant.getLastName());
	}

	@Test
	public void testSetLastName() {
		applicant.setLastName("Rossi");
		assertEquals("Rossi", applicant.getLastName());
	}

	@Test
	public void testGetEmail() {
		assertNull(applicant.getEmail());
	}

	@Test
	public void testSetEmail() {
		applicant.setEmail("marco.rossi@email.com");
		assertEquals("marco.rossi@email.com", applicant.getEmail());
	}

}
