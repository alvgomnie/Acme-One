package acme.features.patron.patronages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronagesShowService implements AbstractShowService<Patron, Patronage>{

	@Autowired
	protected PatronPatronagesRepository repository;
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		return true;
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;
		
		Patronage patronage;
		int id;
		
		id = request.getModel().getInteger("id");
		patronage = this.repository.findPatronageID(id);
		
		return patronage;
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage patronage, final Model model) {
		assert request != null;
		assert patronage != null;
		assert model != null;
		
		request.unbind(patronage, model, "status", "code", "legalStuff", "budget",
			"startingDate", "finishingDate", "link", "patron", "inventor");
		model.setAttribute("inventorId", patronage.getInventor().getId());
	}

}
