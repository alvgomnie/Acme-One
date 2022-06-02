package acme.features.patron.chimpum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chimpum;
import acme.entities.Item;
import acme.features.inventor.item.InventorItemRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Patron;

@Service
public class PatronChimpumUpdateService implements AbstractUpdateService<Patron, Chimpum> {
	
	@Autowired
	protected PatronChimpumRepository repository;
	
	@Autowired
	protected InventorItemRepository itemRepository;

	@Override
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;
			
		return true;
	}

	@Override
	public void bind(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		entity.setItem(this.itemRepository.findItemById(Integer.valueOf(request.getModel().getAttribute("itemId").toString())));
		request.bind(entity, errors,  "title", "code", "description", "budget", "creationMoment", "finishingDate", "link");
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model!=null;
		
		
		//si es tool
		final Collection<Item> li = this.itemRepository.findAllTools();
		model.setAttribute("items", li);
		
//		//si es component
//		final Collection<Item> li = this.itemRepository.findAllComponents();
//		model.setAttribute("allItems", li);
		
		
		request.unbind(entity, model,  "title", "code", "description", "budget", "creationMoment", "finishingDate", "link");
	}

	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		assert request != null;

		Chimpum result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findChimpumById(id);

		return result;
	}
	@Override
	public void validate(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<Chimpum> request, final Chimpum entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}
	
}
