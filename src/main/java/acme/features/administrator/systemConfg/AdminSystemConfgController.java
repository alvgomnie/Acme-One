package acme.features.administrator.systemConfg;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.components.SystemConfiguration;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Administrator;

@Controller
public class AdminSystemConfgController extends AbstractController<Administrator, SystemConfiguration> {

	
	@Autowired
	protected AdminSystemConfgShowService showSystemConfgService;
	
	@Autowired
	protected AdminSystemConfgUpdateService updateSystemConfgService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showSystemConfgService);
		super.addCommand("update", this.updateSystemConfgService);
	}

}
