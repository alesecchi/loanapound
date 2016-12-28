package loanapound.model;

public class BaseLoan implements Loan {
	private Long loanId;
	private Double borrowingRate;
	private Long duration;
	private String provider; //this should eventually be a model class
	
	@Override
	public Long getLoanId() {
		return loanId;
	}
	@Override
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	@Override
	public Double getBorrowingRate() {
		return borrowingRate;
	}
	@Override
	public void setBorrowingRate(Double borrowingRate) {
		this.borrowingRate = borrowingRate;
	}
	@Override
	public Long getDuration() {
		return duration;
	}
	@Override
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	@Override
	public String getProvider() {
		return provider;
	}
	@Override
	public void setProvider(String provider) {
		this.provider = provider;
	}



}
