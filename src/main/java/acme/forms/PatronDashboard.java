package acme.forms;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Integer totalNumberOfProposedPatronages;
	Integer totalNumberOfAcceptedPatronages;
	Integer totalNumberOfDeniedPatronages;

	Map<String, Double> averageBudgetOfProposedPatronagesGroupedByCurrency;
	Map<String, Double> averageBudgetOfAcceptedPatronagesGroupedByCurrency;
	Map<String, Double> averageBudgetOfDeniedPatronagesGroupedByCurrency;
	
	Map<String, Double> deviationBudgetOfProposedPatronagesGroupedByCurrency;
	Map<String, Double> deviationBudgetOfAcceptedPatronagesGroupedByCurrency;
	Map<String, Double> deviationBudgetOfDeniedPatronagesGroupedByCurrency;
	
	Map<String, Double> minimumBudgetOfProposedPatronagesGroupedByCurrency;
	Map<String, Double> minimumBudgetOfAcceptedPatronagesGroupedByCurrency;
	Map<String, Double> minimumBudgetOfDeniedPatronagesGroupedByCurrency;	
	
	Map<String, Double> maximumBudgetOfProposedPatronagesGroupedByCurrency;
	Map<String, Double> maximumBudgetOfAcceptedPatronagesGroupedByCurrency;
	Map<String, Double> maximumBudgetOfDeniedPatronagesGroupedByCurrency;

}
