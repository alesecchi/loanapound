package loanapound.engine;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import loanapound.creditscore.CreditScoreSystemAdapter;
import loanapound.model.Applicant;
import loanapound.model.BaseLoan;
import loanapound.model.CreditScore;
import loanapound.model.CreditScoreException;
import loanapound.model.CreditScoreSystem;
import loanapound.model.EvaluationCriteria;
import loanapound.model.LoanApplication;
import loanapound.model.mock.MockCreditScore;
import loanapound.model.mock.MockLoanApplication;

public class DecisionEngineTest {
	private DecisionEngine decisionEngine;
	private CreditScoreSystem creditScoreSystem;
	private LoanApplication loanApplication;
	private EvaluationCriteria acceptedCriteria;
	private EvaluationCriteria rejectedCriteria;

	@Before
	public void setUp() throws Exception {
		decisionEngine = new DecisionEngine();
		loanApplication = new MockLoanApplication(1000);
		creditScoreSystem = new CreditScoreSystem();
		creditScoreSystem.setAdapter(new CreditScoreSystemAdapter() {
			
			@Override
			public CreditScore getScoreForApplicant(Applicant applicant) {
				return new MockCreditScore();
			}
		});
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
	
	@Test
	public void testGetCreditScoresForApplicantNoSystem(){
		assertTrue(decisionEngine.getCreditScoresForApplicant(new Applicant()).isEmpty());
	}
	
	@Test
	public void testGetCreditScoresForApplicant(){
		decisionEngine.addCreditScoreSystem(creditScoreSystem);
		List<CreditScore> creditScoreList = decisionEngine.getCreditScoresForApplicant(new Applicant());
		assertEquals(1, creditScoreList.size());
		assertEquals(500, creditScoreList.get(0).getScore());
	}
	
	@Test
	public void testGetCreditScoresForApplicantMultipleScores(){
		decisionEngine.addCreditScoreSystem(creditScoreSystem);
		CreditScoreSystem secondCreditScoreSystem = new CreditScoreSystem();
		secondCreditScoreSystem.setAdapter(new CreditScoreSystemAdapter() {
			
			@Override
			public CreditScore getScoreForApplicant(Applicant applicant) {
				CreditScore creditScore = new MockCreditScore();
				try {
					creditScore.assignScore(700);
				} catch (CreditScoreException e) {
				}
				return creditScore;
			}
		});
		decisionEngine.addCreditScoreSystem(secondCreditScoreSystem);
		List<CreditScore> creditScoreList = decisionEngine.getCreditScoresForApplicant(new Applicant());
		assertEquals(2, creditScoreList.size());
		assertEquals(500, creditScoreList.get(0).getScore());
		assertEquals(700, creditScoreList.get(1).getScore());
	}

}
