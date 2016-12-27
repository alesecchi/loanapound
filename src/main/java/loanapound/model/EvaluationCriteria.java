package loanapound.model;

/**
 * Criteria to decide if a CreditScore is accepted 
 *
 */
public interface EvaluationCriteria {
	boolean isAccepted(CreditScore creditScore);
}
