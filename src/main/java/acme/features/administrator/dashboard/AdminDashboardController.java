
package acme.features.administrator.dashboard;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.forms.AdminDashboard;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class AdminDashboardController extends AbstractController<Patron, AdminDashboard> {

	
	@Autowired
	protected AdminDashboardShowService showDashboardService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showDashboardService);
	}

}

