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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
public class Chimpum extends AbstractEntity{
	
	protected static final long	serialVersionUID	= 1L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Past
	protected Date creationMoment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date finishingDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date period;
	
	@Column(unique = true)
	@Pattern(regexp = "^[0-9]{2}-[0-9]{2}-[0-9]{2}$")
	private String code;
	
	@NotBlank
	@Length(min=1,max=101)
	protected String title;
	
	@NotBlank
	@Length(min=1,max=256)
	protected String description;
	
	@NotNull
	protected Money budget;
	
	@URL
	private String link;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	protected Item item;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	protected Inventor inventor;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	protected Patron patron;
	
	@Transient
	protected void getPeriod() {
		this.period = new Date(this.finishingDate.getTime() - this.creationMoment.getTime());
	}
}
