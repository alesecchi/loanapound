package loanapound.engine;

import java.util.ArrayList;
import java.util.List;

import loanapound.creditscore.CreditScoreSystemAdapter;
import loanapound.model.Applicant;
import loanapound.model.CreditScore;
import loanapound.model.EvaluationCriteria;
import loanapound.model.LoanApplication;

/**
 * Engine for the evaluation of loan applications according to third party scoring systems and a set of evaluation criteria
 */
public class DecisionEngine {

	private List<CreditScoreSystemAdapter> creditScoreSystemAdapterList = new ArrayList<>();
	private List<EvaluationCriteria> evaluationCriteriaList = new ArrayList<>();
	
	public void addCreditScoreSystem(CreditScoreSystemAdapter creditScoreSystemAdapter){
		creditScoreSystemAdapterList.add(creditScoreSystemAdapter);
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
		boolean accepted = !creditScoreSystemAdapterList.isEmpty() && !evaluationCriteriaList.isEmpty();
		for(CreditScoreSystemAdapter creditScoreSystem : creditScoreSystemAdapterList){
			CreditScore creditScore = creditScoreSystem.getScoreForApplicant(loanApplication.getApplicant());
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
		List<CreditScore> creditScoreList = new ArrayList<>();
		for(CreditScoreSystemAdapter creditScoreSystem : creditScoreSystemAdapterList){
			creditScoreList.add(creditScoreSystem.getScoreForApplicant(applicant));
		}
		return creditScoreList;
	}
}
