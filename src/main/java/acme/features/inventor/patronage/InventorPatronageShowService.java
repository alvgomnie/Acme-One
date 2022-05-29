package acme.features.inventor.patronage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorPatronageShowService implements AbstractShowService<Inventor, Patronage>{

	@Autowired
	protected InventorPatronageRepository repository;

	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;

		boolean result;
		int id;
		Patronage patronage;
		Inventor inventor;
		Principal principal;

		id = request.getModel().getInteger("id");
		patronage = this.repository.findPatronageById(id);
		
		principal = request.getPrincipal();
		inventor = patronage.getInventor();
		
		result = inventor.getUserAccount().getId() == principal.getAccountId();

		return result;
	}
	
	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;

		Patronage result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findPatronageById(id);
		
		result.setTimeLapse(new Date(result.getFinishingDate().getTime()-result.getStartingDate().getTime()));
		
		this.repository.save(result);
		return result;
	}
	
	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "status", "code", "legalStuff", "budget", "startingDate", "finishingDate", 
			"link", "patron.name", "patron.company", "patron.statement", "patron.link");
	}
	
	
	
}
