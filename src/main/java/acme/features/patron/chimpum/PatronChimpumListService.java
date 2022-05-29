package acme.features.patron.chimpum;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Patron;

@Service
public class PatronChimpumListService implements AbstractListService<Patron, Chimpum>{
	
	@Autowired
	protected PatronChimpumRepository repository;
	
	@Override
	public boolean authorise(final Request<Chimpum> request) {
		
		assert request != null;
		
		return true;
		
	}

	@Override
	public Collection<Chimpum> findMany(final Request<Chimpum> request) {
		assert request != null;
		
		Calendar calendar;
		Date deadline;
		Collection<Chimpum> result;
		
		calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		deadline = calendar.getTime();
		
		result = this.repository.findRecentChimpum(deadline);
		
		return result;
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title", "budget", "creationMoment");
		
	}

}
