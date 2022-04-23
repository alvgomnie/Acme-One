package acme.forms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDashboard implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Map<String, List<Double>> componentsDataByTechnology;
	Map<String, List<Double>> componentsDataByCurrency;
	
	Map<String, List<Double>> toolsDataByCurrency;
	Map<String, List<Double>> numberDataPatronages; // proposed: numberOfProposed, deviationBudget, minimumBugdet, maximumBudget

}
