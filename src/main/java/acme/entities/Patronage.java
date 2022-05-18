package acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import acme.roles.Inventor;
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
	
	@Valid
	protected Money budget;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Past
	protected Date startingDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date finishingDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date timeLapse;
	
	@URL
	protected String link;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Patron patron;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Inventor inventor;
	
	// Derived Methods
	
	@Transient
	protected void getTimeLapse() {
		this.timeLapse = new Date(this.finishingDate.getTime() - this.startingDate.getTime());
	}

}
