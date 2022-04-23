package acme.features.administrator.systemConfg;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.components.SystemConfiguration;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class AdminSystemConfgController extends AbstractController<Patron, SystemConfiguration> {

	
	@Autowired
	protected AdminSystemConfgShowService showSystemConfgService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showSystemConfgService);
	}

}
