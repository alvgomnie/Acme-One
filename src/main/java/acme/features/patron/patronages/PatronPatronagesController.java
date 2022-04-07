package acme.features.patron.patronages;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.Patronage;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronPatronagesController extends AbstractController<Patron, Patronage> {
	
	@Autowired
	protected PatronPatronagesListService listPatronagesService;
	
	@Autowired
	protected PatronPatronagesShowService showPatronagesService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("listPatronages", this.listPatronagesService);
		super.addCommand("showPatronages", this.showPatronagesService);
	}

}
