package acme.features.patron.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard>{

	@Autowired
	protected PatronDashboardRepository repository;
	
	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		assert request != null;
		
		final PatronDashboard patronDashboard = new PatronDashboard();
		
		final Integer totalNProposedPatronages;
		final Integer totalNAcceptedPatronages;
		final Integer totalNDeniedPatronages;
		
		final Double averageBudgetProposedPatronages;
		final Double averageBudgetAcceptedPatronages;
		final Double averageBudgetDeniedPatronages;
		
		final Double deviationBudgetProposedPatronages;
		final Double deviationBudgetAcceptedPatronages;
		final Double deviationBudgetDeniedPatronages;
		
		final Double minBudgetProposedPatronages;
		final Double minBudgetAcceptedPatronages;
		final Double minBudgetDeniedPatronages;
		
		final Double maxBudgetProposedPatronages;
		final Double maxBudgetAcceptedPatronages;
		final Double maxBudgetDeniedPatronages;
		
		totalNProposedPatronages = this.repository.totalNProposedPatronages();
		totalNAcceptedPatronages = this.repository.totalNAcceptedPatronages();
		totalNDeniedPatronages = this.repository.totalNDeniedPatronages();
		
		averageBudgetProposedPatronages = this.repository.averageBudgetProposedPatronages();
		averageBudgetAcceptedPatronages = this.repository.averageBudgetAcceptedPatronages();
		averageBudgetDeniedPatronages = this.repository.averageBudgetDeniedPatronages();
		
		deviationBudgetProposedPatronages = this.repository.deviationBudgetProposedPatronages();
		deviationBudgetAcceptedPatronages = this.repository.deviationBudgetAcceptedPatronages();
		deviationBudgetDeniedPatronages = this.repository.deviationBudgetDeniedPatronages();
		
		minBudgetProposedPatronages = this.repository.minBudgetProposedPatronages();
		minBudgetAcceptedPatronages = this.repository.minBudgetAcceptedPatronages();
		minBudgetDeniedPatronages = this.repository.minBudgetDeniedPatronages();
		
		maxBudgetProposedPatronages = this.repository.maxBudgetProposedPatronages();
		maxBudgetAcceptedPatronages = this.repository.maxBudgetAcceptedPatronages();
		maxBudgetDeniedPatronages = this.repository.maxBudgetDeniedPatronages();
		
		patronDashboard.setTotalNProposedPatronages(totalNProposedPatronages);
		patronDashboard.setTotalNAcceptedPatronages(totalNAcceptedPatronages);
		patronDashboard.setTotalNDeniedPatronages(totalNDeniedPatronages);
		
		patronDashboard.setAverageBudgetProposedPatronages(averageBudgetProposedPatronages);
		patronDashboard.setAverageBudgetAcceptedPatronages(averageBudgetAcceptedPatronages);
		patronDashboard.setAverageBudgetDeniedPatronages(averageBudgetDeniedPatronages);
		
		patronDashboard.setDeviationBudgetProposedPatronages(deviationBudgetProposedPatronages);
		patronDashboard.setDeviationBudgetAcceptedPatronages(deviationBudgetAcceptedPatronages);
		patronDashboard.setDeviationBudgetDeniedPatronages(deviationBudgetDeniedPatronages);
		
		patronDashboard.setMinBudgetProposedPatronages(minBudgetProposedPatronages);
		patronDashboard.setMinBudgetAcceptedPatronages(minBudgetAcceptedPatronages);
		patronDashboard.setMinBudgetDeniedPatronages(minBudgetDeniedPatronages);
		
		patronDashboard.setMaxBudgetProposedPatronages(maxBudgetProposedPatronages);
		patronDashboard.setMaxBudgetAcceptedPatronages(maxBudgetAcceptedPatronages);
		patronDashboard.setMaxBudgetDeniedPatronages(maxBudgetDeniedPatronages);
		
		return patronDashboard;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard patronDashboard, final Model model) {
		assert request != null;
		assert patronDashboard != null;
		assert model != null;
		
		request.unbind(patronDashboard, model, "totalNProposedPatronages", "totalNAcceptedPatronages","totalNDeniedPatronages",
			"averageBudgetProposedPatronages","averageBudgetAcceptedPatronages","averageBudgetDeniedPatronages",
			"deviationBudgetProposedPatronages","deviationBudgetAcceptedPatronages","deviationBudgetDeniedPatronages",
			"minBudgetProposedPatronages","minBudgetAcceptedPatronages","minBudgetDeniedPatronages",
			"maxBudgetProposedPatronages","maxBudgetAcceptedPatronages","maxBudgetDeniedPatronages");
		
	}

}
