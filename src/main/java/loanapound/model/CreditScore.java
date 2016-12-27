package loanapound.model;

/**
 * Numerical expression representing the score of an applicant for a loan,
 * in a range of minValue-maxValue.
 *
 */
public class CreditScore {
	private int minValue;
	private int maxValue;
	private int score;
	
	public CreditScore(int minValue, int maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	
	/**
	 * Assignment of a score, checking if it is inside the allowed range
	 * @param score
	 * @throws CreditScoreException
	 */
	public void assignScore(int score) throws CreditScoreException{
		if(score<minValue || score>maxValue){
			throw new CreditScoreException("Score out of range");
		}
		this.score = score;
	}

	public int getMinValue() {
		return minValue;
	}


	public int getMaxValue() {
		return maxValue;
	}


	public int getScore() {
		return score;
	}

	
}
