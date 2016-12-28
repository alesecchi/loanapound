package loanapound.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MedianEvaluationCriteriaTest {
	private CreditScore creditScore;
	private MedianEvaluationCriteria medianEvaluationCriteria;

	@Before
	public void setUp() throws Exception {
		medianEvaluationCriteria = new MedianEvaluationCriteria();
		//should use a mock class
		creditScore = new CreditScore(300, 900);
	}

	@Test
	public void testIsAccepted() throws CreditScoreException {
		creditScore.assignScore(700);
		assertTrue(medianEvaluationCriteria.isAccepted(creditScore));
	}

	@Test
	public void testIsAcceptedMedianBoundary() throws CreditScoreException {
		creditScore.assignScore(600);
		assertTrue(medianEvaluationCriteria.isAccepted(creditScore));
	}
	
	@Test
	public void testIsNotAccepted() throws CreditScoreException {
		creditScore.assignScore(599);
		assertFalse(medianEvaluationCriteria.isAccepted(creditScore));
	}
}
