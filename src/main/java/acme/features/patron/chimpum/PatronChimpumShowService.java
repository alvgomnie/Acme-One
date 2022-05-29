package acme.features.patron.chimpum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronChimpumShowService implements AbstractShowService<Patron, Chimpum>{

	@Autowired
	protected PatronChimpumRepository repository;
	
	@Override
	public boolean authorise(final Request<Chimpum> request) {
		
		assert request != null;
		
		return true;
		
	}
	
	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		assert request != null;
	
		Integer id;
		Chimpum item;
		id = request.getModel().getInteger("id");
		item = this.repository.findChimpumById(id);
		
		return item;
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		List<Item> items;
		items = this.repository.findAllItems();
		
		request.unbind(entity, model, "title", "code", "description", "budget", "creationMoment", "finishingDate",  
			"link", "item.type");	
		
		model.setAttribute("items", items);
		model.setAttribute("itemType", entity.getItem().getType());
	}

	
}
