package loanapound.model.mock;

import loanapound.model.Applicant;
import loanapound.model.BaseLoan;
import loanapound.model.Loan;
import loanapound.model.LoanApplication;
import loanapound.model.LoanApplicationStatus;

public class MockLoanApplication extends LoanApplication {

	public MockLoanApplication(double amount) {
		super(new BaseLoan(), new Applicant(), amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Applicant getApplicant() {
		// TODO Auto-generated method stub
		return new Applicant();
	}

	@Override
	public Loan getLoan() {
		// TODO Auto-generated method stub
		return new BaseLoan();
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return super.getAmount();
	}

	@Override
	public LoanApplicationStatus getStatus() {
		// TODO Auto-generated method stub
		return super.getStatus();
	}

	@Override
	public void approve() {
		// TODO Auto-generated method stub
		super.approve();
	}

	@Override
	public void reject() {
		// TODO Auto-generated method stub
		super.reject();
	}

}
