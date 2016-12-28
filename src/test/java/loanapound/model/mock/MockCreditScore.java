package loanapound.model.mock;

import loanapound.model.CreditScore;
import loanapound.model.CreditScoreException;

public class MockCreditScore extends CreditScore {
	private int score = 500;
	
	public MockCreditScore() {
		super(300, 800);
	}

	@Override
	public void assignScore(int score) throws CreditScoreException {
		this.score=score;
	}

	@Override
	public int getMinValue() {
		return 300;
	}

	@Override
	public int getMaxValue() {
		return 800;
	}

	@Override
	public int getScore() {
		return this.score;
	}

}
