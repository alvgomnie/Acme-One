package acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import acme.roles.Patron;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patronage extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	protected PatronageStatus status;
	
	@NotBlank
	@Column(unique=true)
	@Pattern(regexp="^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
	@NotBlank
	@Length(min=1, max=255)
	protected String legalStuff;
	
	@Min(0)
	protected Double budget;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Past
	protected Date startingDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Past
	protected Date finishingDate;
	
	@URL
	protected String link;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Patron patron;

}
