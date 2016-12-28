package loanapound.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import loanapound.dataaccess.CreditScoreSystemDataAccess;
import loanapound.model.Applicant;
import loanapound.model.CreditScore;
import loanapound.model.CreditScoreSystem;

@Path("/creditcheck")
public class CreditCheckService {

	
	public List<CreditScore> getCreditScoresForApplicant(Applicant applicant, List<CreditScoreSystem> creditScoreSystemList){
		List<CreditScore> creditScoreList = new ArrayList<>();
		for(CreditScoreSystem creditScoreSystem : creditScoreSystemList){
			creditScoreList.add(creditScoreSystem.getAdapter().getScoreForApplicant(applicant));
		}
		return creditScoreList;
	}
	
	@Path("/scoresystem")
	@GET
	@Produces("application/json")
	public List<CreditScoreSystem> getCreditScoreSystems(){
		CreditScoreSystemDataAccess creditScoreDataAccess = new CreditScoreSystemDataAccess();
		return creditScoreDataAccess.getAllCreditScoreSystems();
	}
}
