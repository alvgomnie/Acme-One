package acme.features.administrator.dashboard;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.AdminDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class AdminDashboardShowService implements AbstractShowService<Patron, AdminDashboard>{

	@Autowired
	protected AdminDashboardRepository repository;
	
	@Override
	public boolean authorise(final Request<AdminDashboard> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public AdminDashboard findOne(final Request<AdminDashboard> request) {
		assert request != null;
		
		final AdminDashboard adminDashboard = new AdminDashboard();
		
		final Map<String, List<Double>> componentsDataByTechnology;
		final Map<String, List<Double>> componentsDataByCurrency;
		final Map<String, List<Double>> toolsDataByCurrency;
		final Map<String, List<Double>> numberDataPatronages;
		
		componentsDataByTechnology = this.repository.componentsDataByTechnology();
		componentsDataByCurrency = this.repository.componentsDataByCurrency();
		toolsDataByCurrency = this.repository.toolsDataByCurrency();
		numberDataPatronages = this.repository.numberDataPatronages();
		
		adminDashboard.setComponentsDataByTechnology(componentsDataByTechnology);
		adminDashboard.setComponentsDataByCurrency(componentsDataByCurrency);
		adminDashboard.setToolsDataByCurrency(toolsDataByCurrency);
		adminDashboard.setNumberDataPatronages(numberDataPatronages);
		
		return adminDashboard;
	}

	@Override
	public void unbind(final Request<AdminDashboard> request, final AdminDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "totalNumber", "patronageData","toolsDataByCurrency","numberDataPatronages");
		
	}

}
