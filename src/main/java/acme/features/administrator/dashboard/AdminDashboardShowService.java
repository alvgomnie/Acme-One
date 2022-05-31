package acme.features.administrator.dashboard;

import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.PatronageStatus;
import acme.features.any.item.AnyItemRepository;
import acme.features.inventor.chimpum.InventorChimpumRepository;
import acme.forms.AdminDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class AdminDashboardShowService implements AbstractShowService<Patron, AdminDashboard>{

	@Autowired
	protected AdminDashboardRepository repository;
	
	@Autowired
	protected AnyItemRepository itemRepository;
	
	
	//si es inventor
	@Autowired
	protected InventorChimpumRepository chimpumRepository;
	
	//si es patron
//	@Autowired
//	protected PatronChimpumRepository chimpumRepository;
	
	@Override
	public boolean authorise(final Request<AdminDashboard> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public AdminDashboard findOne(final Request<AdminDashboard> request) {
		assert request != null;
		
		final AdminDashboard adminDashboard = new AdminDashboard();
		
		final Integer totalNComponents;
		final Integer totalNTools;
		final Integer totalNPatronages;
		
		final Map<PatronageStatus, Integer> totalNPatronagesByStatus;
		

		final Map<Pair<String,String>,Double> averageRetailPriceComponentsByTechAndCurrency;
		final Map<String,Double> averageRetailPriceToolByCurrency;
		final Map<PatronageStatus,Double> averageBudgetPatronagesByStatus;
		
		final Map<Pair<String,String>,Double> deviationRetailPriceComponentByTechAndCurrency;
		final Map<String,Double> deviationRetailPriceToolByCurrency;
		final Map<PatronageStatus,Double> deviationBudgetPatronagesByStatus;
		
		final Map<Pair<String,String>,Double> minRetailPriceComponentByTechAndCurrency;
		final Map<String,Double> minRetailPriceToolByCurrency;
		final Map<PatronageStatus,Double> minBudgetPatronagesByStatus;
		
		final Map<Pair<String,String>,Double> maxRetailPriceComponentByTechAndCurrency;
		final Map<String,Double> maxRetailPriceToolByCurrency;
		final Map<PatronageStatus,Double> maxBudgetPatronagesByStatus;
		
		
		totalNComponents = this.repository.totalNComponents();
		totalNTools = this.repository.totalNTools();
		totalNPatronages = this.repository.totalNPatronages();
		
		totalNPatronagesByStatus = this.repository.totalNPatronagesByStatus().stream().collect(Collectors.toMap(x-> (PatronageStatus)x[0],x->((Double)x[1]).intValue()));
		
		averageRetailPriceComponentsByTechAndCurrency = this.repository.averageRetailPriceComponentsByTechAndCurrency().stream()
			.collect(Collectors.toMap(x->Pair.of((String)x[0], (String)x[1]), x->(Double) x[2]));
		averageRetailPriceToolByCurrency = this.repository.averageRetailPriceToolByCurrency().stream()
			.collect(Collectors.toMap(x->(String)x[0], x->(Double) x[1]));
		averageBudgetPatronagesByStatus = this.repository.averageBudgetPatronagesByStatus().stream()
			.collect(Collectors.toMap(x->(PatronageStatus)x[0], x->(Double) x[1]));
		
		deviationRetailPriceComponentByTechAndCurrency = this.repository.deviationRetailPriceComponentByTechAndCurrency().stream()
			.collect(Collectors.toMap(x->Pair.of((String)x[0], (String)x[1]), x->(Double) x[2]));
		deviationRetailPriceToolByCurrency = this.repository.deviationRetailPriceToolByCurrency().stream()
			.collect(Collectors.toMap(x->(String)x[0], x->(Double) x[1]));
		deviationBudgetPatronagesByStatus = this.repository.deviationBudgetPatronagesByStatus().stream()
			.collect(Collectors.toMap(x->(PatronageStatus)x[0], x->(Double) x[1]));
		
		minRetailPriceComponentByTechAndCurrency = this.repository.minRetailPriceComponentByTechAndCurrency().stream()
			.collect(Collectors.toMap(x->Pair.of((String)x[0], (String)x[1]), x->(Double) x[2]));
		minRetailPriceToolByCurrency = this.repository.minRetailPriceToolByCurrency().stream()
			.collect(Collectors.toMap(x->(String)x[0], x->(Double) x[1]));
		minBudgetPatronagesByStatus = this.repository.minBudgetPatronagesByStatus().stream()
			.collect(Collectors.toMap(x->(PatronageStatus)x[0], x->Double.valueOf(x[1].toString())));
		
		maxRetailPriceComponentByTechAndCurrency = this.repository.maxRetailPriceComponentByTechAndCurrency().stream()
			.collect(Collectors.toMap(x->Pair.of((String)x[0], (String)x[1]), x->(Double) x[2]));
		maxRetailPriceToolByCurrency = this.repository.maxRetailPriceToolByCurrency().stream()
			.collect(Collectors.toMap(x->(String)x[0], x->(Double) x[1]));
		maxBudgetPatronagesByStatus = this.repository.maxBudgetPatronagesByStatus().stream()
			.collect(Collectors.toMap(x->(PatronageStatus)x[0], x->Double.valueOf(x[1].toString())));
		
		
		
		adminDashboard.setTotalNComponents(totalNComponents);
		adminDashboard.setTotalNTools(totalNTools);
		adminDashboard.setTotalNPatronages(totalNPatronages);
		adminDashboard.setTotalNPatronagesByStatus(totalNPatronagesByStatus);
		adminDashboard.setAverageRetailPriceComponentsByTechAndCurrency(averageRetailPriceComponentsByTechAndCurrency);
		adminDashboard.setAverageRetailPriceToolByCurrency(averageRetailPriceToolByCurrency);
		adminDashboard.setAverageBudgetPatronagesByStatus(averageBudgetPatronagesByStatus);
		adminDashboard.setDeviationBudgetPatronagesByStatus(deviationBudgetPatronagesByStatus);
		adminDashboard.setDeviationRetailPriceComponentByTechAndCurrency(deviationRetailPriceComponentByTechAndCurrency);
		adminDashboard.setDeviationRetailPriceToolByCurrency(deviationRetailPriceToolByCurrency);
		adminDashboard.setMinBudgetPatronagesByStatus(minBudgetPatronagesByStatus);
		adminDashboard.setMinRetailPriceComponentByTechAndCurrency(minRetailPriceComponentByTechAndCurrency);
		adminDashboard.setMinRetailPriceToolByCurrency(minRetailPriceToolByCurrency);
		adminDashboard.setMaxBudgetPatronagesByStatus(maxBudgetPatronagesByStatus);
		adminDashboard.setMaxRetailPriceComponentByTechAndCurrency(maxRetailPriceComponentByTechAndCurrency);
		adminDashboard.setMaxRetailPriceToolByCurrency(maxRetailPriceToolByCurrency);
		
		
		//CC -------------------------------------------------------------------------------------------------------------

		//si es tool
//		final Double ratio = ((double)this.chimpumRepository.findToolWithChimpum().size()/(double)this.itemRepository.findAllComponents().size());
		
		//si es component
		final Double ratio = ((double)this.chimpumRepository.findComponentWithChimpum().size()/(double)this.itemRepository.findAllComponents().size());
		
		final Map<String,Double> averageBudgetByCurrency;
		final Map<String,Double> deviationBudgetByCurrency;
		final Map<String,Double> minBudgetByCurrency;
		final Map<String,Double> maxBudgetByCurrency;
		
		averageBudgetByCurrency = this.repository.averageBudgetByCurrency().stream()
			.collect(Collectors.toMap(x->(String)x[0], x->(Double) x[1]));
		
		deviationBudgetByCurrency = this.repository.deviationBudgetByCurrency().stream()
			.collect(Collectors.toMap(x->(String)x[0], x->(Double) x[1]));
		
		minBudgetByCurrency = this.repository.minBudgetByCurrency().stream()
			.collect(Collectors.toMap(x->(String)x[0], x->(Double) x[1]));
			
		maxBudgetByCurrency = this.repository.maxBudgetByCurrency().stream()
			.collect(Collectors.toMap(x->(String)x[0], x->(Double) x[1]));
		
		adminDashboard.setRatio(ratio);
		adminDashboard.setAverageBudgetByCurrency(averageBudgetByCurrency);
		adminDashboard.setDeviationBudgetByCurrency(deviationBudgetByCurrency);
		adminDashboard.setMinBudgetByCurrency(minBudgetByCurrency);
		adminDashboard.setMaxBudgetByCurrency(maxBudgetByCurrency);
		
		
		
		//----------------------------------------------------------------------------------------------------------------
		
		return adminDashboard;
	}

	@Override
	public void unbind(final Request<AdminDashboard> request, final AdminDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "totalNComponents", "totalNTools","totalNPatronages","totalNPatronagesByStatus",
			"averageRetailPriceComponentsByTechAndCurrency","averageRetailPriceToolByCurrency","averageBudgetPatronagesByStatus",
			"deviationRetailPriceComponentByTechAndCurrency","deviationRetailPriceToolByCurrency","deviationBudgetPatronagesByStatus",
			"minRetailPriceComponentByTechAndCurrency","minRetailPriceToolByCurrency","minBudgetPatronagesByStatus",
			"maxRetailPriceComponentByTechAndCurrency","maxRetailPriceToolByCurrency","maxBudgetPatronagesByStatus",
			"ratio", "averageBudgetByCurrency", "deviationBudgetByCurrency", "minBudgetByCurrency", "maxBudgetByCurrency");
		
	}

}
