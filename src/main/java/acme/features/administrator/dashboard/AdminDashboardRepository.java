package acme.features.administrator.dashboard;




import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdminDashboardRepository extends AbstractRepository{

	@Query("SELECT i FROM Item i WHERE i.type = 'COMPONENT' GROUP BY i.technology")
	Map<String, List<Double>> componentsDataByTechnology();
	
	
	@Query("SELECT i FROM Item i WHERE i.type = 'COMPONENT' GROUP BY currency")
	Map<String, List<Double>> componentsDataByCurrency();
	
	@Query("SELECT i FROM Item i WHERE i.type = 'TOOL' GROUP BY currency")
	Map<String, List<Double>> toolsDataByCurrency();
	
	@Query("SELECT p FROM Patronage p")
	Map<String, List<Double>> numberDataPatronages();
	
	
}
