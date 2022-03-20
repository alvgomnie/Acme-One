package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.PatronageStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Pair<PatronageStatus, Integer> totalNumberOfPatronages;

	Map<String, Pair<PatronageStatus, Double>> averageBudgetOfPatronagesGroupedByCurrency;
	
	Map<String, Pair<PatronageStatus, Double>> deviationBudgetOfPatronagesGroupedByCurrency;
	
	Map<String, Pair<PatronageStatus, Double>> minimumBudgetOfPatronagesGroupedByCurrency;
	
	Map<String, Pair<PatronageStatus, Double>> maximumBudgetOfPatronagesGroupedByCurrency;

}
