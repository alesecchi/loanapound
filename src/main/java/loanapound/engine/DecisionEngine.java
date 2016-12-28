package loanapound.engine;

import java.util.ArrayList;
import java.util.List;

import loanapound.creditscore.CreditScoreSystemAdapter;
import loanapound.model.Applicant;
import loanapound.model.CreditScore;
import loanapound.model.CreditScoreSystem;
import loanapound.model.EvaluationCriteria;
import loanapound.model.LoanApplication;
import loanapound.service.CreditCheckService;

/**
 * Engine for the evaluation of loan applications according to third party scoring systems and a set of evaluation criteria
 */
public class DecisionEngine {
	
	private final CreditCheckService creditCheckService = new CreditCheckService(); 

	private List<CreditScoreSystem> creditScoreSystemList = new ArrayList<>();
	private List<EvaluationCriteria> evaluationCriteriaList = new ArrayList<>();
	
	public void addCreditScoreSystem(CreditScoreSystem creditScoreSystemAdapter){
		creditScoreSystemList.add(creditScoreSystemAdapter);
	}
	
	public void addEvaluationCriteria(EvaluationCriteria evaluationCriteria){
		evaluationCriteriaList.add(evaluationCriteria);
	}
	
	/**
	 * Evaluate if the specified loanApplication would be accepted based on the previously loaded 
	 * CreditScoreSystemAdapter and EvaluationCriteria
	 * 
	 * @param loanApplication	loan application to evaluate
	 * @return true if the application would be accepted, false if at least one evaluation is not passed 
	 * 			or there are no score systems or criteria loaded into the engine
	 */
	public boolean evaluateLoanApplication(LoanApplication loanApplication){
		boolean accepted = !creditScoreSystemList.isEmpty() && !evaluationCriteriaList.isEmpty();
		List<CreditScore> creditScoreList = creditCheckService.getCreditScoresForApplicant(loanApplication.getApplicant(), creditScoreSystemList);
		for(CreditScore creditScore : creditScoreList){
			for(EvaluationCriteria evaluationCriteria : evaluationCriteriaList){
				accepted = accepted && evaluationCriteria.isAccepted(creditScore);
			}
		}
		return accepted;
	}
	
	/**
	 * Get one or multiple credit scores for the specified Applicant from previously loaded CreditScoreSystemAdapter
	 * 
	 * @param applicant applicant to be scored
	 * @return list of scores from third party systems
	 */
	public List<CreditScore> getCreditScoresForApplicant(Applicant applicant){
		return creditCheckService.getCreditScoresForApplicant(applicant, creditScoreSystemList);
	}
}
