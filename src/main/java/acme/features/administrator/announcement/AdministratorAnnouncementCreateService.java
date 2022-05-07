package acme.features.administrator.announcement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorAnnouncementCreateService implements AbstractCreateService<Administrator, Announcement> {

		@Autowired
		protected AdministratorAnnouncementRepository repository;

		@Override
		public boolean authorise(final Request<Announcement> request) {
			assert request != null;

			return true;
		}

		@Override
		public void bind(final Request<Announcement> request, final Announcement entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			request.bind(entity, errors, "creationMoment", "title", "body", "critical", "link");
		}

		@Override
		public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "creationMoment", "title", "body", "critical", "link");
			model.setAttribute("confirmation", false);
			model.setAttribute("readonly", false);
		}

		@Override
		public Announcement instantiate(final Request<Announcement> request) {
			assert request != null;

			Announcement result;
			final Date moment = new Date(System.currentTimeMillis() - 5);

			result = new Announcement();
			result.setTitle("");
			result.setCreationMoment(moment);
			result.setBody("");
			result.setCritical(false);

			return result;
		}

		@Override
		public void validate(final Request<Announcement> request, final Announcement entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			boolean result;
			final String confirmation = "confirmation";
			final String assertTrue = "javax.validation.constraints.AssertTrue.message";

			result = request.getModel().getBoolean(confirmation);
			errors.state(request, result, confirmation, assertTrue);
		}

		@Override
		public void create(final Request<Announcement> request, final Announcement entity) {
			assert request != null;
			assert entity != null;

			final Date moment = new Date(System.currentTimeMillis() - 5);
			entity.setCreationMoment(moment);

			this.repository.save(entity);
		}

}