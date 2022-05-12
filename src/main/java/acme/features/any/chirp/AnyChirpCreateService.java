package acme.features.any.chirp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Chirp;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractCreateService;

@Service
public class AnyChirpCreateService implements AbstractCreateService<Any, Chirp> {

		@Autowired
		protected AnyChripRepository repository;


		@Override
		public boolean authorise(final Request<Chirp> request) {
			assert request != null;

			return true;
		}
		
		@Override
		public Chirp instantiate(final Request<Chirp> request) {
			assert request != null;
			Chirp res;
			res = new Chirp();
			return res;
		}

		
		@Override
		public void bind(final Request<Chirp> request, final Chirp entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;
			Date moment;
			moment = new Date(System.currentTimeMillis() - 1);
			request.bind(entity, errors, "title", "author", "body", "email");
			entity.setMoment(moment);
		}

		
		@Override
		public void unbind(final Request<Chirp> request, final Chirp entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "title", "author","moment", "body", "email");
			model.setAttribute("confirm", "false");
		}
		
		@Override
		public void validate(final Request<Chirp> request, final Chirp entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			final Boolean confirmed = request.getModel().getBoolean("confirm");
			errors.state(request, confirmed, "confirm", "any.chirp.form.error.must-confirm");
			
		}

		@Override
		public void create(final Request<Chirp> request, final Chirp entity) {
			assert request != null;
			assert entity != null;
			this.repository.save(entity);
		}
}
