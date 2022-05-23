package acme.features.patron.patronages;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class PatronPatronagesUpdateService implements AbstractUpdateService<Patron, Patronage>{
	
	@Autowired
	protected PatronPatronagesRepository repository;
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		
		boolean result;
		int patronageId;
		Patronage patronage;
		
		patronageId = request.getModel().getInteger("id");
		patronage = this.repository.findPatronageID(patronageId);
		result = request.getPrincipal().getActiveRoleId() == patronage.getPatron().getId();
		
		return result;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		String inventorUsername;
		Inventor inventor;
		
		inventorUsername = (String) request.getModel().getAttribute("inventor");
		inventor = this.repository.findInventorByUsername(inventorUsername);
		
		request.bind(entity, errors, "startingDate", "code", "legalStuff", "budget",
			"finishingDate", "link");
		entity.setInventor(inventor);
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		List<Inventor> inventors;
		
		inventors = this.repository.findAllInventors();
		
		request.unbind(entity, model, "status", "code", "legalStuff", "budget",
			"startingDate", "finishingDate", "link", "published", "inventor", "inventor.company", "inventor.statement",
			"inventor.link", "inventor.userAccount.username");
		
		model.setAttribute("inventors", inventors);
		model.setAttribute("patronageId", entity.getId());
		
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
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("startingDate")) {
			Calendar calendar;
			
			calendar = new GregorianCalendar();
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			
			errors.state(request, entity.getStartingDate().after(calendar.getTime()), "startingDate", "patron.patronage.form.error.startingDate");
		}
		
		if(!errors.hasErrors("finishDate")) {
			Calendar calendar;
			
			calendar = new GregorianCalendar();
			calendar.setTime(entity.getStartingDate());
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			
			errors.state(request, entity.getFinishingDate().after(calendar.getTime()), "finishingDate", "patron.patronage.form.error.finishingDate");
		}
	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}

}