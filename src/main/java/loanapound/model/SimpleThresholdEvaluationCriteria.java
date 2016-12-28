package loanapound.model;

/**
 *	Criteria checking if the score is over a specified threshold
 *
 */
public class SimpleThresholdEvaluationCriteria implements EvaluationCriteria {
	
	private final int threshold;

	public SimpleThresholdEvaluationCriteria(int threshold) {
		this.threshold = threshold;
	}

	@Override
	public boolean isAccepted(CreditScore creditScore) {
		return creditScore.getScore()>=threshold;
	}

}
