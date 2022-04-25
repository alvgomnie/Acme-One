package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	// total number of patronages (proposed, accepted and denied)
	
	Integer totalNProposedPatronages;
	Integer totalNAcceptedPatronages;
	Integer totalNDeniedPatronages;
	
	// budget of proposed /accepted/denied patronages grouped by currency
	
	// average
	
	Double averageBudgetProposedPatronages;
	Double averageBudgetAcceptedPatronages;
	Double averageBudgetDeniedPatronages;
	
	// deviation
	
	Double deviationBudgetProposedPatronages;
	Double deviationBudgetAcceptedPatronages;
	Double deviationBudgetDeniedPatronages;
	
	// minimum
	
	Double minBudgetProposedPatronages;
	Double minBudgetAcceptedPatronages;
	Double minBudgetDeniedPatronages;
	
	// maximum
	
	Double maxBudgetProposedPatronages;
	Double maxBudgetAcceptedPatronages;
	Double maxBudgetDeniedPatronages;
	
	
	
}
