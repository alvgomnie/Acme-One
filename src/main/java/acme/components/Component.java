package acme.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Component extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Length(min = 1, max = 101)
	protected String name;
	
	@Column(unique = true)
	@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
	@NotBlank
	@Length(min = 1, max = 101)
	protected String technology;

	@NotBlank
	@Length(min = 1, max = 256)
	protected String description;
	
	@Positive
	protected double retailPrice;
	
	@URL
	protected String link;

}
