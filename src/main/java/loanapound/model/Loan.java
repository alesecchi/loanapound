package loanapound.model;

public interface Loan {
	Long getLoanId();
	void setLoanId(Long loanId);
	Double getBorrowingRate();
	void setBorrowingRate(Double borrowingRate);
	Long getDuration();
	void setDuration(Long duration);
	String getProvider(); 
	void setProvider(String provider);
}
