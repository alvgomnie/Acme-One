package acme.features.administrator.dashboard;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdminDashboardRepository extends AbstractRepository{

	@Query("select count(i) from Item i where i.type=1")
	int totalNComponents();
	@Query("select count(i) from Item i where i.type=0")
	int totalNTools();
	@Query("select count(p) from Patronage p")
	int totalNPatronages();
	
	@Query("select p.status, count(p) from Patronage p group by p.status")
	List<Object[]> totalNPatronagesByStatus();




	@Query("select c.technology,c.retailPrice.currency, avg(c.retailPrice.amount) from Item c  where c.type=1 group by c.technology,c.retailPrice.currency")
	List<Object[]> averageRetailPriceComponentsByTechAndCurrency();
	@Query("select t.retailPrice.currency, avg(t.retailPrice.amount) from Item t where t.type=0 group by t.retailPrice.currency")
	List<Object[]> averageRetailPriceToolByCurrency();
	@Query("select p.status ,avg(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> averageBudgetPatronagesByStatus();

	

	
	@Query("select c.technology,c.retailPrice.currency, stddev(c.retailPrice.amount) from Item c where c.type=1 group by c.technology,c.retailPrice.currency")
	List<Object[]> deviationRetailPriceComponentByTechAndCurrency();
	@Query("select t.retailPrice.currency, stddev(t.retailPrice.amount) from Item t where t.type=0 group by t.retailPrice.currency")
	List<Object[]> deviationRetailPriceToolByCurrency();
	@Query("select p.status ,stddev(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> deviationBudgetPatronagesByStatus();

	
//	Minimum 
	
	@Query("select c.technology,c.retailPrice.currency, min(c.retailPrice.amount) from Item c where c.type=1 group by c.technology,c.retailPrice.currency")
	List<Object[]> minRetailPriceComponentByTechAndCurrency();
	@Query("select t.retailPrice.currency, min(t.retailPrice.amount) from Item t where t.type=0 group by t.retailPrice.currency")
	List<Object[]> minRetailPriceToolByCurrency();
	@Query("select p.status ,min(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> minBudgetPatronagesByStatus();

	
	
	
//	Maximum 
	
	@Query("select c.technology,c.retailPrice.currency, max(c.retailPrice.amount) from Item c where c.type=1 group by c.technology,c.retailPrice.currency")
	List<Object[]> maxRetailPriceComponentByTechAndCurrency();
	@Query("select t.retailPrice.currency, max(t.retailPrice.amount) from Item t where t.type=0 group by t.retailPrice.currency")
	List<Object[]> maxRetailPriceToolByCurrency();
	@Query("select p.status ,max(p.budget.amount) from Patronage p group by p.status")
	List<Object[]> maxBudgetPatronagesByStatus();
	
	
	
	//CC
	
	//average
	@Query("select c.budget.currency, avg(c.budget.amount) from Chimpum c group by c.budget.currency")
	List<Object[]> averageBudgetByCurrency();
	
	//deviation
	@Query("select c.budget.currency, stddev(c.budget.amount) from Chimpum c group by c.budget.currency")
	List<Object[]> deviationBudgetByCurrency();
	
	//minimum
	@Query("select c.budget.currency, min(c.budget.amount) from Chimpum c group by c.budget.currency")
	List<Object[]> minBudgetByCurrency();
	
	//maximum
	@Query("select c.budget.currency, max(c.budget.amount) from Chimpum c group by c.budget.currency")
	List<Object[]> maxBudgetByCurrency();
}
