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
	
	@Autowired
	protected PatronPatronagesCreateService createPatronagesService;
	
	@Autowired
	protected PatronPatronagesPublishService publishPatronagesService;
	
	@Autowired
	protected PatronPatronagesUpdateService updatePatronagesService;
	
	@Autowired
	protected PatronPatronagesDeleteService deletePatronagesService;
	
	@PostConstruct
	protected void initialise() {
		super.addCommand("list", this.listPatronagesService);
		super.addCommand("show", this.showPatronagesService);
		super.addCommand("create", this.createPatronagesService);
		super.addCommand("publish","update", this.publishPatronagesService);
		super.addCommand("update", this.updatePatronagesService);
		super.addCommand("delete", this.deletePatronagesService);
	}

}
