package loanapound.creditscore;

import loanapound.model.Applicant;
import loanapound.model.CreditScore;

/**
 * Adapter to interrogate a credit score third party system
 *
 */
public interface CreditScoreSystemAdapter {
	CreditScore getScoreForApplicant(Applicant applicant);
}
