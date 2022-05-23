package acme.features.inventor.patronageReport;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Patronage;
import acme.entities.PatronageReport;
import acme.features.inventor.patronage.InventorPatronageRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport>{
	
	@Autowired
	protected InventorPatronageReportRepository repository;
	
	@Autowired
	protected InventorPatronageRepository patronageRepository;
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		entity.setPatronage(this.patronageRepository.findPatronageById(Integer.valueOf(request.getModel().getAttribute("patronageId").toString())));
		request.bind(entity, errors, "automaticSeqNum", "creationMoment", "memorandum", "link", "confirmation");
	}
	
	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final Integer inventorId = request.getPrincipal().getActiveRoleId();
		final Collection<Patronage> patronages= this.patronageRepository.findPatronagesByInventorId(inventorId);
		model.setAttribute("patronages", patronages);
		model.setAttribute("confirmation", false);

		request.unbind(entity, model, "automaticSeqNum", "creationMoment", "memorandum", "link");
		
	}
	
	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;

		PatronageReport result;
		
		final Date moment = new Date(System.currentTimeMillis() - 5);
		final Inventor inventor = this.repository.findInventorById(request.getPrincipal().getActiveRoleId());
		final String seqNum = this.generateAutomaticSeqNum();

		result = new PatronageReport();
		result.setAutomaticSeqNum(seqNum);
		result.setCreationMoment(moment);
		result.setInventor(inventor);
		result.setMemorandum("");
		result.setLink("http://");

		return result;
	}

	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
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
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		assert request != null;
		assert entity != null;

		final Date moment = new Date(System.currentTimeMillis() - 5);
		entity.setCreationMoment(moment);

		this.repository.save(entity);
	}
	
	public String generateAutomaticSeqNum() {
		
		int lastNum;
    	String res = "";

    	String finalSeq = ":";
    	final Integer allPR = this.repository.findAllPatronagesReport()+1;
    	final Integer allPRSize = String.valueOf(allPR).length();
    	
    	final Random r = new Random();
    	lastNum = r.nextInt(26);
    	final char letter = (char)(lastNum+65);
    	
    	switch(allPRSize) {
	    	case 1: finalSeq += ("000"+allPR); break;
	    	case 2: finalSeq += ("00"+allPR); break;
	    	case 3: finalSeq += ("0"+allPR); break;
	    	default: finalSeq += (allPR); break;
    	}
    	
    	for(int i=0; i<3; i++) {
    		res+=letter;
    	}
    	
    	res+="-" + (r.nextInt(899)+100) + "-" + letter + finalSeq;
    	return res;
	}

}
