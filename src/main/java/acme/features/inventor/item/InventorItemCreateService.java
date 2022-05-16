package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorItemCreateService implements AbstractCreateService<Inventor, Item>{

	@Autowired
	protected InventorItemRepository repository;
	
	@Override
	public boolean authorise(final Request<Item> request) {

		assert request != null;
		
		return true;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "name", "code", "technology", "description", "retailPrice", "type", "link");
		
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "code", "technology", "description", "retailPrice", "type", "link", "published");
	}

	@Override
	public Item instantiate(final Request<Item> request) {

		assert request != null;
		
		Item result;
		Inventor inventor;
		
		inventor = this.repository.findInventorById(request.getPrincipal().getActiveRoleId());
		result = new Item();
		result.setPublished(false);
		result.setInventor(inventor);
		
		return result;
	}

	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void create(final Request<Item> request, final Item entity) {

		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
		
	}

	
}
