package acme.roles;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;

public class Patron extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Length(min = 1, max = 101)
	protected String company;
	
	@NotBlank
	@Length(min = 1, max = 256)
	protected String statement;
	
	@URL
	protected String link;

}
