package loanapound.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loanapound.creditscore.CreditScoreSystemAdapter;

public class CreditScoreSystemTest {
	private CreditScoreSystem creditScoreSystem;

	@Before
	public void setUp() throws Exception {
		creditScoreSystem = new CreditScoreSystem();
	}

	@Test
	public void testGetCreditScoreSystemId() {
		assertNull(creditScoreSystem.getCreditScoreSystemId());
	}

	@Test
	public void testSetCreditScoreSystemId() {
		creditScoreSystem.setCreditScoreSystemId(1L);
		assertEquals((Long)1L, creditScoreSystem.getCreditScoreSystemId());
	}

	@Test
	public void testGetCompanyName() {
		assertNull(creditScoreSystem.getCompanyName());
	}

	@Test
	public void testSetCompanyName() {
		creditScoreSystem.setCompanyName("Company");
		assertEquals("Company", creditScoreSystem.getCompanyName());	
	}

	@Test
	public void testGetAdapter() {
		assertNull(creditScoreSystem.getAdapter());
	}

	@Test
	public void testSetAdapter() {
		CreditScoreSystemAdapter adapter = new CreditScoreSystemAdapter() {
			
			@Override
			public CreditScore getScoreForApplicant(Applicant applicant) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		creditScoreSystem.setAdapter(adapter);
		assertEquals(adapter, creditScoreSystem.getAdapter());	
	}

}
