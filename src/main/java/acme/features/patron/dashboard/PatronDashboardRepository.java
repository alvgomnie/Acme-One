package acme.features.patron.dashboard;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronDashboardRepository extends AbstractRepository{

	@Query("SELECT p FROM Patronage p")
	Map<String, Integer> totalNumber();
	
	@Query("SELECT p FROM Patronage p")
	Map<String, List<Double>> patronageData();
}
