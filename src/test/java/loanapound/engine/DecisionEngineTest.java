package loanapound.engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import loanapound.creditscore.CreditScoreSystemAdapter;
import loanapound.model.Applicant;
import loanapound.model.BaseLoan;
import loanapound.model.CreditScore;
import loanapound.model.EvaluationCriteria;
import loanapound.model.LoanApplication;
import loanapound.model.mock.MockCreditScore;
import loanapound.model.mock.MockLoanApplication;

public class DecisionEngineTest {
	private DecisionEngine decisionEngine;
	private CreditScoreSystemAdapter creditScoreSystem;
	private LoanApplication loanApplication;
	private EvaluationCriteria acceptedCriteria;
	private EvaluationCriteria rejectedCriteria;

	@Before
	public void setUp() throws Exception {
		decisionEngine = new DecisionEngine();
		loanApplication = new MockLoanApplication(1000);
		creditScoreSystem = new CreditScoreSystemAdapter() {
			
			@Override
			public CreditScore getScoreForApplicant(Applicant applicant) {
				return new MockCreditScore();
			}
		};
		acceptedCriteria = new EvaluationCriteria() {
			
			@Override
			public boolean isAccepted(CreditScore creditScore) {
				return true;
			}
		};
		rejectedCriteria = new EvaluationCriteria() {
			
			@Override
			public boolean isAccepted(CreditScore creditScore) {
				return false;
			}
		};
	}


	@Test
	public void testEvaluateLoanApplicationNoSystem() {
		decisionEngine.addEvaluationCriteria(acceptedCriteria);
		assertFalse(decisionEngine.evaluateLoanApplication(loanApplication));
	}
	
	@Test
	public void testEvaluateLoanApplicationNoCriteria() {
		decisionEngine.addCreditScoreSystem(creditScoreSystem);
		assertFalse(decisionEngine.evaluateLoanApplication(loanApplication));
	}
	
	@Test
	public void testEvaluateLoanApplicationAccepted() {
		decisionEngine.addEvaluationCriteria(acceptedCriteria);
		decisionEngine.addCreditScoreSystem(creditScoreSystem);
		assertTrue(decisionEngine.evaluateLoanApplication(loanApplication));
	}
	
	@Test
	public void testEvaluateLoanApplicationRejected() {
		decisionEngine.addEvaluationCriteria(rejectedCriteria);
		decisionEngine.addCreditScoreSystem(creditScoreSystem);
		assertFalse(decisionEngine.evaluateLoanApplication(loanApplication));
	}
	
	@Test
	public void testEvaluateLoanApplicationMultipleCriteria() {
		decisionEngine.addEvaluationCriteria(acceptedCriteria);
		decisionEngine.addEvaluationCriteria(rejectedCriteria);
		decisionEngine.addCreditScoreSystem(creditScoreSystem);
		assertFalse(decisionEngine.evaluateLoanApplication(loanApplication));
	}
	
	@Test
	public void testEvaluateLoanApplicationMultipleSystems() {
		decisionEngine.addEvaluationCriteria(acceptedCriteria);
		decisionEngine.addCreditScoreSystem(creditScoreSystem);
		decisionEngine.addCreditScoreSystem(creditScoreSystem);
		assertTrue(decisionEngine.evaluateLoanApplication(loanApplication));
	}

}
