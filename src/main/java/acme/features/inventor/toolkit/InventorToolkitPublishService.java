package acme.features.inventor.toolkit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Item;
import acme.entities.Toolkit;
import acme.features.inventor.item.InventorItemRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitPublishService implements AbstractUpdateService<Inventor, Toolkit> {
	
	@Autowired
	protected InventorToolkitRepository repository;

	
	@Autowired
	protected InventorItemRepository itemRepository;
	
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		boolean result;
		int id;
		Toolkit toolkit;
		Inventor inventor;

		id = request.getModel().getInteger("id");
		toolkit = this.repository.findToolkitById(id);
		inventor = toolkit.getInventor();
		result = !toolkit.getPublish() && request.isPrincipal(inventor);

		return result;
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		entity.setItem(this.itemRepository.findItemById(Integer.valueOf(request.getModel().getAttribute("itemId").toString())));
		request.bind(entity, errors, "code", "title", "description", "assemblyNotes", "link", "publish");
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model!=null;
		final List<Item> li = this.itemRepository.findAllItem();
		model.setAttribute("allItems", li);
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "link", "publish");
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findToolkitById(id);

		return result;
	}
	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void update(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;
		entity.setPublish(true);
		this.repository.save(entity);
	}
	
}
