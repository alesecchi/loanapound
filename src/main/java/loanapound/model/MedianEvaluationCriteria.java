package loanapound.model;

/**
 *	Criteria checking if the score is over the median of the range 
 *
 */
public class MedianEvaluationCriteria implements EvaluationCriteria {

	@Override
	public boolean isAccepted(CreditScore creditScore) {
		int median = (creditScore.getMaxValue() + creditScore.getMinValue()) / 2;
		return creditScore.getScore()>=median;
	}

}
