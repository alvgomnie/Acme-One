package acme.features.patron.dashboard;

import java.util.List;
import java.util.Map;

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
		
		final Map<String, Integer> totalNumber;
		final Map<String, List<Double>> patronageData;
		
		totalNumber = this.repository.totalNumber();
		patronageData = this.repository.patronageData();
		
		patronDashboard.setTotalNumber(totalNumber);
		patronDashboard.setPatronageData(patronageData);
		
		return patronDashboard;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard patronDashboard, final Model model) {
		assert request != null;
		assert patronDashboard != null;
		assert model != null;
		
		request.unbind(patronDashboard, model, "totalNumber", "patronageData");
		
	}

}
