package loanapound.model;

import javax.xml.bind.annotation.XmlRootElement;

import loanapound.creditscore.CreditScoreSystemAdapter;

@XmlRootElement()
public class CreditScoreSystem {

	private Long creditScoreSystemId;
	private String companyName;
	private CreditScoreSystemAdapter adapter;
	
	public Long getCreditScoreSystemId() {
		return creditScoreSystemId;
	}
	public void setCreditScoreSystemId(Long creditScoreSystemId) {
		this.creditScoreSystemId = creditScoreSystemId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public CreditScoreSystemAdapter getAdapter() {
		return adapter;
	}
	public void setAdapter(CreditScoreSystemAdapter adapter) {
		this.adapter = adapter;
	}
}
