package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

import acme.entities.PatronageStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDashboard implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	Integer totalNComponents;
	Integer totalNTools;
	Integer totalNPatronages;
	
	Map<PatronageStatus, Integer> totalNPatronagesByStatus;
	

	Map<Pair<String,String>,Double> averageRetailPriceComponentsByTechAndCurrency;
	Map<String,Double> averageRetailPriceToolByCurrency;
	Map<PatronageStatus,Double> averageBudgetPatronagesByStatus;
	
	Map<Pair<String,String>,Double> deviationRetailPriceComponentByTechAndCurrency;
	Map<String,Double> deviationRetailPriceToolByCurrency;
	Map<PatronageStatus,Double> deviationBudgetPatronagesByStatus;
	
	Map<Pair<String,String>,Double> minRetailPriceComponentByTechAndCurrency;
	Map<String,Double> minRetailPriceToolByCurrency;
	Map<PatronageStatus,Double> minBudgetPatronagesByStatus;
	
	Map<Pair<String,String>,Double> maxRetailPriceComponentByTechAndCurrency;
	Map<String,Double> maxRetailPriceToolByCurrency;
	Map<PatronageStatus,Double> maxBudgetPatronagesByStatus;








	
	
}
