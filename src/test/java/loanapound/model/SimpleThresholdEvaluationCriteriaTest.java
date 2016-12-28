package loanapound.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleThresholdEvaluationCriteriaTest {
	private CreditScore creditScore;
	private SimpleThresholdEvaluationCriteria simpleThresholdEvaluationCriteria;

	@Before
	public void setUp() throws Exception {
		simpleThresholdEvaluationCriteria = new SimpleThresholdEvaluationCriteria(500);
		//should use a mock class
		creditScore = new CreditScore(300, 900);
	}

	@Test
	public void testIsAccepted() throws CreditScoreException {
		creditScore.assignScore(700);
		assertTrue(simpleThresholdEvaluationCriteria.isAccepted(creditScore));
	}
	
	@Test
	public void testIsAcceptedThresholdBoundary() throws CreditScoreException {
		creditScore.assignScore(500);
		assertTrue(simpleThresholdEvaluationCriteria.isAccepted(creditScore));
	}
	
	@Test
	public void testIsNotAccepted() throws CreditScoreException {
		creditScore.assignScore(499);
		assertFalse(simpleThresholdEvaluationCriteria.isAccepted(creditScore));
	}

}
