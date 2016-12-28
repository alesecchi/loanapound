package loanapound.service;

import loanapound.model.Applicant;
import loanapound.model.Loan;
import loanapound.model.LoanApplication;
import loanapound.model.LoanApplicationStatus;

/**
 * Stub for the service related to Loan Applications 
 *
 */
public class LoanApplicationService {

	public void applyForLoan(Loan loan, Applicant applicant, double amount){
		//TODO implementation
	}
	
	public LoanApplicationStatus checkStatus(LoanApplication loanApplication){
		//TODO implementation
		return loanApplication.getStatus();
	}
}
