package acme.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Quantity extends AbstractEntity{

	protected static final long	serialVersionUID	= 1L;
	
	@Min(0)
	protected Integer amount;
	
	@ManyToOne(optional = true)
	@Valid
	@NotNull
	protected Item item;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Item item;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected Toolkit toolkit;
}
