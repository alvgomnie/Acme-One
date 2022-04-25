package acme.features.patron.dashboard;



import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronDashboardRepository extends AbstractRepository{

	// total number of patronages (proposed, accepted and denied)
	
	@Query("SELECT count(p) FROM Patronage p WHERE p.status = 0")
	Integer totalNProposedPatronages();
	@Query("SELECT count(p) FROM Patronage p WHERE p.status = 1")
	Integer totalNAcceptedPatronages();
	@Query("SELECT count(p) FROM Patronage p WHERE p.status = 2")
	Integer totalNDeniedPatronages();
	
	// budget of proposed /accepted/denied patronages grouped by currency
	
	// average
	
	@Query("SELECT avg(p.budget.amount) FROM Patronage p WHERE p.status = 0 GROUP BY p.budget.currency")
	Double averageBudgetProposedPatronages();
	@Query("SELECT avg(p.budget.amount) FROM Patronage p WHERE p.status = 1 GROUP BY p.budget.currency")
	Double averageBudgetAcceptedPatronages();
	@Query("SELECT avg(p.budget.amount) FROM Patronage p WHERE p.status = 2 GROUP BY p.budget.currency")
	Double averageBudgetDeniedPatronages();
	
	// deviation
	
	@Query("SELECT stddev(p.budget.amount) FROM Patronage p WHERE p.status = 0 GROUP BY p.budget.currency")
	Double deviationBudgetProposedPatronages();
	@Query("SELECT stddev(p.budget.amount) FROM Patronage p WHERE p.status = 1 GROUP BY p.budget.currency")
	Double deviationBudgetAcceptedPatronages();
	@Query("SELECT stddev(p.budget.amount) FROM Patronage p WHERE p.status = 2 GROUP BY p.budget.currency")
	Double deviationBudgetDeniedPatronages();
	
	// minimum
	
	@Query("SELECT min(p.budget.amount) FROM Patronage p WHERE p.status = 0 GROUP BY p.budget.currency")
	Double minBudgetProposedPatronages();
	@Query("SELECT min(p.budget.amount) FROM Patronage p WHERE p.status = 1 GROUP BY p.budget.currency")
	Double minBudgetAcceptedPatronages();
	@Query("SELECT min(p.budget.amount) FROM Patronage p WHERE p.status = 2 GROUP BY p.budget.currency")
	Double minBudgetDeniedPatronages();
	
	// maximum

	@Query("SELECT max(p.budget.amount) FROM Patronage p WHERE p.status = 0 GROUP BY p.budget.currency")
	Double maxBudgetProposedPatronages();
	@Query("SELECT max(p.budget.amount) FROM Patronage p WHERE p.status = 1 GROUP BY p.budget.currency")
	Double maxBudgetAcceptedPatronages();
	@Query("SELECT max(p.budget.amount) FROM Patronage p WHERE p.status = 2 GROUP BY p.budget.currency")
	Double maxBudgetDeniedPatronages();
}
