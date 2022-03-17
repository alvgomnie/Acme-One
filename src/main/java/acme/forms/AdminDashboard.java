package acme.forms;

import java.io.Serializable;
import java.util.Map;

public class AdminDashboard implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Integer totalNumOfComponents;
	
	Map<String, Double> averageRPriceComponentsByTechnology;
	Map<String, Double> deviationRPriceComponentsByTechnology;
	Map<String, Double> minRPriceComponentsByTechnology;
	Map<String, Double> maxRPriceComponentsByTechnology;
	
	Map<String, Double> averageRPriceComponentsByCurrency;
	Map<String, Double> deviationRPriceComponentsByCurrency;
	Map<String, Double> minRPriceComponentsByCurrency;
	Map<String, Double> maxRPriceComponentsByCurrency;
	
	Integer totalNumOfTools;
	
	Map<String, Double> averageRPriceToolsByCurrency;
	Map<String, Double> deviationRPriceToolsByCurrency;
	Map<String, Double> minRPriceToolsByCurrency;
	Map<String, Double> maxRPriceToolsByCurrency;
	
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
