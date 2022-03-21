package acme.forms;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Map<String, Integer> totalNumber;
	Map<String, List<Double>>patronageData;

}
