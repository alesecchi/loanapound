package loanapound.model;

/**
 * Representation of an application for a loan for a specified amount by an applicant 
 *
 */
public class LoanApplication {
	private final Loan loan;
	private final Applicant applicant;
	private final double amount;
	private LoanApplicationStatus status;

	public LoanApplication(Loan loan, Applicant applicant, double amount) {
		this.loan = loan;
		this.applicant = applicant;
		this.amount = amount;
		this.status = LoanApplicationStatus.Pending;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public Loan getLoan() {
		return loan;
	}

	public double getAmount() {
		return amount;
	}

	public LoanApplicationStatus getStatus() {
		return status;
	}
	
	/**
	 * Approves a pending loan application
	 */
	public void approve(){
		if(status == LoanApplicationStatus.Pending){
			status = LoanApplicationStatus.Accepted;
		}
	}
	
	/**
	 * Rejects a pending loan application
	 */
	public void reject(){
		if(status == LoanApplicationStatus.Pending){
			this.status = LoanApplicationStatus.Rejected;
		}
	}
	
	
}
