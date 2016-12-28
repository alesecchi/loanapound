package loanapound.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CreditScoreTest {
	private CreditScore creditScore;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		creditScore = new CreditScore(300, 850);
	}

	@Test
	public void testAssignScore() throws CreditScoreException {
		creditScore.assignScore(500);
		assertEquals(500, creditScore.getScore());
	}

	@Test
	public void testAssignScoreOutOfRange() throws CreditScoreException {
		thrown.expect(CreditScoreException.class);
		thrown.expectMessage("Score out of range");
		creditScore.assignScore(100);
	}
	
	@Test
	public void testGetMinValue() {
		assertEquals(300, creditScore.getMinValue());
	}

	@Test
	public void testGetMaxValue() {
		assertEquals(850, creditScore.getMaxValue());
	}

	@Test
	public void testGetScore() {
		assertEquals(0, creditScore.getScore());
	}

}
