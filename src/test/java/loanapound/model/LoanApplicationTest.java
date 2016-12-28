package loanapound.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoanApplicationTest {
	private LoanApplication loanApplication;
	private Loan loan;
	private Applicant applicant;

	@Before
	public void setUp() throws Exception {
		//should use a mock class
		loan = new BaseLoan();
		loan.setLoanId(10l);
		//should use a mock class
		applicant = new Applicant();
		applicant.setApplicantId(1L);
		loanApplication = new LoanApplication(loan, applicant, 10000);
	}

	@Test
	public void testGetApplicant() {
		assertEquals((Long)1L, loanApplication.getApplicant().getApplicantId());
	}

	@Test
	public void testGetLoan() {
		assertEquals((Long)10l, loanApplication.getLoan().getLoanId());
	}

	@Test
	public void testGetAmount() {
		assertEquals(10000, loanApplication.getAmount(), 0.0);
	}

	@Test
	public void testGetStatus() {
		assertEquals(LoanApplicationStatus.Pending, loanApplication.getStatus());
	}

	@Test
	public void testApprove() {
		loanApplication.approve();
		assertEquals(LoanApplicationStatus.Accepted, loanApplication.getStatus());
	}

	@Test
	public void testReject() {
		loanApplication.reject();
		assertEquals(LoanApplicationStatus.Rejected, loanApplication.getStatus());
	}
	
	@Test
	public void testTryApproveAfterReject() {
		loanApplication.reject();
		loanApplication.approve();
		assertEquals(LoanApplicationStatus.Rejected, loanApplication.getStatus());
	}

	@Test
	public void testTryRejectAfterApprove() {
		loanApplication.approve();
		loanApplication.reject();
		assertEquals(LoanApplicationStatus.Accepted, loanApplication.getStatus());
	}

}
